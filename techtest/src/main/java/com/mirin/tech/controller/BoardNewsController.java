package com.mirin.tech.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mirin.tech.service.BoardCommVo;
import com.mirin.tech.service.BoardNewsServiceImpl;
import com.mirin.tech.service.BoardVo;
/*
/**
 * Handles requests for the application home page.
 */


@Controller
public class BoardNewsController {
	
	
	@Autowired
	private BoardVo bv;
	@Autowired
	private BoardCommVo commbv;
	@Autowired
	private BoardNewsServiceImpl bi;
	
	@RequestMapping(value = "/NewsList.do")
	public String NewsList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
    			
		String cate = null;
		
		if(request.getParameter("cate") != null) {
			  cate = request.getParameter("cate");
			 }
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		alist = bi.boardNewsListCate(cate);  	
		
		request.setAttribute("alist", alist);
		
		return "/boardNews/NewsList";
	}
	
	
	@RequestMapping(value = "/NewsCon.do")
	public String NewsCon(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("newsCon들어가나 ");
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
    	
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
		bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		
		int commIdx = 0;
		
		if(request.getParameter("commIdx") != null) {
			commIdx = Integer.parseInt(request.getParameter("commIdx"));
		}
		
				
		bv = bi.boardNewsCon(bIdx);
		request.setAttribute("bv", bv);	
		
		System.out.println("bv받나?"+bv);
		request.setAttribute("commIdx", commIdx);
		
		ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		
		data = bi.boardNewsCommList(bIdx);
		request.setAttribute("data", data);
		System.out.println("clist받나"+data);
		
		bi.boardNewsHit(bIdx);
			
		ArrayList<Map<String, Object>> sclist = new ArrayList<Map<String, Object>>();
		sclist = bi.BoardNewsSubCommList(commIdx);
		request.setAttribute("sclist", sclist);
		System.out.println("sclist받나?"+sclist);
		System.out.println(sclist);
		
		
			
		request.setAttribute("bIdx", bIdx);
		request.setAttribute("idx", sess_idx);
		
		return "/boardNews/NewsCon";
	}
	
	
	/*
	@RequestMapping(value = "/NewsCommWrite_Action.do")
	public String NewsCommWrite_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = (Integer) session.getAttribute("idx");	
		}
				
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx").trim());
		}		
		
		String comments = null;
		
		if(request.getParameter("comments") != null) {
			comments = request.getParameter("comments").trim();  
		}

		request.setAttribute("idx", sess_idx);
		
		commvo.setIdx(sess_idx);
		commvo.setbIdx(bIdx);
		commvo.setComments(comments);

		int row = 0;
		
		row = bi.boardNewsCommWrite(commvo);
		
		return "redirect:/NewsCon.do?bIdx="+bIdx+"";
	}	
		
	@RequestMapping(value = "/NewsCommMod_Action.do")
	public String NewsCommMod_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null ) {
			sess_idx = (Integer) session.getAttribute("idx");
		}
		int bIdx = 0;
		if(request.getParameter("bIdx") != null ) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		
		int commIdx = 0;		
		if(request.getParameter("commIdx") != null ) {
			commIdx = Integer.parseInt(request.getParameter("commIdx"));
		}
		
		String comments = null;
		if(request.getParameter("rcomments") != null ) {
			comments = request.getParameter("rcomments").trim();
		}
	
		commvo.setbIdx(bIdx);
		commvo.setCommIdx(commIdx);
		commvo.setComments(comments);

		int row = 0;
		
		row = bi.boardNewsCommWriteCntMod(commvo);

		return "redirect:/NewsCon.do?bIdx="+bIdx+"&commIdx="+commIdx+"";
	}
	
	@RequestMapping(value = "/NewsCommDel_Action.do")
	public String NewsCommDel_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session =request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int commIdx = 0;
		
		if(request.getParameter("commIdx") != null) {
			commIdx = Integer.parseInt(request.getParameter("commIdx"));
		}
		
		int bIdx = 0;
		
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
					
		bi.boardNewsCommDel(commIdx); 	
						
		return "redirect:/NewsCon.do?bIdx="+bIdx+"";
	}
	/*
	@RequestMapping(value = "/NewsCommSubWrite_Action.do")
	public String NewsCommSubWrite_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = (Integer) session.getAttribute("idx");	
		}
				
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}		
		int commIdx = 0;
		if(request.getParameter("commIdx") != null) {
			commIdx = Integer.parseInt(request.getParameter("commIdx"));
		}
		String comments = null;
		
		if(request.getParameter("dcomments") != null) {
			comments = request.getParameter("dcomments").trim();  
		}
			
		commvo.setIdx(sess_idx);
		commvo.setbIdx(bIdx);
		commvo.setCommIdx(commIdx);	
		commvo.setComments(comments);
		
		int row = 0;
		
		row = bs.boardNewsSubCommWriteTransaction(commvo);
		
		return "redirect:/NewsCon.do?bIdx="+bIdx+"&commIdx="+commIdx+"";
	}
	
	@RequestMapping(value = "/NewsCommSubMod_Action.do")
	public String NewsCommSubMod_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null ) {
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int bIdx = 0;		
		if(request.getParameter("bIdx") != null ) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		int ocommIdx = 0;		
		if(request.getParameter("ocommIdx") != null ) {
			ocommIdx = Integer.parseInt(request.getParameter("ocommIdx"));
		}
		int commIdx = 0;
		if(request.getParameter("commIdx") != null ) {
			commIdx = Integer.parseInt(request.getParameter("commIdx"));
		}
		String comments = null;
		if(request.getParameter("drcomments") != null) {
			comments = request.getParameter("drcomments").trim();
		}

		commvo.setbIdx(bIdx);
		commvo.setCommIdx(commIdx);
		commvo.setComments(comments);
		
		int row = 0;
		
		row = bi.boardNewsCommWriteCntMod(commvo);

		return "redirect:/NewsCon.do?bIdx="+bIdx+"&commIdx="+ocommIdx+"";
	}
	
	@RequestMapping(value = "/NewsCommSubDel_Action.do")
	public String NewsCommSubDel_Action(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session=request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		
		int commIdx = 0;
		if(request.getParameter("commIdx") != null) {
			commIdx = Integer.parseInt(request.getParameter("commIdx"));
		}
		
		bi.boardNewsCommDel(commIdx);
		
		return "redirect:/NewsCon.do?bIdx="+bIdx+"&commIdx="+commIdx+"";
	}
	/*
	@RequestMapping(value = "/NewsConGoodBad_Action.do")
	public String NewsConGoodBad_Action(HttpServletRequest request, HttpServletResponse response) {
		
		String answer = null;
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			sess_idx = (Integer) session.getAttribute("idx");	
		}
		
		int bIdx = 0;
		if(request.getParameter("bIdx") != null) {
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}

		String GoodBad = null;
		if(request.getParameter("goodbad") != null) {
			GoodBad = request.getParameter("goodbad");
		}	

		int row = 0;
		
		if(GoodBad.equals("up")){
			row = bs.boardNewsGood(bIdx);
			if(row == 1){
				answer = "redirect:/NewsCon.do?bIdx="+bIdx+"";
			}
		
		}else if(GoodBad.equals("down")){
			row = bs.boardNewsBad(bIdx);
			if(row == 1){
				answer = "redirect:/NewsCon.do?bIdx="+bIdx+"";
		}
		
	}
		return answer;
	}	
*/	
}
