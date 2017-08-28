package com.mirin.tech.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mirin.tech.service.AdminServiceImpl;
import com.mirin.tech.service.BoardVo;
import com.mirin.tech.service.FundVo;
import com.mirin.tech.service.MemberServiceImpl;
import com.mirin.tech.service.MemberVo;
import com.mirin.tech.service.MoneyVo;
import com.mirin.tech.service.ProjectVo;




/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
		
	@Autowired(required=false)
	private MemberVo mv;
	@Autowired(required=false)
	private ProjectVo pv;
	@Autowired(required=false)
	private FundVo fv;
	@Autowired(required=false)
	private MoneyVo mov;
	@Autowired(required=false)
	private BoardVo bv;
	@Autowired(required=false)
	private AdminServiceImpl ai;
	@Autowired(required=false)
	private MemberServiceImpl mi;
	
	
	@RequestMapping(value = "/AdminIndex.do")
	public String AdminIndex(HttpServletRequest request, HttpServletResponse response){	
		
		//회원 충전 대기 리스트		
	
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();					
		alist =  ai.adminIndexPMoneyChkList();
		request.setAttribute("alist", alist);

		//프로젝트 승인 대기 리스트

		ArrayList<ProjectVo> blist = new ArrayList<ProjectVo>();	
		blist = ai.adminIndexPProjectChkList();
		request.setAttribute("blist", blist);
				
		//사업자 승인 대기 리스트

		ArrayList<MemberVo> clist = new ArrayList<MemberVo>();
		clist = ai.adminIndexPCmemChkList();
		request.setAttribute("clist", clist);	
			
		return "admin/AdminIndex";
	
	
	}
	@RequestMapping(value = "/AdminCmemChkCon.do")
	public String AdminCmemChkCon(HttpServletRequest request, HttpServletResponse response){
			
			int sess_idx = 0;
			HttpSession session = request.getSession();		
			if(session.getAttribute("idx") != null){
				sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
			}
			
			int param_idx = 0; 
			param_idx = Integer.parseInt(request.getParameter("param_idx").trim(),10);	
			
			//관리자 사업자 회원정보 페이지 회원별 상세정보 
			Map<String, Object> data = new HashMap<String, Object>();			
			
			data = ai.adminCmemInfoCon(param_idx);
			request.setAttribute("data", data);			

						
			return "admin/AdminCmemChkCon";				
		}
	
	
	//관리자 사업자 리스트 
		@RequestMapping(value = "/AdminCmemInfoList.do")
		public String AdminCmemInfoList(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("안녕");
			int sess_idx = 0;
			HttpSession session = request.getSession();
			if(session.getAttribute("idx") != null){
				sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
			}			
			
			//관리자 사업자 회원정보 페이지 회원리스트  

			ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			dataList =  ai.adminCmemInfoList();	
			request.setAttribute("dataList", dataList);
			System.out.println(dataList);
			return "admin/AdminCmemInfoList";
		}
		
		@RequestMapping(value = "/AdminCmemInfoCon.do")
		public String AdminCmemInfoCon(HttpServletRequest request, HttpServletResponse response) {
			
			int param_idx = 0; 
			param_idx = Integer.parseInt(request.getParameter("param_idx").trim(),10);	
			
			System.out.println("param_idx"+param_idx);
			
			//관리자 사업자 회원정보 페이지 회원별 상세정보 
			Map<String, Object> data = new HashMap<String, Object>();
			
			data = ai.adminCmemInfoCon(param_idx);
			request.setAttribute("data", data);		
			System.out.println(data);
			
			//관리자 사업자 회원정보 페이지 진행중 프로젝트
			ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>();
			plist = ai.adminCmemInfoProj(param_idx);
			request.setAttribute("plist", plist);
			System.out.println(plist);
						
			//관리자 사업자 회원정보 페이지 지난 프로젝트 리스트 
			ArrayList<ProjectVo> dlist = new ArrayList<ProjectVo>();
			dlist = ai.adminCmemInfoProjHis(param_idx);
			request.setAttribute("dlist", dlist);
			System.out.println(dlist);
		
			//관리자 사업자 회원정보 페이지 진행중 프로젝트 투자 회원리스트
			ArrayList<Map<String, Object>> elist = new ArrayList<Map<String, Object>>();		
			elist =  ai.adminCmemInfoProjFundHis(param_idx);	
			request.setAttribute("elist", elist);
			System.out.println(elist);
									
			//관리자 사업자 회원정보 페이지 QNA 리스트
			ArrayList<BoardVo> glist = new ArrayList<BoardVo>();
			glist = ai.adminCmemInfoProjQna(param_idx);
			request.setAttribute("glist", glist);
			System.out.println(glist);
			
			
			return "admin/AdminCmemInfoCon";
		}	
		
	//관리자 투자자 리스트
	@RequestMapping(value = "/AdminImemInfoList.do")
	public String AdminImemInfoList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		
		System.out.println(sess_idx);
		

		//관리자 투자자 회원정보 페이지 회원리스트
		ArrayList<MemberVo> mlist = new ArrayList<MemberVo>();
		mlist = ai.adminImemInfoList();		
		request.setAttribute("mlist", mlist);
				
			return "admin/AdminImemInfoList";
		}
	
	//관리자 투자자 상세 페이지 
	@RequestMapping(value = "/AdminImemInfoCon.do")
	public String AdminImemInfoCon(HttpServletRequest request, HttpServletResponse response) {
		
		int param_idx = 0; 
		param_idx = Integer.parseInt(request.getParameter("param_idx").trim(),10);	
								
		//관리자 투자자 회원 정보 페이지 회원별 상세 정보		
		MemberVo mv = new MemberVo();
		mv = ai.adminImemInfoCon(param_idx);
		request.setAttribute("mv", mv);
		System.out.println(mv);
		
		//관리자 투자자 회원정보 페이지 회원별 충전 기록	
		ArrayList<MoneyVo> molist = new ArrayList<MoneyVo>();
		molist = ai.adminImemInfoMoneyHis(param_idx);
		request.setAttribute("molist", molist);
		System.out.println(molist);	
		
		//관리자 투자자 회원정보 페이지 프로젝트 참가 기록 리스트
		ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		dataList = ai.adminImemInfoProjHis(param_idx);
		request.setAttribute("dataList", dataList);	
			
		//관리자 투자자 회원정보 페이지 QNA 참가기록 리스트
		ArrayList<Map<String, Object>> QdataList = new ArrayList<Map<String, Object>>();
		QdataList = ai.adminImemInfoQnaHis(param_idx);
		request.setAttribute("QdataList", QdataList);	
		System.out.println(QdataList);	
		
		return "admin/AdminImemInfoCon";
	}
	
	//관리자 머니 충전 리스트
	@RequestMapping(value = "/AdminMoneyList.do")
	public String AdminMoneyList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
					
		//관리자 머니 충전 기록 리스트
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();					
		alist =  ai.adminIndexPMoneyChkList();
		request.setAttribute("alist", alist);

									
		return "admin/AdminMoneyList";
	}
