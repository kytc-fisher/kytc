/**
 * 用户首页js
 */
$(function(){
	var main_div = $("#kytc_system_role_main_div");
	var main_div_list = $("#kytc_system_role_main_div_list");
	main_div.height($(window).height()-150);
	$("#kytc_system_role_main_div_dept").department();
	main_div.off().on("click","a[name='add']",function(){
		$.EasyUI.Window({
			url:$.system.url+"role/add",
			type:"get",
			width:600,
			height:335,
			title:"添加角色"
		});
	}).on("click","a[name='detail']",function(){
		var id = $(this).data("id");
		$.EasyUI.Window({
			url:$.system.url+"role/detail?id="+id,
			type:"get",
			width:800,
			height:600,
			title:"查看角色详情"
		});
	}).on("click","a[name='set']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.Window({
					url:$.system.url+"rolePremission/index?roleId="+value,
					type:"get",
					width:800,
					height:550,
					title:"设置权限"
				});
			}
		});
	}).on("click","a[name='update']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.Window({
					url:$.system.url+"role/update?id="+value,
					type:"get",
					width:600,
					height:335,
					title:"修改角色"
				});
			}
		});
	}).on("click","a[name='delete']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.message("确定要删除该角色吗?",'cf',function(){
					$.ajax({
						url:$.system.url+"role/delete",
						data:{"id":value},
						type:"post",
						dataType:"json",
						success:function(data){
							if(data.state){
								main_div_list.datagrid('reload',$("form[name='search_form']",main_div).toJSON());
							}else{
								$.EasyUI.message(data.reason,"e");
							}
						}
					})
				})
			}
		});
	}).on("click","a[name='search']",function(){
		main_div_list.datagrid('reload',$("form[name='search_form']",main_div).toJSON());
	}).on("click","a[name='reset']",function(){
		$("form[name='search_form']",main_div).form('clear');
		main_div_list.datagrid('reload',$("form[name='search_form']",main_div).toJSON());
	});
	initGrid();
	function initGrid(){
		$("div[name='list']",main_div).height(main_div.height()-
				$("form[name='search_form']",main_div).height()-$("div[name='btn_div']",main_div).height()-10);
		var jsonData=$("form[name='search_form']",main_div).toJSON();
		$.EasyUI.DataGrid({
			gridId:main_div_list,
			/*striped:true,*/
			url: $.system.url+"role/list",
			queryParams: jsonData,//关键之处
			fitColumns: true,
			collapsible:false,
			nowrap: true,
			singleSelect: true,
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
				title:"角色ID",
				width:100,
				align:"center",
				formatter:function(value){
					return "<a name='detail' data-id='"+value+"'>"+value+"</a>"
				}
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
				width:200,
				align:"center",
				formatter:function(value){
					if(value==1){
						return "共享角色";
					}else if(value==2){
						return "部门角色";
					}
					return "未知"
				}
			},{
				field:"sortNum",
				title:"排序号",
				width:200,
				align:"center"
			},{
				field:"createTime",
				title:"创建时间",
				width:100,
				align:"center",
				formatter:function(value){
					return $.system.toDateTime(value);
				}
			},{
				field:"lastUpdateTime",
				title:"最后更新时间",
				width:100,
				align:"center",
				formatter:function(value){
					return $.system.toDateTime(value);
				}
			}]]
		});
	}
})