/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	config.language = 'zh-cn';//语言设置  
    config.uiColor='#CCCCCC';//颜色  
    //config.width='1000px';//宽度  
    config.height='400px';//高度  
    config.skin='kama';//界面
    config.toolbar='Full';//工具栏：Full/Basic  
    
    config.filebrowserBrowseUrl = '/asset/console/js/ckfinder/ckfinder.html' ;
    config.filebrowserImageBrowseUrl = '/asset/console/js/ckfinder/ckfinder.html?type=Images' ;
    config.filebrowserFlashBrowseUrl = '/asset/console/js/ckfinder/ckfinder.html?type=Flash' ;
    config.filebrowserWindowWidth ='50%';
    config.filebrowserWindowHeight ='70%';
    config.toolbar_Full = [['Font','FontSize','Table','HorizontalRule'],
			['NumberedList','BulletedList','Outdent','Indent'],
			['Anchor','PageBreak','SpecialChar','SelectAll','Paste','PasteText','PasteFromWord'],
			['Blockquote','ShowBlocks','Replace'],
			'/',
			['Bold','Italic','Underline','TextColor','BGColor','Link','Unlink','RemoveFormat'],
			['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],['Image','Flash'],
			['Strike','Subscript','Superscript','Undo','Redo','Cut','Copy','Source']
		];
	config.font_names ='宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;'+ config.font_names;
	config.fontSize_sizes ='10/10px;11/11px;12/12px;13/13px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;72/72px';
};
