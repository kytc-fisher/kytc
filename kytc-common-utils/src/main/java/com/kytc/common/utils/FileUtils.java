package com.kytc.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
	public static String saveFile(String filePath,String fileName, InputStream in){
		String osName = System.getProperty("os.name");
		String separator = "";
		if (osName == null) {
			osName = "";
		}
		if (osName.toLowerCase().indexOf("win") != -1) {
			separator = "\\";
		} else {
			separator = "/";
		}
		File storeFile = new File(filePath + separator + fileName);
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
//			bos = new BufferedOutputStream(new FileOutputStream(storeFile));
//			bis = new BufferedInputStream(in);
//			int c;
//			while ((c = bis.read()) != -1) {
//				System.out.println(c);
//				bos.write(c);
//				bos.flush();
//			}
			OutputStream os = new FileOutputStream(storeFile);
		    int bytesRead = 0;
		    byte[] buffer = new byte[8192];
		    while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
			    os.write(buffer, 0, bytesRead);
			    System.out.println(bytesRead);
		    }
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
//			try {
////				bos.close();
////				bis.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		return filePath + separator + fileName;
	}
}
