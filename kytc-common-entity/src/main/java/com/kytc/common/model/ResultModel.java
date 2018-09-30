package com.kytc.common.model;

public class ResultModel<T> {
	private Boolean state;      //返回状态
	private String reason;      //原因
	private T data;             //返回结果
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResultModel [state=" + state + ", reason=" + reason + ", data="
				+ data + "]";
	}
	public ResultModel(Boolean state, String reason, T data) {
		super();
		this.state = state;
		this.reason = reason;
		this.data = data;
	}
	public ResultModel() {
		super();
	}
	
}
