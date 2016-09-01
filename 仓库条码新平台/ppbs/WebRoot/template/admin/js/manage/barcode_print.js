function printBigLable(printCode,desc){
	LODOP.PRINT_INIT("条码打印");
	LODOP.SET_PRINT_PAGESIZE(1,"54.4mm","27.2mm","物料标签");//宽度 27.2mm 高度 54.4mm 
	LODOP.ADD_PRINT_BARCODE("1.36mm","1.36mm","13.6mm","13.6mm","QRCode","www.nflg.com");		
	//var path="${rootPath}";
	//var img="<html><img src='"+path+"/template/admin/images/nn.png'></img><html>";
	//LODOP.ADD_PRINT_HTM("2mm","32mm","59mm","15mm",img);
	//LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//(可变形)扩展缩放模式
	LODOP.ADD_PRINT_TEXT("6.8mm","17.68mm","36.04mm","13.6mm",desc);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",6);
	LODOP.ADD_PRINT_BARCODE("17mm","1mm","51mm","6.8mm","128Auto",printCode);
	LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
	//LODOP.ADD_PRINT_TEXT("37mm","20mm","40mm","4mm",printCode);
	//LODOP.SET_PRINT_STYLEA(0,"FontSize",7);   
	//LODOP.SET_PRINT_STYLEA(5,"Horient",2); 
	var htm="<p style=\"word-break:break-all;text-align:center;width:204px;height:13.6px;line-height:10px;font-size:7pt\">"+printCode+"</p>";
	LODOP.ADD_PRINT_HTM("23.8mm","0mm","54.4mm","2.72mm",htm);
	LODOP.SET_PRINT_STYLEA(5,"Horient",2); 
	LODOP.PREVIEW();
//	LODOP.PRINT(); 
	
}

function printLittleLable(printCode,desc){
	LODOP.PRINT_INIT("条码打印");
	LODOP.SET_PRINT_PAGESIZE(1,"41mm","13.6mm","物料标签");//宽度 20mm 高度 60mm 
	LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
	LODOP.ADD_PRINT_BARCODE("1mm","1mm","10.2mm","10.2mm","QRCode","www.nflg.com");		
	//var htm="<p style=\"word-break:break-all;letter-spacing:-1em;width:178px;height:14px;line-height:7px;font-size:6pt\">第三方的是范德萨发发第三方的是范德萨发发第三方的是范德萨发发第三方的是范德萨发发</p>";
	LODOP.ADD_PRINT_TEXT("3mm","8mm","32.6mm","5.4mm",desc);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",4);
	LODOP.ADD_PRINT_BARCODE("8.8mm","2mm","40mm","3.4mm","128Auto",printCode);
	LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
	var html="<p style=\"word-break:break-all;text-align:center;width:145px;height:5px;line-height:3px;font-size:5pt\">"+printCode+"</p>";
	LODOP.ADD_PRINT_HTM("12mm","0mm","41mm","1.3mm",html);
	LODOP.SET_PRINT_STYLEA(5,"Horient",2); 
	LODOP.PREVIEW();
//	LODOP.PRINT(); 
	
	
}