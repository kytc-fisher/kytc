package com.kytc.model.base.premission;

import java.util.List;

public class MenuModel {
	private String menu;
	private String menuName;
	private List<OperatorModel> list;
	private Integer length;
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public List<OperatorModel> getList() {
		return list;
	}
	public void setList(List<OperatorModel> list) {
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
		return "MenuModel [menu=" + menu + ", menuName=" + menuName + ", list="
				+ list + ", length=" + length + "]";
	}
	public MenuModel(String menu, String menuName, List<OperatorModel> list,
			Integer length) {
		super();
		this.menu = menu;
		this.menuName = menuName;
		this.list = list;
		this.length = length;
	}
	public MenuModel() {
		super();
	}
}
