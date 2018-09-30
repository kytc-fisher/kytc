/**
 * 部门详情.js
 */
$(function(){
	var main_div = $("#kytc_system_dictionary_type_detail_main_div");
	main_div.off().on("click","a[name='close']",function(){
		$.EasyUI.Window.close(main_div);
	});
})