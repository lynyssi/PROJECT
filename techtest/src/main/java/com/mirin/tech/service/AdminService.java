package com.mirin.tech.service;

import java.util.ArrayList;
import java.util.Map;


public interface AdminService {
	
	//관리자 인덱스 페이지 충전 대기 리스트
	public ArrayList<Map<String, Object>> adminIndexPMoneyChkList();
	
	//관리자 인덱스 페이지 프로젝트 승인 대기 리스트
	public ArrayList<ProjectVo> adminIndexPProjectChkList();
	
	//관리자 프로젝트 등록 승인 내용  
	public Map<String, Object> adminProJChkCon(ProjectVo pv);
	
	//관리자 인덱스 페이지 사업자 승인 대기 리스트
	public ArrayList<MemberVo> adminIndexPCmemChkList();
	
	//관리자 사업자 회원정보 페이지 회원리스트  
	public ArrayList<Map<String, Object>> adminCmemInfoList();
	
	//관리자 사업자 회원정보 페이지 회원별 상세정보  
	public Map<String, Object> adminCmemInfoCon(int param_idx);
	
	//관리자 사업자 회원정보 페이지 진행중 프로젝트	
	public ArrayList<ProjectVo> adminCmemInfoProj(int param_idx);
	
	//관리자 사업자 회원정보 페이지 지난 프로젝트 리스트
	public ArrayList<ProjectVo> adminCmemInfoProjHis(int param_idx);
	
	//관리자 사업자 회원정보 페이지 진행중 프로젝트 투자 회원리스트
	public ArrayList<Map<String, Object>> adminCmemInfoProjFundHis(int param_idx);
		
	//관리자 사업자 회원정보 페이지 QNA 리스트
	public ArrayList<BoardVo> adminCmemInfoProjQna(int param_idx);
	
	//관리자 투자자 회원정보 페이지 회원리스트
	public ArrayList<MemberVo> adminImemInfoList();
	
	//관리자 투자자 회원 정보 페이지 회원별 상세 정보
	public	MemberVo adminImemInfoCon(int param_idx);
	
	//관리자 투자자 회원정보 페이지 회원별 충전 기록 리스트
	public ArrayList<MoneyVo> adminImemInfoMoneyHis(int param_idx);
	
	//관리자 투자자 회원정보 페이지 프로젝트 참가 기록 리스트
	public ArrayList<Map<String, Object>> adminImemInfoProjHis(int param_idx);
	
	//관리자 투자자 회원정보 페이지 QNA 참가기록 리스트	
	public ArrayList<Map<String, Object>> adminImemInfoQnaHis(int param_idx);
	
	//관리자 고객센터 페이지 QNA 수정
	public int adminBoardQnaMod(BoardVo bv);
	
	//관리자 고객센터 페이지  QNA 삭제
	public int adminBoardQnaDel(int bIdx);
	
	//관리자 고객센터 페이지 FAQ 리스트
	public ArrayList<BoardVo> adminBoardFaqList();
	
	//관리자 고객센터 페이지 FAQ 상세내용 
	public BoardVo adminBoardFaqCon(int bIdx);
	
	//관리자 고객센터 페이지 FAQ 수성 상세내용
	public BoardVo adminBoardFaqModCon(int bIdx);
	
	//관리자 고객센터 페이지 FAQ 수정
	public int adminBoardFaqMod(BoardVo bv);
	
	//관리자 고객센터 페이지  FAQ 삭제
	public int adminBoardFaqDel(int bIdx);
	
	//관리자 뉴스관리 페이지 뉴스 리스트  
	public ArrayList<BoardVo> adminBoardNewsList();
	
	//관리자 고객센터 페이지 QNA리스트 
	public ArrayList<BoardVo> adminBoardQnaList();
	
	//관리자 고객센터 페이지 QNA 상세내용
	public BoardVo adminBoardQnaCon(int bIdx);
	
	//관리자 고객센터 페이지 전체 공지사항 리스트 
	public ArrayList<BoardVo> adminBoardNoticeList();
	
	//관리자 고객센터 페이지 전체 공지사항 상세내용 
	public BoardVo adminBoardNoticeCon(int bIdx);
	
	//관리자 고객센터 페이지 NOTICE 수정
	public int adminBoardNoticeMod(BoardVo bv);
	
	//관리자 고객센터 페이지  NOTICE 삭제
	public int adminBoardNoticeDel(int bIdx);
	
	//관리자 사업자 등록 승인 리스트
	public ArrayList<MemberVo> adminCmemChkList();
	
	//관리자 머니 승인 
//	public int adminMoneyModOkTransaction(int param_idx, int mIdx);

}
