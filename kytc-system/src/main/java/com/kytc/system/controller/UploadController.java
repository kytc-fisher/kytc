package com.kytc.system.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kytc.system.utils.CommonUtils;
import com.kytc.model.ResultModel;
import com.kytc.utils.qiniu.QiniuEnum;
import com.kytc.utils.qiniu.QiniuUtils;

@Controller("uploadController")
@RequestMapping("/upload")
public class UploadController {
	@RequestMapping(method=RequestMethod.POST ,value = "/image")
	@ResponseBody
	public ResultModel<String> uploadImgPost(MultipartFile file) {
		try {
			String fileType = file.getContentType();
			if(fileType.contains("/")){
				fileType = fileType.substring(fileType.indexOf("/")+1, fileType.length());
			}
			String fileName = UUID.randomUUID().toString().replace("-", "")+"."+fileType;
			return QiniuUtils.upload(file.getInputStream(), QiniuEnum.USER, fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return CommonUtils.returnModel(false, e.getMessage(), null);
		}
	}
}
