package com.kytc.common.utils.qiniu;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.kytc.common.model.ResultModel;
import com.kytc.common.utils.CommonUtils;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.persistent.FileRecorder;
import com.qiniu.util.Auth;

public class QiniuUtils {
	public static String upload(String filePath,QiniuEnum config,String fileName){
		Configuration cfg = new Configuration(Zone.zone2());
		Auth auth = Auth.create(QiniuConfig.AK, QiniuConfig.SK);
		String upToken = auth.uploadToken(config.getBucket());
		String localTempDir = Paths.get(System.getenv("java.io.tmpdir"), config.getBucket()).toString();
		try {
		    //设置断点续传文件进度保存目录
		    FileRecorder fileRecorder = new FileRecorder(localTempDir);
		    UploadManager uploadManager = new UploadManager(cfg, fileRecorder);
		    try {
		        Response response = uploadManager.put(filePath, config.getFolder()+fileName, upToken);
		        //解析上传成功的结果
		        new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		        return config.getDomain()+config.getFolder()+fileName;
		    } catch (QiniuException ex) {
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		return "";
	}
	public static String upload(byte[] datas,QiniuEnum config,String fileName){
		Configuration cfg = new Configuration(Zone.zone2());
		Auth auth = Auth.create(QiniuConfig.AK, QiniuConfig.SK);
		String upToken = auth.uploadToken(config.getBucket());
		String localTempDir = Paths.get(System.getenv("java.io.tmpdir"), config.getBucket()).toString();
		try {
		    //设置断点续传文件进度保存目录
		    FileRecorder fileRecorder = new FileRecorder(localTempDir);
		    UploadManager uploadManager = new UploadManager(cfg, fileRecorder);
		    try {
		        Response response = uploadManager.put(datas, config.getFolder()+fileName, upToken);
		        //解析上传成功的结果
		        new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		        return config.getDomain()+config.getFolder()+fileName;
		    } catch (QiniuException ex) {
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		return "";
	}
	public static ResultModel<String> upload(InputStream inputStream,QiniuEnum config,String fileName){
		Configuration cfg = new Configuration(Zone.zone2());
		Auth auth = Auth.create(QiniuConfig.AK, QiniuConfig.SK);
		String upToken = auth.uploadToken(config.getBucket());
		String localTempDir = Paths.get(System.getenv("java.io.tmpdir"), config.getBucket()).toString();
		try {
		    //设置断点续传文件进度保存目录
		    FileRecorder fileRecorder = new FileRecorder(localTempDir);
		    UploadManager uploadManager = new UploadManager(cfg, fileRecorder);
		    try {
		        Response response = uploadManager.put(inputStream, config.getFolder()+fileName, upToken,null,null);
		        //解析上传成功的结果
		        new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		        return CommonUtils.returnModel(true, "", config.getDomain()+config.getFolder()+fileName);
		    } catch (QiniuException ex) {
		    	return CommonUtils.returnModel(true, ex.getMessage(), "");
		    }
		} catch (IOException ex) {
			return CommonUtils.returnModel(true, ex.getMessage(), "");
		}
	}
	public static String upload(String filePath,QiniuEnum config){
		//构造一个带指定Zone对象的配置类
		String fileName = filePath.substring(filePath.lastIndexOf("/")+1, filePath.length());
		return upload(filePath,config,fileName);
	}
	public static void main(String[] args) {
		String filePath = "/tomcat/temp/image/person.jpg";
		System.out.println(upload(filePath,QiniuEnum.USER));;
	}
}
