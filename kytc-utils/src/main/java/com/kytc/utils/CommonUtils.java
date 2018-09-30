package com.kytc.utils;

import java.util.ArrayList;
import java.util.List;

import com.kytc.model.ResultModel;
import com.kytc.model.base.PremissionModel;
import com.kytc.model.base.premission.MenuModel;
import com.kytc.model.base.premission.ModuleModel;
import com.kytc.model.base.premission.OperatorModel;
import com.kytc.model.base.premission.ProjectModel;

public class CommonUtils {
	public static <T> ResultModel<T> returnModel(Boolean state,String reason,T t){
		ResultModel<T> result = new ResultModel<T>(state,reason,t);
		return result;
	}
	public static <T> ResultModel<T> returnModel(Boolean state,String reason){
		ResultModel<T> result = new ResultModel<T>(state,reason,null);
		return result;
	}
	public static <T> ResultModel<T> returnModel(T t){
		ResultModel<T> result = new ResultModel<T>(true,null,t);
		return result;
	}
	public static <T> ResultModel<T> returnModel(String reason){
		ResultModel<T> result = new ResultModel<T>(false,reason,null);
		return result;
	}
	public static List<ProjectModel> selectPremission(List<ProjectModel> list,List<String> premissions){
		if(premissions!=null && premissions.size()>0){
			if(list!=null&&list.size()>0){
				for(ProjectModel project:list){
					if(project.getList()!=null&&project.getList().size()>0){
						for(ModuleModel module:project.getList()){
							if(module.getList()!=null&&module.getList().size()>0){
								for(MenuModel menu:module.getList()){
									if(menu.getList()!=null&&menu.getList().size()>0){
										for(OperatorModel operator:menu.getList()){
											if(premissions.contains(operator.getPremission())){
												operator.setIsSelected(true);
											}else{
												operator.setIsSelected(false);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return list;
	}
	public static List<ProjectModel> initPremission(List<PremissionModel> list){
		String project = "";
		String projectName = "";
		String module = "";
		String moduleName = "";
		String menu = "";
		String menuName = "";
		Integer projectLength = 0;
		Integer moduleLength = 0;
		Integer menuLength = 0;
		ProjectModel projectModel = new ProjectModel();
		ModuleModel moduleModel = new ModuleModel();
		MenuModel menuModel = new MenuModel();
		OperatorModel operatorModel = new OperatorModel();
		List<ProjectModel> projectList = new ArrayList<ProjectModel>();
		List<ModuleModel> moduleList = new ArrayList<ModuleModel>();
		List<MenuModel> menuList = new ArrayList<MenuModel>();
		List<OperatorModel> operatorList = new ArrayList<OperatorModel>();
		for(PremissionModel model:list){
			if(project.equals(model.getProject())){
				projectLength ++;
			}else{
				if(moduleList.size()>0){
					projectModel = new ProjectModel(project,projectName,moduleList,projectLength);
					projectList.add(projectModel);
					projectList = null;
					moduleList = new ArrayList<ModuleModel>();
				}
				projectLength = 1;
				project = model.getProject();
				projectName = model.getProjectName();
			}
			if(module.equals(model.getModule())){
				moduleLength ++;
			} else {
				if(menuList.size()>0){
					moduleModel = new ModuleModel(module,moduleName,menuList,moduleLength);
					moduleList.add(moduleModel);
					menuList = null;
					menuList = new ArrayList<MenuModel>();
				}
				moduleLength = 1;
				module = model.getModule();
				moduleName = model.getModuleName();
			}
			if(menu.equals(model.getMenu())){
				menuLength ++;
				operatorModel = new OperatorModel(model.getOperator(),model.getOperateName(),model.getPremission());
				operatorList.add(operatorModel);
			} else {
				if (operatorList.size()>0) {
					menuModel = new MenuModel(menu,menuName,operatorList,menuLength);
					menuList.add(menuModel);
					operatorList = null;
					operatorList = new ArrayList<OperatorModel>();
				}
				menuLength = 1;
				menu = model.getMenu();
				menuName = model.getMenuName();
				operatorModel = new OperatorModel(model.getOperator(),model.getOperateName(),model.getPremission());
				operatorList.add(operatorModel);
			}
		}
		menuModel = new MenuModel(menu,menuName,operatorList,menuLength);
		menuList.add(menuModel);
		moduleModel = new ModuleModel(module,moduleName,menuList,moduleLength);
		moduleList.add(moduleModel);
		projectModel = new ProjectModel(project,projectName,moduleList,projectLength);
		projectList.add(projectModel);
		return projectList;
	}
}
