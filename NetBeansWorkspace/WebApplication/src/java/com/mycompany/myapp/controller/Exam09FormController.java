/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ijeongsu
 */
@Controller
public class Exam09FormController {
	@Autowired
	private ServletContext serveltContext;
	
	@RequestMapping(value="/form/exam01", method=RequestMethod.GET)
	public String joinForm(){
		return "form/exam01";
	}
	
	@RequestMapping(value="/form/exam01", method=RequestMethod.POST)
	public String join(String mid, String mname, String mpassword, @RequestParam(defaultValue = "0", required = true)int mage, String[] mskill, String mbirth){
		System.out.println("mid :"+mid);
		System.out.println("mname :"+mname);
		System.out.println("mpassword :"+mpassword);
		System.out.println("mage :"+mage);
		System.out.println("mskill :"+Arrays.toString(mskill));
		System.out.println("mbirth :"+mbirth);
		return "form/exam01";
	}
	
	@RequestMapping(value="/form/exam02", method=RequestMethod.GET)
	public String joinForm2(){
		return "form/exam02";
	}
	@RequestMapping(value="/form/exam02", method=RequestMethod.POST)
	public String join2(String mid, String mname, String mpassword, @RequestParam(defaultValue = "0", required = true)int mage, String[] mskill, String mbirth, 
		  MultipartFile attach){
		String fileName = attach.getOriginalFilename();
		String contentType = attach.getContentType();
		long fileSize = attach.getSize();
		//파일을 서버에 저장
		String realPath=serveltContext.getRealPath("/WEB-INF/upload/"+fileName);
		try {
			attach.transferTo(new File(realPath));
		} catch (IOException ex) {
			Logger.getLogger(Exam09FormController.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalStateException ex) {
			Logger.getLogger(Exam09FormController.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(fileName+","+ contentType+","+ fileSize);
		
		return "form/exam02";
	}
	
	
	
	@RequestMapping("/file/exam03")
	public void download(HttpServletResponse r, @RequestHeader("User-Agent") String userAgent) throws IOException{
		//응답 HTTP 헤더행을 추가 
		//1. 파일 이름(옵션) 
			//한글 파일 이름 출력
		String fileName = "가나다.png";
		String encFileName;
		if(userAgent.contains("MSIE")||userAgent.contains("Trident")||userAgent.contains("Edge")){
			encFileName=URLEncoder.encode(fileName, "UTF-8");
		}else{
			encFileName=new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		r.addHeader("Content-Disposition", "attachment; filename=\""+encFileName+"\"");
		//2. 파일의 종류
		r.addHeader("Content-Type", "image/png");
		//3. 파일의 크기(옵션)
		r.addHeader(fileName, fileName);
		
		File file= new File(serveltContext.getRealPath("/WEB-INF/upload/가나다.png"));
		long fileSize = file.length();
		r.addHeader("Content-Length", String.valueOf(fileSize));
		
		
		//응답 HTTP 본문에 파일 데이터를 출력
		OutputStream os = r.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
}
