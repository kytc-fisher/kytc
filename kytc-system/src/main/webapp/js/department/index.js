/**
 * 用户首页js
 */
$(function(){
	var main_div = $("#kytc_system_dept_main_div");
	var main_div_list = $("#kytc_system_dept_main_div_list");
	main_div.height($(window).height()-150);
	main_div.off().on("click","a[name='add']",function(){
		$.EasyUI.Window({
			url:$.system.url+"department/add",
			type:"get",
			width:800,
			height:335,
			title:"添加部门信息"
		});
	}).on("click","a[name='update']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.Window({
					url:$.system.url+"department/update?id="+value,
					type:"get",
					width:800,
					height:335,
					title:"修改部门信息"
				});
			}
		});
	}).on("click","a[name='delete']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.message("确定要删除该部门信息吗?",'cf',function(){
					$.ajax({
						url:$.system.url+"department/delete",
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
	}).on("click","a[name='detail']",function(){
		var id = $(this).data("id");
		$.EasyUI.Window({
			url:$.system.url+"department/detail?id="+id,
			type:"get",
			width:800,
			height:335,
			title:"查看部门信息"
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
			url: $.system.url+"department/list",
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
				title:"部门id",
				width:100,
				align:"center",
				sortable:true,
				formatter:function(value){
					return "<a name='detail' data-id='"+value+"'>"+value+"</a>"
				}
			},{
				field:"departmentName",
				title:"部门名称",
				width:100,
				align:"center",
				sortable:true
			},{
				field:"shortName",
				title:"部门简称",
				width:100,
				sortable:true,
				align:"center"
			},{
				field:"parentName",
				title:"上级部门",
				width:100,
				align:"center"
			},{
				field:"leaderName",
				title:"部门领导",
				width:100,
				align:"center"
			},{
				field:"establishTime",
				title:"成立时间",
				sortable:true,
				width:100,
				align:"center",
				formatter:function(value){
					return $.system.toDate(value);
				}
			},{
				field:"sortNum",
				title:"排序号",
				sortable:true,
				width:100,
				align:"center"
			},{
				field:"createTime",
				title:"创建时间",
				width:100,
				align:"center",
				sortable:true,
				formatter:function(value){
					return $.system.toDateTime(value);
				}
			},{
				field:"lastUpdateTime",
				title:"最后更新时间",
				width:100,
				align:"center",
				sortable:true,
				formatter:function(value){
					return $.system.toDateTime(value);
				}
			}]],onLoadSuccess:function(){
			}
		});
	}
})