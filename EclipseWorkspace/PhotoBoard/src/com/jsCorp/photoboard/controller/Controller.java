package com.jsCorp.photoboard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsCorp.photoboard.dto.Board;
import com.jsCorp.photoboard.dto.Member;
import com.jsCorp.photoboard.service.Service;

@org.springframework.stereotype.Controller
public class Controller {
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private Service service;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/")
	public String root(Model model) {
		model.addAttribute("result", -1);
		LOGGER.info("/처리 완료");
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(String mid, String mpassword, Model model, HttpServletRequest request, HttpSession session) {
		Member member = service.login(mid, mpassword);
		if (member == null) {
			model.addAttribute("result", 0);
			return "index";
		} else {
			session.setAttribute("login_info", member);
			return "main";
		}
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinGet() {
		return "join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPost(Member member) throws IllegalStateException, IOException {
		member.setMoriginalfilename(member.getMattach().getOriginalFilename());
		member.setMfilecontent(member.getMattach().getContentType());
		String fileName = new Date().getTime() + "-" + member.getMoriginalfilename();
		member.setMsavedfilename(fileName);

		String realPath = servletContext.getRealPath("/WEB-INF/upload/member/");
		File file = new File(realPath + fileName);
		member.getMattach().transferTo(file);

		service.memberJoin(member);

		return "redirect:/";
	}

	@RequestMapping("/check_id")
	public String checkID(String mid, Model model) {
		int result = service.joinCheckID(mid);
		model.addAttribute("result", result);
		return "checkID";
	}

	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("login_info", null);
		return "redirect:/";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET() {
		return "write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(Board board) throws IllegalStateException, IOException {
		board.setBoriginalfilename(board.getBattach().getOriginalFilename());
		board.setBfilecontent(board.getBattach().getContentType());
		String fileName = new Date().getTime() + "-" + board.getBoriginalfilename();
		board.setBsavedfilename(fileName);

		String realPath = servletContext.getRealPath("/WEB-INF/upload/board/");
		File file = new File(realPath + fileName);
		board.getBattach().transferTo(file);

		service.boardWrite(board);

		return "redirect:/board";
	}

	@RequestMapping("/board")
	public String board(@RequestParam(defaultValue = "1") int pageNo, Model model) {
		// 한페이지를 구성하는 행수
		int rowsPerPage = 16;
		// 한 그룹을 구성하는 페이지수
		int pagesPerGroup = 5;
		// 총행수
		int totalRows = service.boardTotalRows();
		// 전체 페이지 수
		int totalPageNo = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		// 전체 그룹 수
		int totalGroupNo = (totalPageNo / pagesPerGroup) + ((totalPageNo % pagesPerGroup != 0) ? 1 : 0);
		// 현재 그룹번호
		int groupNo = (pageNo - 1) / pagesPerGroup + 1;
		// 현재 그룹시작페이지 번호
		int startPageNo = (groupNo - 1) * pagesPerGroup + 1;
		// 현재 그룹의 마지막 페이지 번호
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if (groupNo == totalGroupNo)
			endPageNo = totalPageNo;
		// 현 페이지의 행의 데이터 가져오
		List<Board> list = service.boardListPage(pageNo, rowsPerPage);
		// View로 넘겨줄 데이터
		model.addAttribute("list", list);
		model.addAttribute("pagesPerGoup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		return "board";
	}

	@RequestMapping("/file")
	public void download(String msavedfilename, String mfilecontent, String bsavedfilename, String bfilecontent,
			HttpServletResponse r, @RequestHeader("User-Agent") String userAgent) throws IOException {
		if (msavedfilename == null) {
			System.out.println(msavedfilename);
			String fileName = bsavedfilename;
			LOGGER.info(fileName);
			String encFileName;
			if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
				encFileName = URLEncoder.encode(fileName, "UTF-8");
			} else {
				encFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			r.addHeader("Content-Disposition", "attachment; filename=\"" + encFileName + "\"");
			// 2. 파일의 종류
			r.addHeader("Content-Type", bfilecontent);
			// 3. 파일의 크기(옵션)
			r.addHeader(fileName, fileName);
			File file = null;

			file = new File(servletContext.getRealPath("/WEB-INF/upload/board/" + fileName));

			long fileSize = file.length();
			r.addHeader("Content-Length", String.valueOf(fileSize));

			OutputStream os = r.getOutputStream();
			FileInputStream fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, os);
			os.flush();
			fis.close();
			os.close();
		} else{
			String fileName = msavedfilename;
			LOGGER.info(fileName);
			String encFileName;
			if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
				encFileName = URLEncoder.encode(fileName, "UTF-8");
			} else {
				encFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			r.addHeader("Content-Disposition", "attachment; filename=\"" + encFileName + "\"");
			// 2. 파일의 종류
			r.addHeader("Content-Type", mfilecontent);
			// 3. 파일의 크기(옵션)
			r.addHeader(fileName, fileName);
			File file = null;

			file = new File(servletContext.getRealPath("/WEB-INF/upload/member/" + fileName));

			long fileSize = file.length();
			r.addHeader("Content-Length", String.valueOf(fileSize));

			OutputStream os = r.getOutputStream();
			FileInputStream fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, os);
			os.flush();
			fis.close();
			os.close();
		}
	}

	@RequestMapping("/boardDetail")
	public String boardDetail(int bno, Model model) {
		Board board = service.getBoard(bno);
		model.addAttribute("board", board);
		return "boardDetail";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String exam05UpdateGET(int bno, Model model) {
		Board board = service.getBoard(bno);

		model.addAttribute("board", board);
		return "update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String exam05UpdatePOST(Board board) throws IllegalStateException, IOException {
		if (!board.getBattach().isEmpty()) {
			board.setBoriginalfilename(board.getBattach().getOriginalFilename());
			board.setBfilecontent(board.getBattach().getContentType());
			String fileName = new Date().getTime() + "-" + board.getBoriginalfilename();
			board.setBsavedfilename(fileName);

			String realPath = servletContext.getRealPath("/WEB-INF/upload/board/");
			File file = new File(realPath + fileName);
			board.getBattach().transferTo(file);
		}

		service.boardUpdate(board);
		return "redirect:/board";
	}

	@RequestMapping("/delete")
	public String exam05Delete(int bno) {
		service.boardDelete(bno);
		return "redirect:/board";
	}

	@RequestMapping("/memberDetail")
	public String boardDetail(String mid, Model model) {
		Member member = service.getMember(mid);
		model.addAttribute("member", member);
		return "memberDetail";
	}

}
