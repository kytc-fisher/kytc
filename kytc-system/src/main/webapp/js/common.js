/**
 * 公共js的操作
 */
(function($){
	Date.prototype.format = function(format) {
		   var date = {
		      "M+": this.getMonth() + 1,
		      "d+": this.getDate(),
		      "h+": this.getHours(),
		      "m+": this.getMinutes(),
		      "s+": this.getSeconds(),
		      "q+": Math.floor((this.getMonth() + 3) / 3),
		      "S+": this.getMilliseconds()
		   };
		   if (/(y+)/i.test(format)) {
		          format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
		   }
		   for (var k in date) {
		          if (new RegExp("(" + k + ")").test(format)) {
		                 format = format.replace(RegExp.$1, RegExp.$1.length == 1
		                        ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
		          }
		   }
		   return format;
		};
	$.system=function(){};
	$.system.url="/system/";
	$.system.http = "http://localhost"+$.system.url;
	$.system.toDate = function(timestamp){
		var date = new Date(timestamp);
		return date.format('yyyy-MM-dd')
	};
	$.system.toDateTime = function(timestamp){
		var date = new Date(timestamp);
		return date.format('yyyy-MM-dd hh:mm:ss')
	};
})(jQuery);
(function($){
	$.common=function(){};
	$.common.getSelectRow = function(option){
		var defaultOption = {
			datagridId:"",
			moreRowsInfo:"一次只能操作一条数据",
			nullRowsInfo:"请选择要操作的数据",
			dataKey:"",
			success:function(value,row){}
		};
		var options = $.extend(defaultOption,option);
		var rows = options.datagridId.datagrid('getSelections');
		if(rows==null||rows.length<1){
			$.EasyUI.message(options.nullRowsInfo,"s",null);
			return;
		}else if(rows.length>1){
			$.EasyUI.message(options.moreRowsInfo,"s",null);
			return;
		}else{
			var value = eval("rows[0]."+options.dataKey);
			options.success(value,rows[0]);
		}
	};
	$.common.getSelectRows = function(option){
		var defaultOption = {
			datagridId:"",
			nullRowsInfo:"请选择要操作的数据",
			dataKey:"",
			success:function(value,row){}
		};
		var options = $.extend(defaultOption,option);
		var rows = options.datagridId.datagrid('getSelections');
		if(rows==null||rows.length<1){
			$.EasyUI.message(options.nullRowsInfo,"s",null);
			return;
		}else{
			var array = [];
			for(var row in rows){
				array.push(eval("row."+options.dataKey));
			}
			options.success(array,rows);
		}
	};
	$.common.user = function(option){
		var defaultOption = {
			singleSelect:false,
			checkOnSelect:true,
			selectOnCheck:true,
			userId:"",
			nickName:"",
			realName:"",
			departmentId:"",
			departmentName:"",
			titleId:"",
			titleName:""
		};
		var options = $.extend(defaultOption,option);
		$.EasyUI.Window({
			url:$.system.url+"selector/user",
			type:"get",
			width:800,
			height:550,
			params:options,
			title:"用户选择器",
			winId:"kytc_system_selector_user_win"
		});
	};
	$.common.role = function(option){
		var defaultOption = {
			singleSelect:false,
			checkOnSelect:true,
			selectOnCheck:true,
			userId:"",
			nickName:"",
			realName:"",
			departmentId:"",
			departmentName:"",
			titleId:"",
			titleName:""
		};
		var options = $.extend(defaultOption,option);
		$.EasyUI.Window({
			url:$.system.url+"selector/role",
			type:"get",
			width:800,
			height:550,
			params:options,
			title:"角色选择器",
			winId:"kytc_system_selector_role_win"
		});
	};
	$.common.uploadImg=function(options){
		var defaultOptions = {
			uploadId:"",
			formId:"",
			fileId:"",
			previewId:"",
			hiddenId:"",
			before:function(){return true;},
			success:function(){}
		};
		options = $.extend(defaultOptions, options || {});
		if(options.uploadId.length>0){
			options.uploadId.unbind().click(function(){
				var flag = options.before();
				if(flag == true) {
					options.fileId.click();
				}
				return false;
			});
		}
		options.formId.submit(function () {   
			options.formId.ajaxSubmit({
	            type: "post",
	            url: $.system.url+"upload/image",
	            contentType:"text/html",
	            dataType:"json",
	            success: function (data) {
	            	console.log(data)
	            	if(data.state){
	            		options.previewId.attr("src",data.data).show();
	            		options.hiddenId.val(data.data);
	            		options.success();
	            	}else{
	            		$.EasyUI.message(data.reason,"e");
	            	}
	            },error: function (msg) {
	            	$.EasyUI.message(data.reason,"e");
	            }
	        });
	        return false;
	    });
		options.fileId.change(function(){
			options.formId.submit();
		})
	};	
})(jQuery);
(function($){
	$.fn.title = function() {
		var original = $(this).data("original");
		original = original==null?"":original;
		var _that = $(this);
		$(this).combobox({     
		    url:$.system.url+"title/dropdown",     
		    valueField:'value',     
		    textField:'text',
		    method:"get",
		    onLoadSuccess : function(){
		    	_that.combobox('setValue',original);   
	        },loadFilter:function(data){
                var obj={};  
                obj.value='';  
                obj.text='-请选择-'  
                data.splice(0,0,obj)//在数组0位置插入obj,不删除原来的元素  
                return data;  
	        }  
		});
    };
    $.fn.department = function() {
		var original = $(this).data("original");
		original = original==null?"":original;
		var _that = $(this);
		$(this).combobox({     
		    url:$.system.url+"department/dropdown",     
		    valueField:'value',     
		    textField:'text',
		    method:"get",
		    onLoadSuccess : function(data){
		    	_that.combobox('setValue',original);   
	        },loadFilter:function(data){
                var obj={};  
                obj.value='';  
                obj.text='-请选择-'  
                data.splice(0,0,obj)//在数组0位置插入obj,不删除原来的元素  
                return data;  
	        }  
		});
    };
    $.fn.dicType = function() {
		var original = $(this).data("original");
		var _that = $(this);
		original = original==null?"":original;
		$(this).combobox({     
		    url:$.system.url+"dictionaryType/dropdown",     
		    valueField:'value',     
		    textField:'text',
		    method:"get",
		    onLoadSuccess : function(){  
		    	_that.combobox('setValue',original);   
	        },loadFilter:function(data){
                var obj={};  
                obj.value='';  
                obj.text='-请选择-'  
                data.splice(0,0,obj)//在数组0位置插入obj,不删除原来的元素  
                return data;  
	        }  
		});
    };
    $.fn.dic = function(options) {
    	var defaultOptions = {
			parentDicType:"",
			parentDic:"",
			parentType:"",
			type:""
		};
		options = $.extend(defaultOptions, options || {});
		var original = $(this).data("original");
		original = original==null?"":original;
		var _that = $(this);
		if(options.parentDicType.length>0){
			options.parentDicType.combobox({
				onSelect: function (row) { 
                    if (row != null) {  
                    	_that.combobox({  
                    		method:"get",
                            url: $.system.url+"dictionary/dropdown?type=" + row.value, 
                		    onLoadSuccess : function(){  
	            		    	_that.combobox('setValue',original);   
	            	        },loadFilter:function(data){
	                            var obj={};  
	                            obj.value='';  
	                            obj.text='-请选择-'  
	                            data.splice(0,0,obj)//在数组0位置插入obj,不删除原来的元素  
	                            return data;  
	            	        } 
                        });  
                    }  
                }  
			});
			return;
		}
		if(options.type!=null&&options.type!=""){
			if(options.parentType.length<1){
				_that.combobox({  
            		method:"get",
                    url: $.system.url+"dictionary/dropdown?type=" + options.type, 
        		    onLoadSuccess : function(data){
        		    	_that.combobox('setValue',original);   
        	        },loadFilter:function(data){
                        var obj={};  
                        obj.value='';  
                        obj.text='-请选择-'  
                        data.splice(0,0,obj)//在数组0位置插入obj,不删除原来的元素  
                        return data;  
        	        }  
                });  
				return;
			}else{
				options.parentDic.combobox({
					onSelect: function (row) { 
	                    if (row != null) {  
	                    	_that.combobox({  
	                    		method:"get",
	                            url: $.system.url+"dictionary/dropdown",
	                            queryParams:{"parentType":options.parentType,"type":options.type,"parentCode":row.value},
	                		    onLoadSuccess : function(data){  
		            		    	_that.combobox('setValue',original);   
		            	        },loadFilter:function(data){
		                            var obj={};  
		                            obj.value='';  
		                            obj.text='-请选择-'  
		                            data.splice(0,0,obj)//在数组0位置插入obj,不删除原来的元素  
		                            return data;  
		            	        } 
	                        });  
	                    }  
	                }  
				});
				return;
			}
		}
    };
})(jQuery);