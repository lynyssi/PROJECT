package com.mirin.tech.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private SqlSession sqlSession;	
	
	//관리자 인덱스 페이지 충전 대기 리스트 
	@Override
	public ArrayList<Map<String, Object>> adminIndexPMoneyChkList(){
			
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminIndexPMoneyChkList();
		
		return alist;
	}
	
		
	//관리자 인덱스 페이지 프로젝트 승인 대기 리스트
	@Override
	public ArrayList<ProjectVo> adminIndexPProjectChkList(){		
				
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminIndexPProjectChkList();
			
		return alist;	
	}
	
	//관리자 프로젝트 등록 승인 내용  
	@Override
	public Map<String, Object> adminProJChkCon(ProjectVo pv){

		Map<String, Object> data = new HashMap<String, Object>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		data = adminMapper.adminProJChkCon(pv);
		return data;
		
	}

	//관리자 인덱스 페이지 사업자 승인 대기 리스트
	@Override
	public ArrayList<MemberVo> adminIndexPCmemChkList(){
		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminIndexPCmemChkList();			

		return alist;
	}
		

	//관리자 사업자 회원정보 페이지 회원리스트  
	@Override
	public ArrayList<Map<String, Object>> adminCmemInfoList(){
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminCmemInfoList();

		return alist;
	}
	

	
	//관리자 사업자 회원정보 페이지 진행중 프로젝트	
	@Override
	public ArrayList<ProjectVo> adminCmemInfoProj(int param_idx){
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminCmemInfoProj(param_idx);
		
		return alist;

	}

	//관리자 사업자 회원정보 페이지 지난 프로젝트 리스트
	@Override
	public ArrayList<ProjectVo> adminCmemInfoProjHis(int param_idx){
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminCmemInfoProjHis(param_idx);

		return alist;	
	}
	
	//관리자 사업자 회원정보 페이지 진행중 프로젝트 투자 회원리스트
	@Override
	public ArrayList<Map<String, Object>> adminCmemInfoProjFundHis(int param_idx){
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminCmemInfoProjFundHis(param_idx);	
		
		return alist;
	}
	
	
	//관리자 사업자 회원정보 페이지 QNA 리스트
	@Override
	public ArrayList<BoardVo> adminCmemInfoProjQna(int param_idx){
		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminCmemInfoProjQna(param_idx);	

		return alist;	
	}

	//관리자 투자자 회원정보 페이지 회원리스트
	@Override
	public ArrayList<MemberVo> adminImemInfoList(){
		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminImemInfoList();

		return alist;
	}
	
	//관리자 투자자 회원 정보 페이지 회원별 상세 정보
	@Override
	public MemberVo adminImemInfoCon(int param_idx){
			 
		MemberVo mv = new MemberVo();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		mv = adminMapper.adminImemInfoCon(param_idx);

		return mv;	
	}
	
	//관리자 사업자 회원정보 페이지 회원별 상세정보  
	@Override
	public Map<String, Object> adminCmemInfoCon(int param_idx){

		Map<String, Object> data = new HashMap<String, Object>();			
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		data = adminMapper.adminCmemInfoCon(param_idx);
		
		return data;	
	}
	
	//관리자 투자자 회원정보 페이지 회원별 충전 기록 리스트
	@Override
	public ArrayList<MoneyVo> adminImemInfoMoneyHis(int param_idx){
			
		ArrayList<MoneyVo> alist = new ArrayList<MoneyVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminImemInfoMoneyHis(param_idx);	

		return alist;
	}
	
	//관리자 투자자 회원정보 페이지 프로젝트 참가 기록 리스트
	@Override
	public ArrayList<Map<String, Object>> adminImemInfoProjHis(int param_idx){

		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminImemInfoProjHis(param_idx);
	
		return alist;
	}	
		
	//관리자 투자자 회원정보 페이지 QNA 참가기록 리스트	
	@Override
	public ArrayList<Map<String, Object>> adminImemInfoQnaHis(int param_idx){
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminImemInfoQnaHis(param_idx);

		return alist;
	}

	//관리자 고객센터 페이지 FAQ 리스트 
	@Override
	public ArrayList<BoardVo> adminBoardFaqList(){
				
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminBoardFaqList();	


		return alist;	
	}	
	
	//관리자 고객센터 페이지 FAQ 상세내용 
	@Override
	public BoardVo adminBoardFaqCon(int bIdx){

		BoardVo bv = new BoardVo();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		bv = adminMapper.adminBoardFaqCon(bIdx);
		
		return bv;	
	}
	
	//관리자 고객센터 페이지 FAQ 수정 상세내용
	@Override
	public BoardVo adminBoardFaqModCon(int bIdx){
		
		BoardVo bv = new BoardVo();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		bv = adminMapper.adminBoardFaqModCon(bIdx);
	
		return bv;
	}
	
	//관리자 고객센터 페이지 FAQ 수정
	@Override
	public int adminBoardFaqMod(BoardVo bv){
		
		int row = 0;
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		row = adminMapper.adminBoardFaqMod(bv);
		
		return row;
	}
	
	//관리자 고객센터 페이지  FAQ 삭제
	@Override
	public int adminBoardFaqDel(int bIdx){
		
		int row = 0;
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		row = adminMapper.adminBoardFaqDel(bIdx);
		
		return row;
	}
	
	//관리자 뉴스관리 페이지 뉴스 리스트  
	@Override
	public ArrayList<BoardVo> adminBoardNewsList(){
	
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminBoardNewsList();
	
		return alist;	
	}

	//관리자 고객센터 페이지 QNA리스트 
	@Override
	public ArrayList<BoardVo> adminBoardQnaList(){

		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminBoardQnaList();	
		
		return alist;	
	}
	
	//관리자 고객센터 페이지 QNA 상세내용
	@Override
	public BoardVo adminBoardQnaCon(int bIdx){

		BoardVo bv = new BoardVo();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		bv = adminMapper.adminBoardQnaCon(bIdx);			
		
		return bv;	
	}
	
	//관리자 고객센터 페이지 QNA 수정
	@Override
	public int adminBoardQnaMod(BoardVo bv){
		
		int row = 0;
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		row = adminMapper.adminBoardQnaMod(bv);
		
		return row;
	}
	
	//관리자 고객센터 페이지  QNA 삭제
	@Override
	public int adminBoardQnaDel(int bIdx){
		
		int row = 0;
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		row = adminMapper.adminBoardQnaDel(bIdx);
		
		return row;
	}
	
	//관리자 고객센터 페이지 전체 공지사항 리스트 
	@Override
	public ArrayList<BoardVo> adminBoardNoticeList(){

		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		alist = adminMapper.adminBoardNoticeList();	

		return alist;	
	}	
	
	//관리자 고객센터 페이지 전체 공지사항 상세내용 
	@Override
	public BoardVo adminBoardNoticeCon(int bIdx){
		
		BoardVo bv = new BoardVo();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		bv = adminMapper.adminBoardNoticeCon(bIdx);						
		
		return bv;
	}
	
	//관리자 고객센터 페이지 NOTICE 수정
	@Override
	public int adminBoardNoticeMod(BoardVo bv){
		
		int row = 0;
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		row = adminMapper.adminBoardNoticeMod(bv);
		
		return row;
		}
		
	//관리자 고객센터 페이지  NOTICE 삭제
	@Override
	public int adminBoardNoticeDel(int bIdx){
		
		int row = 0;
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		row = adminMapper.adminBoardNoticeDel(bIdx);
		
		return row;
	}	

	//관리자 사업자 등록 승인 리스트
	@Override
	public ArrayList<MemberVo> adminCmemChkList(){
		
		ArrayList<MemberVo> mlist = new ArrayList<MemberVo>(); 
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		mlist = adminMapper.adminCmemChkList();
		
		return mlist;
	}	
/*	
	//관리자 머니 승인 
	@Override
	public int adminMoneyModOkTransaction(int param_idx, int mIdx){
		
		int row = 0;
		
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		row = adminMapper.adminMoneyModOkTransaction(param_idx, mIdx);		
		
		return row;
	}
	
*/
	
}

