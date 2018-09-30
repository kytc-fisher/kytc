/**
 * 用户分配角色js
 */
$(function(){
	var main_div = $("#kytc_system_user_role_main_div");
	var userId = $("input[name='userId']",main_div).val();
	main_div.off().on("change","input",function(){
		var roleId = $(this).closest("label").data("id");
		var roleName = $(this).closest("label").data("name");
		if($(this).prop("checked")){
			$(this).closest("label").addClass("active");
			$.ajax({
				url:$.system.url+"userRole/add",
				type:"post",
				data:{"userId":userId,"roleId":roleId},
				dataType:"json",
				success:function(data){
					if(data.state){
						$("div.right_role",main_div).append("<em data-id='"+roleId+"' data-name='"+roleName+"'><u>"+roleName+"</u><i></i></em>");
					}
				}
			});
		}else{
			$(this).closest("label").removeClass("active");
			$.ajax({
				url:$.system.url+"userRole/delete",
				type:"post",
				data:{"userId":userId,"roleId":roleId},
				dataType:"json",
				success:function(data){
					if(data.state){
						$("div.right_role em[data-id='"+roleId+"']",main_div).remove();
					}
				}
			});
		}
	}).on("click","div.right_role i",function(){
		var roleId = $(this).closest("em").data("id");
		$("label[data-id='"+roleId+"'] input").prop("checked",false).trigger("change");
	});
})