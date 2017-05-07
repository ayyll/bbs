package com.ayyll.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ayyll.util.LogUtils;
import com.ayyll.util.ResponseUtils;

/**
 * @author LJC 
 * 文件上传
 */
@Controller
public class FileUpLoadController {

	/**
	 * 文件上传
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {

		// 文件名及文件存储位置,保存到 ../resources/upload/ 目录下
		String fileName = file.getOriginalFilename();
		String filePath = request.getServletContext().getRealPath("/resources/upload");

		LogUtils.info("文件名:{},文件存储路径:{}", fileName, filePath);
		File tem = new File(filePath);
		if(!tem.exists()) {
			tem.mkdirs();
		}
		// 上传文件到服务器
		try {
			file.transferTo(new File(filePath + File.separator + fileName));
		} catch (Exception e) {
			LogUtils.info("文件上传失败！" + e);
			e.printStackTrace();
		}

		// 向前台返回文件地址
		ResponseUtils.write(response, request.getContextPath()
				+ "/resources/upload/" + fileName);

		return null;
	}
	
}
