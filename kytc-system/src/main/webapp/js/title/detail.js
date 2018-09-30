/**
 * 用户添加.js
 */
$(function(){
	var main_div = $("#kytc_system_title_detail_main_div");
	main_div.off().on("click","a[name='close']",function(){
		$.EasyUI.Window.close(main_div);
	});
})