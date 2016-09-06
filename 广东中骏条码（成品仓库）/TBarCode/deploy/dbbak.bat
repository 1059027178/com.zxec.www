mysqldump --default-character-set=utf8 --skip-lock-tables -h localhost -P 3306 -uroot -pqq901209 thinkway > %date:~0,10%_zjmuseum.sql  

forfiles /d -7 /m *.sql /c "cmd /c del /f @file" 