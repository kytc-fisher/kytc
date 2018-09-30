/**
 * 用户首页js
 */
$(function(){
	var main_div = $("#kytc_system_user_main_div");
	var main_div_list = $("#kytc_system_user_main_div_list");
	main_div.height($(window).height()-150);
	$("#kytc_system_user_title_main_div").title();
	$("#kytc_system_user_dept_main_div").department();
	main_div.off().on("click","a[name='add']",function(){
		$.EasyUI.Window({
			url:$.system.url+"user/add",
			type:"get",
			width:800,
			height:540,
			title:"添加用户"
		});
	}).on("click","a[name='detail']",function(){
		var id = $(this).data("id");
		$.EasyUI.Window({
			url:$.system.url+"user/detail?id="+id,
			type:"get",
			width:800,
			height:533,
			title:"查看用户详情"
		});
	}).on("click","a[name='update']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.Window({
					url:$.system.url+"user/update?id="+value,
					type:"get",
					width:800,
					height:540,
					title:"修改用户信息"
				});
			}
		});
	}).on("click","a[name='delete']",function(){
		$.common.getSelectRow({
			datagridId:main_div_list,
			dataKey:"id",
			success:function(value,row){
				$.EasyUI.message("确定要删除该用户吗?",'cf',function(){
					$.ajax({
						url:$.system.url+"user/delete",
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
	}).on("click","a[name='setRole']",function(){
		var id = $(this).data("id");
		var deptId = $(this).data("dept");
		$.EasyUI.Window({
			url:$.system.url+"userRole/index?userId="+id+"&departmentId="+deptId,
			type:"get",
			width:600,
			height:400,
			title:"分配角色"
		});
	});
	initGrid();
	function initGrid(){
		console.log(main_div.height()-
				$("form[name='search_form']",main_div).height()-$("div[name='btn_div']",main_div).height()-10)
		$("div[name='list']",main_div).height(main_div.height()-
				$("form[name='search_form']",main_div).height()-$("div[name='btn_div']",main_div).height()-10);
		var jsonData=$("form[name='search_form']",main_div).toJSON();
		$.EasyUI.DataGrid({
			gridId:main_div_list,
			/*striped:true,*/
			url: $.system.url+"user/list",
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
				title:"用户ID",
				width:100,
				align:"center",
				formatter:function(value){
					return "<a name='detail' data-id='"+value+"'>"+value+"</a>"
				}
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
			},{
				field:"_id",
				title:"操作",
				width:100,
				align:"center",
				formatter:function(value,row){
					var btn = "";
					btn += "<a name='setRole' data-id='"+row.id+"' data-dept='"+row.departmentId+"'>分配角色</a>";
					return btn;
				}
			}]],onLoadSuccess:function(){
			}
		});
	}
})