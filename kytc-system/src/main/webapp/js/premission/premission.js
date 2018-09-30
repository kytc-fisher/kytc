/**
 * 设置权限.js
 */
$(function(){
	var main_div = $("#kytc_system_premission_premission_main_div");
	var selectPrev = function(name,value){
		if($("input[data-"+name+"='"+value+"']",main_div).length==$("input[data-"+name+"='"+value+"']:checked",main_div).length){
			$("input[data-value='"+value+"']",main_div).prop("checked",true);
			if(name=="menu"){
				var module = $("input[data-value='"+value+"']",main_div).data("module");
				selectPrev("module",module);
			}else if(name=="module"){
				var project = $("input[data-value='"+value+"']",main_div).data("project");
				selectPrev("project",project);
			}else{
				return ;
			}
		}else{
			$("input[data-value='"+value+"']",main_div).prop("checked",false);
			if(name=="menu"){
				var module = $("input[data-value='"+value+"']",main_div).data("module");
				selectPrev("module",module);
			}else if(name=="module"){
				var project = $("input[data-value='"+value+"']",main_div).data("project");
				selectPrev("project",project);
			}else{
				return ;
			}
		}
	};
	var roleId = $("input[name='id']",main_div).val();
	var addPremission = function(premission){
		$.ajax({
			url:$.system.url + "rolePremission/add",
			data:{"roleId":roleId,"premission":premission},
			type:"post",
			dataType:"json",
			success:function(data){
				console.log(data)
			}
		});
	};
	var delPremission = function(premission){
		$.ajax({
			url:$.system.url + "rolePremission/delete",
			data:{"roleId":roleId,"premission":premission},
			type:"post",
			dataType:"json",
			success:function(data){
				console.log(data)
			}
		});
	};
	main_div.off().on("change","input[name='premission']",function(){
		var premission = $(this).data("value");
		var menu = $(this).data("menu");
		if($(this).prop("checked")){
			var premissionList = premission.substr(0,premission.lastIndexOf(":")+1)+"list";
			addPremission(premission);
			if($("input[data-value='"+premissionList+"']",main_div).length>0){
				if(!$("input[data-value='"+premissionList+"']",main_div).prop("checked")){
					$("input[data-value='"+premissionList+"']",main_div).prop("checked",true);
					addPremission(premissionList);
				}
			}
		}else{
			var tail = premission.substr(premission.lastIndexOf(":")+1,premission.length);
			var prefix = premission.substr(0,premission.lastIndexOf(":")+1)
			if(tail=="list"){
				$("input[data-value^='"+prefix+"']",main_div).each(function(){
					$(this).prop("checked",false);
					delPremission($(this).data("value"));
				});
			}
			delPremission(premission);
		}
		selectPrev("menu",menu);
	}).on("change","input[name='menu']",function(){
		var menu = $(this).data("value");
		var module = $(this).data("module");
		if($(this).prop("checked")){
			$("input[data-menu='"+menu+"']",main_div).prop("checked",true).trigger("change");
			selectPrev("menu",menu);
		}else{
			$("input[data-menu='"+menu+"']",main_div).prop("checked",false).trigger("change");
			$("input[data-value='"+module+"']",main_div).prop("checked",false);
		}
		selectPrev("module",module);
	}).on("change","input[name='module']",function(){
		console.log($(this).data("value"))
		var module = $(this).data("value");
		var project = $(this).data("project");
		if($(this).prop("checked")){
			$("input[data-module='"+module+"']",main_div).prop("checked",true).trigger("change");
		}else{
			$("input[data-module='"+module+"']",main_div).prop("checked",false).trigger("change");
		}
		selectPrev("project",project);
	}).on("change","input[name='project']",function(){
		console.log($(this).data("value"))
		var project = $(this).data("value");
		if($(this).prop("checked")){
			$("input[data-project='"+project+"']",main_div).prop("checked",true).trigger("change");
		}else{
			$("input[data-project='"+project+"']",main_div).prop("checked",false).trigger("change");
		}
	});
})