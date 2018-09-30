/**
 * 用户首页js
 */
$(function(){
	var main_div = $("#kytc_system_premission_main_div");
	var main_div_list = $("#kytc_system_premission_main_div_list");
	main_div.height($(window).height()-150);
	$("#kytc_system_premission_main_div_project").dic({
		type:"KYTC_PROJECT"
	});
	$("#kytc_system_premission_main_div_module").dic({
		parentType:"KYTC_PROJECT",
		type:"KYTC_MODULE",
		parentDic:$("#kytc_system_premission_main_div_project")
	});
	$("#kytc_system_premission_main_div_menu").dic({
		parentType:"KYTC_MODULE",
		type:"KYTC_MENU",
		parentDic:$("#kytc_system_premission_main_div_module")
	});
	$("#kytc_system_premission_main_div_operator").dic({
		type:"KYTC_OPERATOR"
	});
	main_div.off().on("click","a[name='add']",function(){
		$.EasyUI.Window({
			url:$.system.url+"premission/add",
			type:"get",
			width:800,
			height:295,
			title:"添加权限"
		});
	}).on("click","a[name='detail']",function(){
		var id = $(this).data("id");
		$.EasyUI.Window({
			url:$.system.url+"premission/detail?id="+id,
			type:"get",
			width:800,
			height:290,
			title:"查看权限详情"
		});
	}).on("click","a[name='update']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.Window({
					url:$.system.url+"premission/update?id="+value,
					type:"get",
					width:800,
					height:295,
					title:"修改权限"
				});
			}
		});
	}).on("click","a[name='delete']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.message("确定要删除该权限吗?",'cf',function(){
					$.ajax({
						url:$.system.url+"premission/delete",
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
			url: $.system.url+"premission/list",
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
				title:"权限ID",
				width:100,
				align:"center",
				formatter:function(value){
					return "<a name='detail' data-id='"+value+"'>"+value+"</a>"
				}
			},{
				field:"projectName",
				title:"项目名称",
				width:100,
				align:"center"
			},{
				field:"moduleName",
				title:"模块名称",
				width:100,
				align:"center"
			},{
				field:"menuName",
				title:"菜单名称",
				width:200,
				align:"center"
			},{
				field:"operateName",
				title:"操作名称",
				width:200,
				align:"center"
			},{
				field:"premission",
				title:"权限",
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