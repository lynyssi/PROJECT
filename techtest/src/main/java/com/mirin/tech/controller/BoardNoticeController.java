package com.mirin.tech.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mirin.tech.service.BoardCommVo;
import com.mirin.tech.service.BoardNoticeServiceImpl;
import com.mirin.tech.service.BoardVo;


@Controller
public class BoardNoticeController {

	@Autowired
	private BoardVo bv;
	@Autowired
	private BoardNoticeServiceImpl bi;
	
	
	@RequestMapping(value = "/NoticeList.do")
	public String NoticeList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
    	int bIdx = 0;
    	
    	
    	ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
    	alist = bi.boardNoticeList();
		    	
    	request.setAttribute("alist", alist);	
		
    	    	
		return "boardNotice/NoticeList";
	}
		
	@RequestMapping(value = "/NoticeCon.do")
	public String NoticeCon(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
    	
    	int bIdx = 0;
    	
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		
		bv = bi.boardNoticeCon(bIdx);
		request.setAttribute("bv", bv);
		
		int row = 0;
		row = bi.boardNoticeHit(bIdx);
		
		
		return "boardNotice/NoticeCon";
	}
	

}
