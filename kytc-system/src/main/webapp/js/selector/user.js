/**
 * 用户首页js
 */
$(function(){
	var main_div = $("#kytc_system_selector_user_main_div");
	var main_div_list = $("#kytc_system_selector_user_main_div_list");
	var main_div_win = $("#kytc_system_selector_user_win");
	var options = main_div_win.data("options");
	$("#kytc_system_selector_user_title_main_div").title();
	$("#kytc_system_selector_user_dept_main_div").department();
	var init = function(row){
		if(row!=null){
			if(options.userId.length>0){
				options.userId.val(row.id);
			}
			if(options.nickName.length>0){
				if(options.nickName.hasClass("easyui-searchbox")){
					options.nickName.searchbox("setValue",row.nickName);
				}else{
					options.nickName.val(row.nickName);
				}
			}
			if(options.realName.length>0){
				if(options.realName.hasClass("easyui-searchbox")){
					options.realName.searchbox("setValue",row.realName);
				}else{
					options.realName.val(row.realName);
				}
			}
			if(options.departmentId.length>0){
				options.departmentId.val(row.departmentId);
			}
			if(options.departmentName.length>0){
				options.departmentName.val(row.departmentName);
			}
			if(options.titleId.length>0){
				options.titleId.val(row.titleId);
			}
			if(options.titleName.length>0){
				options.titleName.val(row.titleName);
			}
			$.EasyUI.Window.close(main_div);
		}else{
			$.EasyUI.message("请选择一条数据","e");
		}
	};
	var inits = function(rows){
		if(rows!=null&&rows.length>0){
			var options = {
				id:"",
				nickName:"",
				realName:"",
				departmentId:"",
				departmentName:"",
				titleId:"",
				titleName:""
			};
			$.each(rows,function(index,row){
				options.id += row.id+",";
				options.nickName += row.nickName+",";
				options.realName += row.realName+",";
				options.departmentId += row.departmentId+",";
				options.departmentName += row.departmentName+",";
				options.titleId += row.titleId+",";
				options.titleName += row.titleName+",";
			});
			options.id = options.id.substr(0,options.id.length-1);
			options.nickName = options.nickName.substr(0,options.nickName.length-1);
			options.realName = options.realName.substr(0,options.realName.length-1);
			options.departmentId = options.departmentId.substr(0,options.departmentId.length-1);
			options.departmentName = options.departmentName.substr(0,options.departmentName.length-1);
			options.titleId = options.titleId.substr(0,options.titleId.length-1);
			options.titleName = options.titleName.substr(0,options.titleName.length-1);
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
		$.EasyUI.DataGrid({
			gridId:main_div_list,
			/*striped:true,*/
			url: $.system.url+"user/list",
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
				title:"用户ID",
				width:100,
				align:"center"
			},{
				field:"nickName",
				title:"用户昵称",
				width:100,
				align:"center"
			},{
				field:"realName",
				title:"真实名字",
				width:100,
				align:"center"
			},{
				field:"sex",
				title:"性别",
				width:100,
				align:"center",
				formatter:function(value){
					switch(value){
					case 0:
					    return "未知的性别";
					case 1:
						return "男性";
					case 2:
					    return "女性";
					case 5:
						return "女性改（变）为男性";
					case 6:
					    return "男性改（变）为女性";
					case 9:
						return "未说明的性别";
					default:
						return "未说明的性别";
					}
				}
			},{
				field:"birthday",
				title:"出生日期",
				width:100,
				align:"center",
				formatter:function(value){
					return $.system.toDate(value);
				}
			},{
				field:"shortName",
				title:"部门名称",
				width:200,
				align:"center",
				formatter:function(value,row){
					var btn = '<a href="#" data-id="'+row.departmentId+'" name="department" \
						>'+value+'</a>';
					return btn;
				}
			},{
				field:"titleName",
				title:"职务",
				width:100,
				align:"center",
				formatter:function(value,row){
					var btn = '<a href="#" data-id="'+row.titleId+'" name="title" \
						>'+value+'</a>';
					return btn;
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