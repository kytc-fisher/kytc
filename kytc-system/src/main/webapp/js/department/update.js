/**
 * 用户添加.js
 */
$(function(){
	var main_div = $("#kytc_system_dept_update_main_div");
	var parent_main_div = $("#kytc_system_dept_main_div");
	var parent_main_div_list = $("#kytc_system_dept_main_div_list");
	$("#kytc_system_dept_update_parent_main_div").department();
	$("#kytc_system_dept_update_leader_main_div").searchbox({
	    searcher:function(value,name){
	    	$.common.user({
	    		singleSelect:true,
				userId:$("input[name='leaderId']",main_div),
				nickName:$("#kytc_system_dept_add_leader_main_div")
	    	});
        }
    });
	main_div.off().on("click","a[name='close']",function(){
		$.EasyUI.Window.close(main_div);
	}).on("click","a[name='save']",function(){
		if(main_div.form('validate')){
			var jsonData = main_div.toJSON();
			if(jsonData.id==jsonData.parentId){
				$.EasyUI.message("不能选择自己作为上级部门","e");
				return;
			}
			$.ajax({
				url:$.system.url+"department/update",
				type:"post",
				data:jsonData,
				dataType:"json",
				success:function(data){
					if(data.state){
						parent_main_div_list.datagrid('reload',$("form[name='search_form']",parent_main_div).toJSON());
						$.EasyUI.Window.close(main_div);
					}else{
						$.EasyUI.message(data.reason,"s",null);
						return;
					}
				}
			})
		}
	});
})