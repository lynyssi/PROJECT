package com.mirin.tech.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mirin.tech.service.BoardQnaServiceImpl;
import com.mirin.tech.service.BoardVo;



@Controller
public class BoardQnaController {
	
	@Autowired
	private BoardQnaServiceImpl bi;
	@Autowired
	private BoardVo bv;
	
	@RequestMapping(value = "/QnaList.do")
	public String QnaList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null ){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}	
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		alist = bi.boardQnaList(sess_idx); 		
		request.setAttribute("alist", alist);
			
		return "boardQna/QnaList";
	}
		
	@RequestMapping(value = "/QnaCon.do")
	public String QnaCon(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		} 		
	
		bv = bi.boardQnaCon(bIdx);
		request.setAttribute("bv", bv);
		
		int row = bi.boardQnaHit(bIdx);
		
		return "boardQna/QnaCon";
	}
	
	@RequestMapping(value = "/QnaWrite.do")
	public String QnaWrite(HttpServletRequest request, HttpServletResponse response) {
				
		int sess_idx = 0;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("idx") != null) {			
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
			
			return "boardQna/QnaWrite";			
		}else{			
			return "member/MemberLogIn";
		}     
		
	}
	
	@RequestMapping(value = "/QnaWrite_Action.do")
	public String QnaWrite_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		String cate = null, title = null, contents = null;
		
		if(request.getParameter("cate") != null) {
			cate = request.getParameter("cate").trim();  
		}
		if(request.getParameter("title") != null) {
			title = request.getParameter("title").trim(); 
		}
		if(request.getParameter("contents") != null) {
			contents = request.getParameter("contents").trim();  
		}
		
		bv.setIdx(sess_idx);
	    bv.setCate(cate);
	    bv.setTitle(title);
	    bv.setContents(contents);
	    
	    int row = 0;
	    row = bi.boardQnaWrite(bv); 
	    
	   
		return "redirect:/QnaList.do";
	}
	
	@RequestMapping(value = "/QnaMod.do")
	public String QnaMod(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		int bIdx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}

		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx").trim());
		}
		
		bv = bi.boardQnaModCon(bIdx);

		request.setAttribute("sess_idx", sess_idx);
		request.setAttribute("bv", bv);
		
		return "boardQna/QnaMod";
	}
	
	@RequestMapping(value = "/QnaMod_Action.do")
	public String QnaMod_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		int bIdx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}	
		
		String Title = null, Contents = null;
		int row = 0;
		
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx").trim());
		}
		if(request.getParameter("title") != null) {
			Title = request.getParameter("title").trim();
		}
		if(request.getParameter("contents") != null) {
			Contents = request.getParameter("contents").trim();
		}
		
		bv.setTitle(Title);
		bv.setContents(Contents);	
		bv.setbIdx(bIdx);		
			
		
		row = bi.boardQnaMod(bv);

		return "redirect:/QnaList.do";
	}
	
	@RequestMapping(value = "/QnaDel_Action.do")
	public String QnaDel_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") !=null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		
		bi.boardQnaDel(bIdx); 
		
		return "redirect:/QnaList.do";
	}


}
