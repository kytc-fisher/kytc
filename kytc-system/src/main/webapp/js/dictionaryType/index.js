/**
 * 用户首页js
 */
$(function(){
	var main_div = $("#kytc_system_dictionary_type_main_div");
	var main_div_list = $("#kytc_system_dictionary_type_main_div_list");
	main_div.height($(window).height()-150);
	main_div.off().on("click","a[name='add']",function(){
		$.EasyUI.Window({
			url:$.system.url+"dictionaryType/add",
			type:"get",
			width:600,
			height:295,
			title:"添加字典类型"
		});
	}).on("click","a[name='detail']",function(){
		var id = $(this).data("id");
		$.EasyUI.Window({
			url:$.system.url+"dictionaryType/detail?id="+id,
			type:"get",
			width:600,
			height:370,
			title:"查看字典类型详情"
		});
	}).on("click","a[name='update']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.Window({
					url:$.system.url+"dictionaryType/update?id="+value,
					type:"get",
					width:600,
					height:295,
					title:"修改字典类型"
				});
			}
		});
	}).on("click","a[name='delete']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.message("确定要删除该字典类型吗?",'cf',function(){
					$.ajax({
						url:$.system.url+"dictionaryType/delete",
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
			url: $.system.url+"dictionaryType/list",
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
				title:"字典类型ID",
				width:100,
				align:"center",
				formatter:function(value){
					return "<a name='detail' data-id='"+value+"'>"+value+"</a>"
				}
			},{
				field:"code",
				title:"编码",
				width:100,
				align:"center"
			},{
				field:"name",
				title:"名称",
				width:100,
				align:"center"
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