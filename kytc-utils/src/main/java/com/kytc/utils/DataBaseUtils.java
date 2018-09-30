package com.kytc.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kytc.model.ResultModel;
import com.kytc.model.base.TableColumnModel;

public class DataBaseUtils {
    //数据库中的表名  
    private static String table = "t_pay";  
    //数据库的列名称  
    /*private String[] colnames; // 列名数组  
*/  
	private static String entityName = "";
    //列名类型数组    
    /*private String[] colTypes;  */
    private static String priKey = "";
    private static String priType = "";
    private static List<TableColumnModel> list = new ArrayList<TableColumnModel>();
    /*private Map<String,Object> tableMap = new HashMap<String,Object>();*/
    public static String getDao(){
    	String str = "";
    	str+="public interface "+entityName+"Dao{\n\t"
    			+ "public List<"+entityName+"Entity> list(Map<String,Object> params);\n\t"
    			+ "public Integer count(Map<String,Object> params);\n\t"
    			+ "public Boolean add("+entityName+"Entity entity);\n\t"
    			+ "public Boolean update("+entityName+"Entity entity);\n\t"
    			+ "public Boolean delete("+entityName+"Entity entity);\n\t"
    			+ "public "+entityName+"Model detail("+sqlType2JavaType(priType)+" "+priKey+");\n"
    			+ "}";
    	return str;
    }
    public static String getIService(){
    	String str = "";
    	str+="public interface I"+entityName+"Service{\n\t"
    			+ "public PageResult<"+entityName+"Model> list(Map<String,Object> params);\n\t"
    			+ "public ResultModel<String> add("+entityName+"Entity entity);\n\t"
    			+ "public ResultModel<String> update("+entityName+"Entity entity);\n\t"
    			+ "public ResultModel<String> delete("+entityName+"Entity entity);\n\t"
    			+ "public ResultModel<"+entityName+"Model> detail("+sqlType2JavaType(priType)+" "+priKey+");\n\t"
    			+ "public ResultModel<"+entityName+"Entity> getById("+sqlType2JavaType(priType)+" "+priKey+");\n"
    			+ "}";
    	return str;
    }
    public static String getService(){
    	String daoName = (entityName.charAt(0)+"").toLowerCase()+entityName.substring(1,entityName.length())+"Dao";
    	String str = "";
    	str+="@Service(\""+(entityName.charAt(0)+"").toLowerCase()+entityName.substring(1,entityName.length())+"Service\")\npublic class "+entityName+"Service implements I"+entityName+"Service{\n\t"
    			+ "@Autowired\n\tprivate "+entityName+"Dao "+daoName+";\n\t"
    			+ "public "+entityName+"Dao get"+entityName+"Dao(){\n\t\treturn "+daoName+";\n\t}\n\t"
    			+ "public void set"+entityName+"Dao("+entityName+"Dao "+daoName+"){\n\t\tthis."+daoName+"="+daoName+";\n\t}\n\t"
    			+ "@Override\n\t"
    			+ "public PageResult<"+entityName+"Model> list(Map<String,Object> params){\n\t\t"
    			+ "PageResult<"+entityName+"Model> pageResult = new PageResult<"+entityName+"Model>(params);\n\t\t"
    			+ "List<"+entityName+"Model> list = "+daoName+".list(params);\n\t\t"
    			+ "Integer count = "+daoName+".count(params);\n\t\t"
    			+ "pageResult.setRows(list);\n\t\t"
    			+ "pageResult.setTotal(count);\n\t\t"
    			+ "return pageResult;\n\t}\n\t"
    			+ "@Override\n\t"
    			+ "public ResultModel<String> add("+entityName+"Entity entity){\n\t\t"
    			+ "Boolean result = "+daoName+".add(entity);\n\t\t"
    			+ "if(result){\n\t\t\treturn CommonUtils.returnModel(true,\"添加成功\",null);\n\t\t}else{\n\t\t\t"
    			+ "return CommonUtils.returnModel(false,\"添加失败\",null);\n\t\t}\n\t}\n\t"
    			+ "@Override\n\t"
    			+ "public ResultModel<String> update("+entityName+"Entity entity){\n\t\t"
    			+ "Boolean result = "+daoName+".update(entity);\n\t\t"
    			+ "if(result){\n\t\t\treturn CommonUtils.returnModel(true,\"修改成功\",null);\n\t\t}else{\n\t\t\t"
    			+ "return CommonUtils.returnModel(false,\"修改失败\",null);\n\t\t}\n\t}\n\t"
    			+ "@Override\n\t"
    			+ "public ResultModel<String> delete("+entityName+"Entity entity){\n\t\t"
    			+ "Boolean result = "+daoName+".delete(entity);\n\t\t"
    			+ "if(result){\n\t\t\treturn CommonUtils.returnModel(true,\"删除成功\",null);\n\t\t}else{\n\t\t\t"
    			+ "return CommonUtils.returnModel(false,\"删除失败\",null);\n\t\t}\n\t}\n\t"
    			+ "@Override\n\t"
    			+ "public ResultModel<"+entityName+"Model> detail("+sqlType2JavaType(priType)+" "+priKey+"){\n\t\t"
    			+ "return CommonUtils.returnModel("+daoName+".detail("+priKey+"));\n\t}\n\t"
    			+ "@Override\n\t"
    			+ "public ResultModel<"+entityName+"Entity> getById("+sqlType2JavaType(priType)+" "+priKey+"){\n\t\t"
    			+ "return CommonUtils.returnModel("+daoName+".getById("+priKey+"));\n\t}\n"
    			+ "}";
    	return str;
    }
    public static String getMapping(){
    	String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"+
    			"<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n"+
    			"\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n<!-- namespace必须指向Dao接口 -->\n"+
    			"<mapper namespace=\"com.kytc.dao.base."+entityName+"Dao\">\n"+
    			"\t<select id=\"list\" parameterType=\"java.util.Map\" resultType=\""+entityName+"Entity\">\n"+
    			"\t\tSELECT \n\t\t\t* \n\t\tFROM \n\t\t\t"+table+" \n\t\tLIMIT #{min},#{max} \n\t</select>\n"+
    			"\t<select id=\"count\" parameterType=\"java.util.Map\" resultType=\"Integer\">\n\t\tSELECT \n\t\t\tCOUNT(1) \n\t\t"+
    			"FROM \n\t\t\t"+table+" \n\t</select>";
    	String addStr = "\n\t<insert id=\"add\" parameterType=\""+entityName+"Entity\">\n\t\tinsert into "+table+"(\n";
    	String valueStr = ")\n\t\tvalues(\n";
    	String updateStr = "\n\t<update id=\"update\" parameterType=\""+entityName+"Entity\">\n\t\tupdate \n\t\t\t"+table+" \n\t\tset \n";
    	for(TableColumnModel entity:list){
    		if(!entity.getExtra().equals("auto_increment")){
    			addStr+="\t\t\t"+entity.getColumn_name()+",\n";
    			valueStr+="\t\t\t#{"+entity.getColumn_name()+"},\n";
    		}
    		if(entity.getColumn_key().equals("PRI")){
    			priKey = ""+entity.getColumn_name();
    			priType = ""+entity.getColumn_key();
    		}else{
    			updateStr +="\t\t\t"+entity.getColumn_name()+" = #{"+entity.getColumn_name()+"},\n";
    		}
    	}
    	String detailStr = "\n\t<select id=\"detail\" parameterType=\""+sqlType2JavaType(priType)+"\" resultType=\""+entityName+"Entity\">\n\t\tselect \n\t\t\t* "
    			+ "\n\t\tfrom \n\t\t\t"+table +" \n\t\twhere \n\t\t\t"+priKey+" = #{"+priKey+"}\n\t</select>";
    	addStr = addStr.substring(0,addStr.lastIndexOf(","));
    	valueStr = valueStr.substring(0,valueStr.lastIndexOf(","));
    	addStr += valueStr +")\n\t</insert>";
    	updateStr = updateStr.substring(0,updateStr.lastIndexOf(","));
    	updateStr+=" \n\t\twhere "+priKey+" = #{"+priKey+"}\n\t</update>";
    	String delStr = "\n\t<delete id=\"delete\" parameterType = \""+sqlType2JavaType(priType)+"\">\n\t\tdelete from "+table +" \n\t\twhere \n\t\t\t"+priKey +" = #{"+priKey+"}\n\t</delete>";
    	str+=addStr+updateStr+detailStr+delStr+"\n</mapper>";
    	return str;
    }
    public static String getColumnStr(){
    	String tableStr = "";
    	tableStr += "public class " + entityName;
    	tableStr+="Entity{\n";
    	String column = "";
    	String methodStr = "";
    	String _toString = "\t@Override\n\tpublic String toString(){\n\t\treturn \""+entityName+"Entity [";
    	for(TableColumnModel entity:list){
    		String _type = sqlType2JavaType(entity.getColumn_type());
    		String _field = entity.getColumn_name();
    		column +="\tprivate "+_type+" "+entity.getColumn_name()+";";
    		String comment = entity.getColumn_comment();
    		column+="                 //";
    		if(comment!=null&&!comment.equals("")){
    			column+=comment+";";
    		}
    		if(entity.getColumn_key().equals("PRI")){
    			priKey = ""+entity.getColumn_name();
    			priType = ""+entity.getColumn_key();
    		}
    		String default_ = entity.getColumn_default();
    		column+=(default_==null||default_.equals("")?"":"默认值："+default_);
    		String key = entity.getColumn_key();
    		column+=(key==null||key.equals("")?"":"键："+key);
    		column+="\n";
    		String __field = _field.toUpperCase().charAt(0)+_field.substring(1,_field.length());
    		methodStr += "	public void set" + __field +"("+_type+" " + _field +"){\n\t\tthis."+_field+" = "+_field+";\n\t}\n";
    		methodStr += "	public " + _type + " get"+ __field +"(){\n\t\treturn this." + _field +";\n\t}\n";
    		_toString += ""+entity.getColumn_name()+" = \"+"+entity.getColumn_name()+" + \n\t\t\t\",";
    	}
    	tableStr+=column+methodStr+_toString.substring(0,_toString.lastIndexOf("\t"))+"\"]\";\n\t}\n}";
    	return tableStr;
    }
    /* 
     * mysql的字段类型转化为java的类型*/  
    private static String sqlType2JavaType(String sqlType) {    
        if(sqlType.toLowerCase().contains("int")){    
            return "Integer";    
        }else if(sqlType.toLowerCase().contains("bigint")||sqlType.toLowerCase().contains("long")){    
            return "long";    
        }else if(sqlType.toLowerCase().contains("float")){    
            return "Float";    
        }else if(sqlType.toLowerCase().contains("decimal") || sqlType.toLowerCase().contains("numeric")     
                || sqlType.toLowerCase().contains("real") || sqlType.toLowerCase().contains("money")     
                || sqlType.toLowerCase().contains("smallmoney")){    
            return "Double";    
        }else if(sqlType.toLowerCase().contains("char") ){    
            return "String";    
        }else if(sqlType.toLowerCase().contains("timestamp")||sqlType.toLowerCase().contains("datetime") ||sqlType.toLowerCase().contains("date")){    
            return "Date";    
        }else if(sqlType.equalsIgnoreCase("image")){    
            return "Blod";    
        }    
        return null;    
    }  
    /*获取整个类的字符串并且输出为java文件 
     * */  
    public static ResultModel<String> toFile(String path,String table,List<TableColumnModel> list){  
        //输出的类字符串  
    	DataBaseUtils.table = table;
    	DataBaseUtils.list = list;
    	entityName = "";
    	String className = table.toUpperCase().charAt(0)+table.substring(1,table.length());
    	String []classNames = className.split("_");
    	for(Integer i=0;i<classNames.length;i++){
    		entityName += classNames[i].toUpperCase().charAt(0)+classNames[i].substring(1,classNames[i].length());
    	}
    	entityName = entityName.replace("KytcBase", "");
        //获取表类型和表名的字段名  
        /*getTableInfo();*/
        String columnStr = getColumnStr();
        String mappingStr = getMapping();
        String daoStr = getDao();
        String IServiceStr = getIService();
        String serviceStr = getService();
        
        String[] tableNames = table.split("_");
    	String name = "";
    	for(String _table:tableNames){
    		name+=(_table.charAt(0)+"").toUpperCase()+_table.substring(1,_table.length());
    	}
        //输出到文件中  
    	if(path==null||path.equals("")){
    		path = "";
    	}
        File entityFile = new File(path+name.replace("KytcBase", "")+"Entity.java");  
        File iServiceFile = new File(path+"I"+name.replace("KytcBase", "")+"Service.java");  
        File serviceFile = new File(path+name.replace("KytcBase", "")+"Service.java");  
        File daoFile = new File(path+name.replace("KytcBase", "")+"Dao.java");  
        File mappingFile = new File(path+name.replace("KytcBase", "")+"Mapper.xml");  
        BufferedWriter write = null;  
  
        try {  
            write = new BufferedWriter(new FileWriter(entityFile));  
            write.write(columnStr.toString());  
            write.close();  
            
            write = new BufferedWriter(new FileWriter(iServiceFile));  
            write.write(IServiceStr);  
            write.close(); 
            
            write = new BufferedWriter(new FileWriter(serviceFile));  
            write.write(serviceStr);  
            write.close();
            
            write = new BufferedWriter(new FileWriter(daoFile));  
            write.write(daoStr);  
            write.close();
            
            write = new BufferedWriter(new FileWriter(mappingFile));  
            write.write(mappingStr);  
            write.close();
            ResultModel<String> params = CommonUtils.returnModel(true, "", "导出成功");
            return params;
        } catch (IOException e) {  
            e.printStackTrace();  
            if (write != null){
            	try {  
                    write.close();  
                } catch (IOException e1) {            
                    e1.printStackTrace();  
                }  
            }  
            return CommonUtils.returnModel(false, "", "导出文件失败");
        }  
    }  
    public static void main(String[] args) {
    	toFile("D:\\","kytc_base_dictionary_type",null);
	}
}
