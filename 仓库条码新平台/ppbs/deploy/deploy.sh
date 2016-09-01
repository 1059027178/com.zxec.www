#!/bin/bash
echo '使用方法: ./deploy.sh dev 或者 ./deploy.sh prd'
cd /Users/apple/Documents/java4tkw/tofficial/WebRoot/WEB-INF
echo '正在创建部署目录...'
if [ -d "deploy" ]; then
	rm -rf deploy
fi
mkdir deploy
cp -rf ./classes/ ./deploy/classes/
cp -rf ./template/ ./deploy/template/
cp -rf ./*.xml ./deploy/
cp -rf ./*.tld ./deploy/
cd ./deploy/classes/
mv log4j_PRD.properties log4j.properties
rm -rf log4j_PRD.xml
echo '正在修改配置文件...'
cd ./
if  [ "$1" == "dev" ];  then
	sed -i '' 's/zllc,2009/jysoft#2016/g' jdbc.properties
	sed -i '' 's/localhost/jiuyisoft/g' jdbc.properties
	sed -i '' 's/zllc,2009/jysoft#2016/g' quartz.properties
	sed -i '' 's/localhost/jiuyisoft/g' quartz.properties
	cd /Users/apple/Documents/java4tkw/tofficial/WebRoot/WEB-INF/deploy
	tar -zcf ../deploy.tar.gz ./classes/* ./template/* *.xml *.tld
	cd ..
	rm -rf ./deploy
	echo '正在上传部署文件...'	
	scp -P 22 deploy.tar.gz root@www.jiuyisoft.com:/web/www/WebRoot/WEB-INF/
	ssh root@www.jiuyisoft.com "cd /web/www/WebRoot/WEB-INF;tar -zxf deploy.tar.gz;rm -rf deploy.tar.gz;service www restart"
	rm -rf ./deploy.tar.gz
elif [ "$1" == "prd" ]; then
	sed -i '' 's/zllc,2009/jysoft#2016/g' jdbc.properties
	sed -i '' 's/localhost/jiuyisoft/g' jdbc.properties
	sed -i '' 's/zllc,2009/jysoft#2016/g' quartz.properties
	sed -i '' 's/localhost/jiuyisoft/g' quartz.properties
	cd /Users/apple/Documents/java4tkw/tofficial/WebRoot/WEB-INF/deploy
	tar -zcf ../deploy.tar.gz ./classes/* ./template/* *.xml *.tld
	cd ..
	rm -rf ./deploy
	echo '正在上传部署文件...'	
	scp -P 22 deploy.tar.gz root@www.jiuyisoft.com:/web/www/WebRoot/WEB-INF/
	ssh root@www.jiuyisoft.com "cd /web/www/WebRoot/WEB-INF;tar -zxf deploy.tar.gz;rm -rf deploy.tar.gz;service www restart"
	rm -rf ./deploy.tar.gz
fi