/*	
	@RequestMapping(value = "/AdminMoneyChkOk.do")
	public String AdminMoneyChkOk(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		int mIdx = 0;
		int param_idx = 0;
		
		mIdx = Integer.parseInt(request.getParameter("mIdx").trim());	
		param_idx = Integer.parseInt(request.getParameter("param_idx").trim(),10);
	
		
		//관리자 머니 충전 기록 리스트
		int row = 0;					
		row =  ai.adminMoneyModOkTransaction(param_idx, mIdx);
									
		return "admin/AdminMoneyChkOk";
	}
*/	
	//관리자 FAQ 리스트 페이지 
	@RequestMapping(value = "/AdminFaqList.do")
	public String AdminFaqList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}

		//관리자 고객센터 페이지 FAQ 리스트 
		ArrayList<BoardVo> blist = new ArrayList<BoardVo>(); 	
		blist =  ai.adminBoardFaqList();	
		request.setAttribute("blist", blist);
	
		return "admin/AdminFaqList";
	}
	
	//관리자 고객센터 FAQ페이지 상세내용
	@RequestMapping(value = "/AdminFaqCon.do")
	public String AdminFaqCon(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}	
				
		int bIdx = 0;		
		bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
		
		//관리자 고객센터 페이지 FAQ 상세내용 
		BoardVo bv = ai.adminBoardFaqCon(bIdx);	
		request.setAttribute("bv", bv);	
	
		return "admin/AdminFaqCon";
	}
	
	//관리자 고객센터 FAQ페이지 수정 
	@RequestMapping(value = "/AdminFaqMod.do")
	public String AdminFaqMod(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}		
		
		int bIdx = 0;
		bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);

		
		//관리자 고객센터 페이지 FAQ 상세수정

		BoardVo bv = ai.adminBoardFaqModCon(bIdx);
		
		request.setAttribute("bv", bv);	
		
		return "admin/AdminFaqMod";
	}
	
	@RequestMapping(value = "/AdminFaqMod_Action.do")
	public String AdminFaqMod_Action(HttpServletRequest request, HttpServletResponse response) {
				
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}
		
		int bIdx = 0;
		String cate = null, title = null, contents = null;
		
		if(request.getParameter("bIdx") != null){
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		if(request.getParameter("cate") != null){
			cate = request.getParameter("cate");
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title");
		}
		if(request.getParameter("contents") != null){
			contents = request.getParameter("contents");
		}
					
		bv.setCate(cate);
		bv.setTitle(title);
		bv.setContents(contents);
		bv.setbIdx(bIdx);
		
		int row = 0;	
		
		row = ai.adminBoardFaqMod(bv);

		return "redirect:/AdminFaqCon.do?bIdx="+bIdx+"";
	}
	
	@RequestMapping(value = "/AdminFaqDel_Action.do")
	public String AdminFaqDel_Action(HttpServletRequest request, HttpServletResponse response){
		System.out.println("들어갔냐");
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}
				
		int bIdx = 0;
		bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);		
		
		//관리자 고객센터 페이지 FAQ 삭제  
		int row = ai.adminBoardFaqDel(bIdx);
						
		return "redirect:/AdminFaqList.do?bIdx="+bIdx+"";
	
	}
	
	//관리자 QNA 리스트 페이지 
	@RequestMapping(value = "/AdminQnaList.do")
	public String AdminQnaList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}
		
		//관리자 고객센터 페이지 QNA리스트 
		ArrayList<BoardVo> blist = new ArrayList<BoardVo>(); 
		blist =  ai.adminBoardQnaList();	
		request.setAttribute("blist", blist);
		
		return "admin/AdminQnaList";
	}
	
	@RequestMapping(value = "/AdminQnaCon.do")
	public String AdminQnaCon(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}	
				
		int bIdx = 0;		
		bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
	
		//관리자 고객센터 페이지 QNA 상세내용
		BoardVo bv = ai.adminBoardQnaCon(bIdx);
		request.setAttribute("bv", bv);	
	
		return "admin/AdminQnaCon";
	}
	
	//관리자 고객센터 QNA페이지 수정 
	@RequestMapping(value = "/AdminQnaMod.do")
	public String AdminQnaMod(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}		
		
		int bIdx = 0;
		bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
	
		
		//관리자 고객센터 페이지 QNA 상세수정
	
		BoardVo bv = ai.adminBoardQnaCon(bIdx);
		
		request.setAttribute("bv", bv);	
		
		return "admin/AdminQnaMod";
	}
	
	@RequestMapping(value = "/AdminQnaMod_Action.do")
	public String AdminQnaMod_Action(HttpServletRequest request, HttpServletResponse response) {
				
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}
		
		int bIdx = 0;
		String cate = null, title = null, contents = null;
		
		if(request.getParameter("bIdx") != null){
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		if(request.getParameter("cate") != null){
			cate = request.getParameter("cate");
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title");
		}
		if(request.getParameter("contents") != null){
			contents = request.getParameter("contents");
		}
					
		bv.setCate(cate);
		bv.setTitle(title);
		bv.setContents(contents);
		bv.setbIdx(bIdx);
		
		int row = 0;	
		
		row = ai.adminBoardQnaMod(bv);
	
		return "redirect:/AdminQnaCon.do?bIdx="+bIdx+"";
	}
		
	@RequestMapping(value = "/AdminQnaDel_Action.do")
	public String AdminQnaDel_Action(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("들어갔냐");
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}
				
		int bIdx = 0;
		bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);		
		
		//관리자 고객센터 페이지 QNA 삭제  
		int row = ai.adminBoardQnaDel(bIdx);
						
		return "redirect:/AdminQnaList.do?bIdx="+bIdx+"";

	}
	//관리자 Notice 리스트 페이지 
	@RequestMapping(value = "/AdminNoticeList.do")
	public String AdminNoticeList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}
		

		//관리자 고객센터 페이지 전체 공지사항 리스트  	
		ArrayList<BoardVo> blist = new ArrayList<BoardVo>();
		blist =  ai.adminBoardNoticeList();	
		request.setAttribute("blist", blist);
		
		return "admin/AdminNoticeList";
	}
	
	//관리자 Notice 상세페이지 
	@RequestMapping(value = "/AdminNoticeCon.do")
	public String AdminNoticeCon(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}		
		
		int bIdx = 0;	
			
		if(request.getParameter("bIdx") != null){
			bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
		}
		
		//관리자 고객센터 페이지 전체 공지사항 상세내용
		BoardVo bv = ai.adminBoardNoticeCon(bIdx);
		request.setAttribute("bv", bv);	
		
		return "admin/AdminNoticeCon";
	}
	
	//관리자 고객센터 NOTICE페이지 수정 
	@RequestMapping(value = "/AdminNoticeMod.do")
	public String AdminNoticeMod(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}		
		
		int bIdx = 0;
		bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);

		
		//관리자 고객센터 페이지 NOTICE 상세수정

		BoardVo bv = ai.adminBoardNoticeCon(bIdx);
		
		request.setAttribute("bv", bv);	
		
		return "admin/AdminNoticeMod";
	}
	
	@RequestMapping(value = "/AdminNoticeMod_Action.do")
	public String AdminQnaNotice_Action(HttpServletRequest request, HttpServletResponse response) {
				
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}
		
		int bIdx = 0;
		String cate = null, title = null, contents = null;
		
		if(request.getParameter("bIdx") != null){
			bIdx = Integer.parseInt(request.getParameter("bIdx"));
		}
		if(request.getParameter("cate") != null){
			cate = request.getParameter("cate");
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title");
		}
		if(request.getParameter("contents") != null){
			contents = request.getParameter("contents");
		}
					
		bv.setCate(cate);
		bv.setTitle(title);
		bv.setContents(contents);
		bv.setbIdx(bIdx);
		
		int row = 0;	
		
		row = ai.adminBoardNoticeMod(bv);

		return "redirect:/AdminNoticeCon.do?bIdx="+bIdx+"";
	}
	
	@RequestMapping(value = "/AdminNoticeDel_Action.do")
	public String AdminNoticeDel_Action(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("들어갔냐");
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));			
		}
				
		int bIdx = 0;
		bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);		
		
		//관리자 고객센터 페이지 NOTICE 삭제  
		int row = ai.adminBoardNoticeDel(bIdx);
						
		return "redirect:/AdminNoticeList.do?bIdx="+bIdx+"";
	
	}
	
	//관리자 사업자 등록 리스트 
	@RequestMapping(value = "/AdminCmemChkList.do")
	public String AdminCmemChkList(HttpServletRequest request, HttpServletResponse response) {
	
		//관리자 사업자 등록 승인 리스트
		ArrayList<MemberVo> mlist = new ArrayList<MemberVo>();
		mlist =  ai.adminCmemChkList();

		request.setAttribute("mlist", mlist);		
		
		return "admin/AdminCmemChkList";
	}

	
	//관리자 프로젝트 등록 리스트 
	@RequestMapping(value = "/AdminProjChkList.do")
	public String AdminProjChkList(HttpServletRequest request, HttpServletResponse response) {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = Integer.parseInt(String.valueOf(session.getAttribute("idx")));
		}			
		
		//관리자 프로젝트 등록 승인 리스트 		
		ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>();
		plist =  ai.adminIndexPProjectChkList();	
		request.setAttribute("plist", plist);
		
		return "admin/AdminProjChkList";
	}
	
	//관리자 프로젝트 등록 상세 페이지
	@RequestMapping(value = "/AdminProjChkCon.do")
	public String AdminProjChkCon(HttpServletRequest request, HttpServletResponse response) {
		int param_idx = 0; 
		param_idx = Integer.parseInt(request.getParameter("param_idx").trim(),10);	
		
		int pIdx = 0;		
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		}
		System.out.println(pIdx);		
		//관리자 프로젝트 등록 승인 내용  
		Map<String, Object> data = new HashMap<String, Object>();
		data = ai.adminProJChkCon(pv);	
		System.out.println(data+"야");
		request.setAttribute("data", data);
		request.setAttribute("pIdx", pIdx);

		
		
		return "admin/AdminProjChkCon";
	}	
	
}
