/**
 * 用户首页js
 */
$(function(){
	var main_div = $("#kytc_system_title_main_div");
	var main_div_list = $("#kytc_system_title_main_div_list");
	main_div.height($(window).height()-150);
	main_div.off().on("click","a[name='add']",function(){
		$.EasyUI.Window({
			url:$.system.url+"title/add",
			type:"get",
			width:500,
			height:292,
			title:"添加职务信息"
		});
	}).on("click","a[name='update']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				console.log(value,row);
				$.EasyUI.Window({
					url:$.system.url+"title/update?id="+value,
					type:"get",
					width:500,
					height:370,
					title:"修改职务信息"
				});
			}
		});
	}).on("click","a[name='detail']",function(){
		var id = $(this).data("id");
		$.EasyUI.Window({
			url:$.system.url+"title/detail?id="+id,
			type:"get",
			width:500,
			height:370,
			title:"查看职务信息"
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
			url: $.system.url+"title/list",
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
				title:"职务ID",
				width:100,
				align:"center",
				sortable:true,
				formatter:function(value){
					return "<a name='detail' data-id='"+value+"'>"+value+"</a>"
				}
			},{
				field:"name",
				title:"职务名称",
				width:100,
				align:"center",
				sortable:true
			},{
				field:"sortNum",
				title:"排序号",
				width:100,
				sortable:true,
				align:"center"
			},{
				field:"parentName",
				title:"上级名称",
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