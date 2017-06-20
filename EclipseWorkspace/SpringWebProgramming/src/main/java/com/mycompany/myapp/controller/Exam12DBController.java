package com.mycompany.myapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;
import com.mycompany.myapp.service.Exam12Service;

@Controller
public class Exam12DBController {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DBController.class);
	
	@Resource(name="exam12ServiceImpl3")
	private Exam12Service service;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/jdbc/exam01")
	public String exam01(){
		Exam12Board board = new Exam12Board();
		board.setBtitle("hi");
		board.setBcontent("hi bro!!!");
		
		service.boardWrite(board);
		return "redirect:/";
	}
	
	@RequestMapping(value="/jdbc/exam02", method=RequestMethod.GET)
	public String exame02Get(){
		return "jdbc/exam02";
	}
	
	@RequestMapping(value="/jdbc/exam02", method=RequestMethod.POST)
	public String exame02Post(Exam12Board board) throws IllegalStateException, IOException{
		board.setBoriginalfilename(board.getBattach().getOriginalFilename());
		board.setBfilecontent(board.getBattach().getContentType());
		String fileName= new Date().getTime()+"-"+board.getBoriginalfilename();
		board.setBsavedfilename(fileName);
		
		String realPath=servletContext.getRealPath("/WEB-INF/upload/");
		File file= new File(realPath+fileName);
		board.getBattach().transferTo(file);
		
		service.boardWrite(board);
		
		return "redirect:/jdbc/exam05";
	}
	
	
	
	
	@RequestMapping("/jdbc/exam04")
	public String exam04(Model model){
		List<Exam12Board> list = service.boardListAll();
		model.addAttribute("list", list);
		return "jdbc/exam04";
	}
	
	@RequestMapping("/jdbc/exam05")
	public String exam05(@RequestParam(defaultValue="1") int pageNo, Model model){
		//한페이지를 구성하는 행수 
		int rowsPerPage=10;
		//한 그룹을 구성하는 페이지수 
		int pagesPerGroup=7;
		//총행수
		int totalRows=service.boardTotalRows();
		//전체 페이지 수 
		int totalPageNo=(totalRows/rowsPerPage)+((totalRows%rowsPerPage!=0)?1:0);
		//전체 그룹 수
		int totalGroupNo=(totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);
		//현재 그룹번호
		int groupNo = (pageNo-1)/pagesPerGroup+1;
		//현재 그룹시작페이지 번호 
		int startPageNo = (groupNo-1)*pagesPerGroup +1;
		//현재 그룹의 마지막 페이지 번호 
		int endPageNo=startPageNo+pagesPerGroup-1;
		if(groupNo==totalGroupNo) endPageNo=totalPageNo;
		//현 페이지의 행의 데이터 가져오
		List<Exam12Board> list = service.boardListPage(pageNo, rowsPerPage);
		//View로 넘겨줄 데이터 
		model.addAttribute("list", list);
		model.addAttribute("pagesPerGoup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		return "jdbc/exam05";
	}
	
	
	@RequestMapping("/jdbc/exam05Detail")
	public String exam05Detail(int bno, Model model){
		
		Exam12Board board = service.getBoard(bno);
		model.addAttribute("board", board);
		return "jdbc/exam05Detail";
	}
	
	@RequestMapping("/jdbc/exam05CheckBpassword")
	public String exam05CheckBpassword(int bno, String bpassword, Model model){
		String result = service.boardCheckBpassword(bno, bpassword);
		model.addAttribute("result", result);
		return "jdbc/exam05CheckBpassword";
	}
	
	@RequestMapping(value="/jdbc/exam05Update", method=RequestMethod.GET)
	public String exam05UpdateGET(int bno, Model model){
		Exam12Board board = service.getBoard(bno);

		model.addAttribute("board",board);
		return "jdbc/exam05Update";
	}
	
	
	@RequestMapping(value="/jdbc/exam05Update", method=RequestMethod.POST)
	public String exam05UpdatePOST(Exam12Board board) throws IllegalStateException, IOException{
		if(!board.getBattach().isEmpty()){
			board.setBoriginalfilename(board.getBattach().getOriginalFilename());
			board.setBfilecontent(board.getBattach().getContentType());
			String fileName= new Date().getTime()+"-"+board.getBoriginalfilename();
			board.setBsavedfilename(fileName);
			
			String realPath=servletContext.getRealPath("/WEB-INF/upload/");
			File file= new File(realPath+fileName);
			board.getBattach().transferTo(file);
		}
		
		
		service.boardUpdate(board);
		return "redirect:/jdbc/exam05Detail?bno="+board.getBno();
	}
	
	@RequestMapping("/jdbc/exam05Delete")
	public String exam05Delete(int bno){
		service.boardDelete(bno);
		return "redirect:/jdbc/exam05";
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value="/jdbc/exam03", method=RequestMethod.GET)
	public String exame03Get(){
		return "jdbc/exam03";
	}
	
	@RequestMapping(value="/jdbc/exam03", method=RequestMethod.POST)
	public String exame03Post(Exam12Member member) throws IllegalStateException, IOException{
		member.setMoriginalfilename(member.getMattach().getOriginalFilename());
		member.setMfilecontent(member.getMattach().getContentType());
		String fileName= new Date().getTime()+"-"+member.getMoriginalfilename();
		member.setMsavedfilename(fileName);
		
		String realPath=servletContext.getRealPath("/WEB-INF/upload/");
		File file= new File(realPath+fileName);
		member.getMattach().transferTo(file);
		
		service.memberJoin(member);
		
		return "redirect:/";
	}
	
	
	
	@RequestMapping("/jdbc/exam06")
	public String exam06(@RequestParam(defaultValue="1") int pageNo, Model model){
		//한페이지를 구성하는 행수 
				int rowsPerPage=10;
				//한 그룹을 구성하는 페이지수 
				int pagesPerGroup=5;
				//총행수
				int totalRows=service.memberTotalRows();
				//전체 페이지 수 
				int totalPageNo=(totalRows/rowsPerPage)+((totalRows%rowsPerPage!=0)?1:0);
				//전체 그룹 수
				int totalGroupNo=(totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);
				//현재 그룹번호
				int groupNo = (pageNo-1)/pagesPerGroup+1;
				//현재 그룹시작페이지 번호 
				int startPageNo = (groupNo-1)*pagesPerGroup +1;
				//현재 그룹의 마지막 페이지 번호 
				int endPageNo=startPageNo+pagesPerGroup-1;
				if(groupNo==totalGroupNo) endPageNo=totalPageNo;
				
				List<Exam12Member> list = service.memberListPage(pageNo, rowsPerPage);
				model.addAttribute("list", list);
				model.addAttribute("pagesPerGoup", pagesPerGroup);
				model.addAttribute("totalPageNo", totalPageNo);
				model.addAttribute("totalGroupNo", totalGroupNo);
				model.addAttribute("groupNo", groupNo);
				model.addAttribute("startPageNo", startPageNo);
				model.addAttribute("endPageNo", endPageNo);
				model.addAttribute("pageNo", pageNo);
				return "jdbc/exam06";
	}
	
	@RequestMapping("/jdbc/file/exam01")
	public void download(String msavedfilename ,HttpServletResponse r, @RequestHeader("User-Agent") String userAgent) throws IOException{
		String fileName = msavedfilename;
		LOGGER.info(fileName);
		String encFileName;
		if(userAgent.contains("MSIE")||userAgent.contains("Trident")||userAgent.contains("Edge")){
			encFileName=URLEncoder.encode(fileName, "UTF-8");
		}else{
			encFileName=new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		r.addHeader("Content-Disposition", "attachment; filename=\""+encFileName+"\"");
		//2. 파일의 종류
		r.addHeader("Content-Type", "image/jpeg");
		//3. 파일의 크기(옵션)
		r.addHeader(fileName, fileName);
		
		File file= new File(servletContext.getRealPath("/WEB-INF/upload/"+fileName));
		long fileSize = file.length();
		r.addHeader("Content-Length", String.valueOf(fileSize));
		
		OutputStream os = r.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping("/jdbc/exam06Detail")
	public String exam06Detail(String mid, Model model){
		Exam12Member member = service.getMember(mid);
		model.addAttribute("member",member);
		return "jdbc/exam06Detail";
	}
	
	@RequestMapping("/jdbc/exam06CheckMpassword")
	public String exam06CheckMpassword(String mid, String mpassword, Model model){
		String result = service.memberCheckMpassword(mid, mpassword);
		model.addAttribute("result", result);
		return "jdbc/exam06CheckMpassword";
	}
	
	@RequestMapping(value="/jdbc/exam06Update", method=RequestMethod.GET)
	public String exam06UpdateGET(String mid, Model model){
		Exam12Member member = service.getMember(mid);

		model.addAttribute("member",member);
		return "jdbc/exam06Update";
	}
	
	
	@RequestMapping(value="/jdbc/exam06Update", method=RequestMethod.POST)
	public String exam06UpdatePOST(Exam12Member member) throws IllegalStateException, IOException{
		if(!member.getMattach().isEmpty()){
			member.setMoriginalfilename(member.getMattach().getOriginalFilename());
			member.setMfilecontent(member.getMattach().getContentType());
			String fileName= new Date().getTime()+"-"+member.getMoriginalfilename();
			member.setMsavedfilename(fileName);
			
			String realPath=servletContext.getRealPath("/WEB-INF/upload/");
			File file= new File(realPath+fileName);
			member.getMattach().transferTo(file);
		}
		
		
		service.memberUpdate(member);
		return "redirect:/jdbc/exam06Detail?mid="+member.getMid();
	}
	
	@RequestMapping("/jdbc/exam06Delete")
	public String exam06Delete(String mid){
		service.memberDelete(mid);
		return "redirect:/jdbc/exam06";
	}
}
