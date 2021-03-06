package com.mirin.tech.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mirin.tech.service.BoardCommVo;
import com.mirin.tech.service.BoardFaqServiceImpl;
import com.mirin.tech.service.BoardVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardFaqController {
	
	@Autowired
	private BoardVo bv;
	@Autowired
	private BoardFaqServiceImpl bi;
		
	@RequestMapping(value = "/FaqList.do")
	public String FaqList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
				
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		alist = bi.boardFaqList();
		
		request.setAttribute("alist", alist);
			

		return "/boardFaq/FaqList";
	}
	
	@RequestMapping(value = "/FaqCon.do")
	public String FaqCon(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx =Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		int bIdx = 0;
				
		if(request.getParameter("bIdx") != null) {
		bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		
		bv = bi.boardFaqCon(bIdx);		
		request.setAttribute("bv", bv);
		
		int row = 0;
		row = bi.boardFaqHit(bIdx);
		
		return "/boardFaq/FaqCon";
	}
	
	}
