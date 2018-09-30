/**
 * 用户首页js
 */
$(function(){
	var main_div = $("#kytc_system_dictionary_main_div");
	var main_div_list = $("#kytc_system_dictionary_main_div_list");
	main_div.height($(window).height()-150);
	$("#kytc_system_dictionary_main_div_type").dicType();
	$("#kytc_system_dictionary_main_div_parent_type").dicType();
	$("#kytc_system_dictionary_main_div_parent_code").dic({
		parentDicType:$("#kytc_system_dictionary_main_div_parent_type")
	});
	main_div.off().on("click","a[name='add']",function(){
		$.EasyUI.Window({
			url:$.system.url+"dictionary/add",
			type:"get",
			width:800,
			height:295,
			title:"添加数据字典"
		});
	}).on("click","a[name='detail']",function(){
		var id = $(this).data("id");
		$.EasyUI.Window({
			url:$.system.url+"dictionary/detail?id="+id,
			type:"get",
			width:800,
			height:330,
			title:"查看数据字典详情"
		});
	}).on("click","a[name='update']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.Window({
					url:$.system.url+"dictionary/update?id="+value,
					type:"get",
					width:800,
					height:295,
					title:"修改数据字典"
				});
			}
		});
	}).on("click","a[name='delete']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.message("确定要删除该数据字典吗?",'cf',function(){
					$.ajax({
						url:$.system.url+"dictionary/delete",
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
			url: $.system.url+"dictionary/list",
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
				title:"字典ID",
				width:100,
				align:"center",
				formatter:function(value){
					return "<a name='detail' data-id='"+value+"'>"+value+"</a>"
				}
			},{
				field:"typeName",
				title:"字典类型",
				width:100,
				align:"center"
			},{
				field:"code",
				title:"数据编码",
				width:100,
				align:"center"
			},{
				field:"name",
				title:"字典名称",
				width:200,
				align:"center"
			},{
				field:"parentTypeName",
				title:"上级类型",
				width:200,
				align:"center"
			},{
				field:"parentCodeName",
				title:"上级编码",
				width:200,
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