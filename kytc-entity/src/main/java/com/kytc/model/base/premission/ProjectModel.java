package com.kytc.model.base.premission;

import java.util.List;

public class ProjectModel {
	private String project;
	private String projectName;
	private List<ModuleModel> list;
	private Integer length;
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<ModuleModel> getList() {
		return list;
	}
	public void setList(List<ModuleModel> list) {
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
		return "ProjectModel [project=" + project + ", projectName="
				+ projectName + ", list=" + list + ", length=" + length + "]";
	}
	public ProjectModel(String project, String projectName,
			List<ModuleModel> list, Integer length) {
		super();
		this.project = project;
		this.projectName = projectName;
		this.list = list;
		this.length = length;
	}
	public ProjectModel() {
		super();
	}
}
