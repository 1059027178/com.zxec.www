/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// Define changes to default configuration here. For example: 
	config.language = 'zh-cn'; //配置语言 
	config.uiColor = '#dddddd'; //背景颜色 
	//config.width = 655; //宽度 
	config.height = 100; //高度 
	config.skin='kama'; 
	config.resize_enabled = false;
	//工具栏 
	
		config.toolbar = 
	[ 
	['Font','TextColor','Bold','Italic','Underline','Smiley']
	]; 
	
	/*
	config.toolbar = 
	[ 
	['Bold','Italic','Underline','Strike','-','Subscript','Superscript'], 
	['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'], 
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'], 
	['Link','Unlink','Anchor'], 
	['Image','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'], 
	'/', 
	['Styles','Format','Font','FontSize'], 
	['TextColor','BGColor'], 
	['Maximize', 'ShowBlocks','-','-','Undo','Redo']
	
	]; 
  */
    
	 //回车换行的产生的标签
    //config.enterMode =1; //CKEDITOR.ENTER_P;
    //config.enterMode =3; //CKEDITOR.ENTER_DIV;
    config.enterMode = 2; //CKEDITOR.ENTER_BR;

    // 使用基础工具栏 
    //config.toolbar = "Basic"; 
    // 使用全能工具栏 
    //config.toolbar = "Full"; 
    //使用自定义工具栏 
    /*
    config.toolbar =
     [
     ['Source', 'Preview', '-'],
     ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', ],
     ['Undo', 'Redo', '-', 'Find', 'Replace', '-', 'SelectAll', 'RemoveFormat'],
     ['Image', 'Flash', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBreak'],
     '/',
     ['Bold', 'Italic', 'Underline', '-', 'Subscript', 'Superscript'],
     ['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', 'Blockquote'],
     ['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
     ['Link', 'Unlink', 'Anchor'],
     '/',
     ['Format', 'Font', 'FontSize'],
     ['TextColor', 'BGColor'],
     ['Maximize', 'ShowBlocks', '-', 'About']
     ];
    */

    // Define changes to default configuration here. For example:
    config.filebrowserBrowseUrl = '/ckeditor/uploader/browse.jsp';   
    config.filebrowserImageBrowseUrl = '/ckeditor/uploader/browse.jsp?type=Images';   
    config.filebrowserFlashBrowseUrl = '/ckeditor/uploader/browse.jsp?type=Flashs';   
    config.filebrowserUploadUrl = '/ckeditor/uploader/upload.jsp';   
    config.filebrowserImageUploadUrl = '/ckeditor/uploader/upload.jsp?type=Images';   
    config.filebrowserFlashUploadUrl = '/ckeditor/uploader/upload.jsp?type=Flashs';  
     config.filebrowserWindowWidth = '640'; 
     config.filebrowserWindowHeight = '480';



};
