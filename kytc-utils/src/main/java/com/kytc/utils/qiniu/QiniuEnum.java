package com.kytc.utils.qiniu;

public enum QiniuEnum {
	USER("kytc","user/");
	private String bucket = "kytc";
	private String folder = "folder";
	private String domain = "";
	private QiniuEnum(String bucket,String folder){
		this.bucket = bucket;
		this.folder = folder;
		this.domain = "http://or0kw5mc8.bkt.clouddn.com/";
	}
	public String getBucket(){
		return this.bucket;
	}
	public String getFolder(){
		return this.folder;
	}
	public String getDomain(){
		return this.domain;
	}
}
