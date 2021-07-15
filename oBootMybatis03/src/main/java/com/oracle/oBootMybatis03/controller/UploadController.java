package com.oracle.oBootMybatis03.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	//UpLoadForm 시작 화면
	@RequestMapping(value="upLoadFormStart")
	public String upLoadFormStart(Model model) {
		System.out.println("upLoadFormStart Start");
		return "upLoadFormStart";
	}
	
	@RequestMapping(value="uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
		System.out.println("uploadForm GET Start");
		System.out.println();
	}
	
	@RequestMapping(value="uploadForm", method = RequestMethod.POST)
	public String uploadForm (HttpServletRequest request, MultipartFile file1, Model model) throws IOException {
		String uploadPath = (request.getSession().getServletContext().getRealPath("/upload/"));
		logger.info("originalName : " + file1.getOriginalFilename());
		logger.info("size : " + file1.getSize());
		logger.info("contentType : " + file1.getContentType());
		String savedName = uploadFile(file1.getOriginalFilename(),file1.getBytes(), uploadPath);
		logger.info("savedName : " + savedName);
		model.addAttribute("savedName", savedName);
		return "uploadResult";	
	}
		
	private String uploadFile(String originalName, byte[] fileData, String uploadPath) throws IOException {
		UUID uid = UUID.randomUUID();
		// requestPath = requestPath + "/resources/image";
		System.out.println("uploadPath->" + uploadPath);
		// Directory 생성
		File fileDirectory = new File(uploadPath);
		if(!fileDirectory.exists()) {
			fileDirectory.mkdir();
			System.out.println("업로드용 폴더 생성 : " + uploadPath);
		}
		String savedName = uid.toString() + "_" + originalName;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}

	@RequestMapping(value="uploadFileDelete", method = RequestMethod.GET)
	public String uploadFileDelete(HttpServletRequest request, Model model) throws IOException {
		String uploadPath = (request.getSession().getServletContext().getRealPath("/upaload/"));
		String deleteFile = uploadPath + "12.jsp";
		int delResult = upFileDelete(deleteFile);
		model.addAttribute("deleteFile", deleteFile);
		model.addAttribute("delResult", delResult);
		return "uploadResult";
	}
	
	private int upFileDelete(String deleteFileName) throws IOException {
		int result = 0;
		File file = new File(deleteFileName);
		if (file.exists()) {
			if(file.delete()) { //삭제성공
				result=1;
			}
			else {				//삭제실패
				result=0;
			}	
		}
		else {
			result=-1;		//파일 x
		}
		return result;
	}
	
	
}
