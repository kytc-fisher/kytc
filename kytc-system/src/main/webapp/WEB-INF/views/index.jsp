<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib uri="http://www.kytc.com/premission/auth" prefix="auth"%>
<title>首页</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyloader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/loader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<link href="${pageContext.request.contextPath}/easyui/themes/color.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.tree-node{height:25px;}
.tree-node span{line-height:25px;}
.tree-node .tree-icon{margin-top:4px;}
</style>
</head>
<body class="easyui-layout" id="kytc_system_main_div">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	<div data-options="region:'west',split:true,title:'基础数据'" style="width:220px;">
		<div class="easyui-panel" fit="true" border="false">
             <ul class="easyui-tree" id="kytc_system_index_left_menu">
             	<auth:premission premission="kytc:system:base:title:list"><li data-options="iconCls:'tree_title'"><a data-url="/title/index" data-title="职务管理" style="padding:5px 5px;" icon="tu1201">职务管理</a></li></auth:premission>
             	<auth:premission premission="kytc:system:base:department:list"><li data-options="iconCls:'tree-dept'"><a data-url="/department/index" data-title="部门管理" style="padding:5px 5px;" icon="tu1201">部门管理</a></li></auth:premission>
             	<auth:premission premission="kytc:system:base:user:list"><li data-options="iconCls:'tree-user'"><a data-title="用户管理" data-url="/user/index" style="padding:5px 5px;" icon="tu1201">用户管理</a></li></auth:premission>
             	<auth:premission premission="kytc:system:base:premission:list"><li data-options="iconCls:'tree-premission'"><a data-url="/premission/index" data-title="权限管理" style="padding:5px 5px;" icon="tu1201">权限管理</a></li></auth:premission>
             	<auth:premission premission="kytc:system:base:role:list"><li data-options="iconCls:'tree-role'"><a data-url="/role/index" data-title="角色管理" style="padding:5px 5px;" icon="tu1201">角色管理</a></li></auth:premission>
             	<auth:premission premission="kytc:system:base:dictionary:type:list"><li data-options="iconCls:'tree-type'"><a data-url="/dictionaryType/index" data-title="字典类型" style="padding:5px 5px;" icon="tu1201">字典类型</a></li></auth:premission>
             	<auth:premission premission="kytc:system:base:dictionary:list"><li data-options="iconCls:'tree-dic'"><a data-url="/dictionary/index" data-title="数据字典" style="padding:5px 5px;" icon="tu1201">数据字典</a></li></auth:premission>
<!--              	<li data-options="iconCls:'tree_title'"><a data-url="/title/index" data-title="职务管理" style="padding:5px 5px;" icon="tu1201">职务管理</a></li> -->
<!--              	<li data-options="iconCls:'tree-dept'"><a data-url="/department/index" data-title="部门管理" style="padding:5px 5px;" icon="tu1201">部门管理</a></li> -->
<!--                 <li data-options="iconCls:'tree-user'"><a data-title="用户管理" data-url="/user/index" style="padding:5px 5px;" icon="tu1201">用户管理</a></li> -->
<!--                 <li data-options="iconCls:'tree-premission'"><a data-url="/premission/index" data-title="权限管理" style="padding:5px 5px;" icon="tu1201">权限管理</a></li> -->
<!--                 <li data-options="iconCls:'tree-role'"><a data-url="/role/index" data-title="角色管理" style="padding:5px 5px;" icon="tu1201">角色管理</a></li> -->
<!--                 <li data-options="iconCls:'tree-type'"><a data-url="/dictionaryType/index" data-title="字典类型" style="padding:5px 5px;" icon="tu1201">字典类型</a></li> -->
<!--                 <li data-options="iconCls:'tree-dic'"><a data-url="/dictionary/index" data-title="数据字典" style="padding:5px 5px;" icon="tu1201">数据字典</a></li> -->
            </ul>
        </div>
	</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center'">
		<div name="right_tab" class="easyui-tabs" style="width:100%;height:100%"></div>
	</div>
	<div id="kytc_system_main_div_table_right" class="easyui-menu" style="width:120px;">
		<div name="refresh" data-options="iconCls:'icon-refresh'">刷新</div>
		<div name="close" data-options="iconCls:'icon-close'">关闭当前</div>
		<div name="closeOther" data-options="iconCls:'icon-close'">关闭其他</div>
		<div name="closeAll" data-options="iconCls:'icon-close'">关闭所有</div>
	</div>
	<script type="text/javascript">
	$(function(){
		var main_div = $("#kytc_system_main_div");
		$(document).bind("contextmenu",function(e){
	        return false;
	    });
		$("div[name='right_tab']",main_div).tabs({});
		$("div[name='refresh']",main_div).click(function(){
			var tab = $("div[name='right_tab']",main_div).tabs('getSelected');
			tab.panel('open').panel('refresh');
		});
		$("div[name='close']",main_div).click(function(){
			var tab = $("div[name='right_tab']",main_div).tabs('getSelected');
	        var index = $("div[name='right_tab']",main_div).tabs('getTabIndex',tab);
	        $("div[name='right_tab']",main_div).tabs('close',index);
		});
		$("div[name='closeAll']",main_div).click(function(){
			var tablist = $("div[name='right_tab']",main_div).tabs('tabs');
	        for(var i=tablist.length-1;i>=0;i--){
	        	$("div[name='right_tab']",main_div).tabs('close',i);
	        }
		});
		$("div[name='closeOther']",main_div).click(function(){
			var tablist = $("div[name='right_tab']",main_div).tabs('tabs');
	        var tab = $("div[name='right_tab']",main_div).tabs('getSelected');
	        var index = $("div[name='right_tab']",main_div).tabs('getTabIndex',tab);
	        for(var i=tablist.length-1;i>index;i--){
	        	$("div[name='right_tab']",main_div).tabs('close',i);
	        }
	        var num = index-1;
	        for(var i=num;i>=0;i--){
	        	$("div[name='right_tab']",main_div).tabs('close',0);
	        }
		});
		main_div.on("contextmenu","ul[class='tabs'] li",function(e){
			e.preventDefault();
			$('#kytc_system_main_div_table_right').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		});
		function addPanel(_title,_url){
			if ($("div[name='right_tab']",main_div).tabs('exists', _title)){
				$("div[name='right_tab']",main_div).tabs('select', _title);
			}else {
				if(_url.indexOf("http://")>-1){
					var content = '<iframe scrolling="auto" frameborder="0"  src="'+_url+'" style="width:100%;height:100%;"></iframe>';    
					$("div[name='right_tab']",main_div).tabs('add',{
			            title:_title,    
			            content:content,    
			            closable:true    
			        });   
				}else{
					$("div[name='right_tab']",main_div).tabs('add',{
						title:_title,
						href:"/system"+_url,
						closable:true
					});
				}
			}
			$(".easyui-tabs .panel-body",main_div).height($(window).height()-50-30-15);
		}
		$("#kytc_system_index_left_menu").tree({
		})
		$("#kytc_system_index_left_menu li").click(function(){
			var url = $("a",$(this)).data("url");
			var title = $("a",$(this)).data("title");
			if(url!=undefined&&url!=""){
				addPanel(title,url);
			}
		});
	})
</script>
</body>
</html>