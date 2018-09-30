/**
 * 用户首页js
 */
$(function(){
	var main_div = $("#kytc_system_selector_role_main_div");
	var main_div_list = $("#kytc_system_selector_role_main_div_list");
	var main_div_win = $("#kytc_system_selector_role_win");
	var options = main_div_win.data("options");
	$("#kytc_system_selector_role_dept_main_div").department();
	var init = function(row){
		if(row!=null){
			if(options.roleId.length>0){
				options.roleId.val(row.id);
			}
			if(options.roleName.length>0){
				if(options.roleName.hasClass("easyui-searchbox")){
					options.roleName.searchbox("setValue",row.roleName);
				}else{
					options.roleName.val(row.roleName);
				}
			}
			if(type )
			$.EasyUI.Window.close(main_div);
		}else{
			$.EasyUI.message("请选择一条数据","e");
		}
	};
	var inits = function(rows){
		if(rows!=null&&rows.length>0){
			var options = {
				roleId:"",
				roleName:""
			};
			$.each(rows,function(index,row){
				options.roleId += row.id+",";
				options.roleName += row.roleName+",";
			});
			options.roleId = options.roleId.substr(0,options.roleId.length-1);
			options.roleName = options.roleName.substr(0,options.roleName.length-1);
			init(options);
		}else{
			$.EasyUI.message("请至少选择一条数据","e");
		}
	};
	main_div.off().on("click","a[name='search']",function(){
		main_div_list.datagrid('reload',$("form[name='search_form']",main_div).toJSON());
	}).on("click","a[name='reset']",function(){
		$("form[name='search_form']",main_div).form('clear');
		main_div_list.datagrid('reload',$("form[name='search_form']",main_div).toJSON());
	}).on("click","a[name='sure']",function(){
		if(!options.singleSelect){
			var rows = main_div_list.datagrid("getSelections");
			inits(rows);
		}else{
			var row = main_div_list.datagrid("getSelected");
			init(row);
		}
	}).on("click","a[name='close']",function(){
		$.EasyUI.Window.close(main_div);
	});
	initGrid();
	function initGrid(){
		$("div[name='list']",main_div).height(510-
				$("form[name='search_form']",main_div).height()-10-$("div[name='btn_div']",main_div).height());
		var jsonData=$("form[name='search_form']",main_div).toJSON();
		console.log("单选多选>>>"+options.singleSelect)
		$.EasyUI.DataGrid({
			gridId:main_div_list,
			/*striped:true,*/
			url: $.system.url+"role/list",
			queryParams: jsonData,//关键之处
			fitColumns: true,
			collapsible:false,
			singleSelect:options.singleSelect,
			checkOnSelect:options.checkOnSelect,
			selectOnCheck:options.selectOnCheck,
			nowrap: true,
			pagination: true,
			remoteSort: true,
			border: true,
			rownumbers: false,
			sortName:"sortNum",
		    sortOrder:"asc",
			rowStyler:function(){
				return "height:35px";
			},
			columns: [[{ 
				field: 'CK', 
				title: '', 
				checkbox: true, 
				width: 30 
			},{
				field:"id",
				title:"角色ID",
				width:100,
				align:"center"
			},{
				field:"roleName",
				title:"角色名称",
				width:100,
				align:"center"
			},{
				field:"departmentName",
				title:"所属部门",
				width:100,
				align:"center"
			},{
				field:"type",
				title:"角色类型",
				width:100,
				align:"center",
				formatter:function(value){
					if(value==1){
						return "共享角色";
					}else if(value==2){
						return "部门角色";
					}
					return "未知";
				}
			}]],onLoadSuccess:function(data){
				var rows = main_div_list.datagrid("getRows");
				var idStr = "";
				if(options.userId.length>0){
					idStr = ","+options.userId.val()+",";
				}
				$.each(rows,function(index,row){
					if(idStr.indexOf(","+row.id+",")!=-1){
						main_div_list.datagrid("selectRow",index);
					}
				});
			}
		});
	}
})