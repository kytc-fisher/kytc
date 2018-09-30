package com.kytc.model.base.premission;

import java.util.List;

public class ModuleModel {
	private String module;
	private String moduleName;
	private List<MenuModel> list;
	private Integer length;
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public List<MenuModel> getList() {
		return list;
	}
	public void setList(List<MenuModel> list) {
		this.list = list;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "ModuleModel [module=" + module + ", moduleName=" + moduleName
				+ ", list=" + list + ", length=" + length + "]";
	}
	public ModuleModel(String module, String moduleName, List<MenuModel> list,
			Integer length) {
		super();
		this.module = module;
		this.moduleName = moduleName;
		this.list = list;
		this.length = length;
	}
	public ModuleModel() {
		super();
	}
}
