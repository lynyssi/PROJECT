package com.mirin.tech.service;

import java.util.ArrayList;
import java.util.Map;

public interface CMemberMapper {
	
	//사업자 인덱스 현재 진행중 프로젝트 리스트
	public ProjectVo cMemberIndexProjNowList(int sess_idx);
	
	//사업자 인덱스 댓글 리스트
	public ArrayList<Map<String, Object>> cMemberIndexCommList(int sess_idx);
	
	//사업자 인덱스 뉴스 리스트
	public ArrayList<BoardVo> cMemberIndexNewsList(int sess_idx);
	
	//사업자 등록 확인
	public int cMemberInfoExtWriteChk(int sess_idx);
	
	//사업자 등록 
	public int cMemberInfoExtWrite(Map<String, Object> data);
	
	//사업자 회원정보
	public Map<String, Object> cMemberInfoCon(int sess_idx);
	
	//사업자 비밀번호 체크
	public int cMemberInfoModChk(MemberVo mv);
	
	//사업자 회원정보 수정
	public int cMemberInfoMod(MemberVo mv);
	
	//사업자 투자자 메모 보낸 리스트
	public ArrayList<Map<String, Object>> cMemberMemoSendList(int sess_idx);
	
	//사업자 투자자 메모 내용
	public Map<String, Object> cMemberMemoCon(int memoIdx);
	
	//사업자 투자자 리스트 메모 작성
	public ArrayList<MemberVo> cMemberMemoWriteIMemberList(int idx);
	
	//사업자 메모 삭제
	public int cMemberMemoDel(int memoIdx);
	
	//사업자 뉴스리스트
	public ArrayList<BoardVo> cMemberNewsList(int sess_idx);
	
	//사업자 뉴스 내용
	public Map<String, Object> cMemberNewsCon(int bidx);
	
	//사업자 뉴스 수정
	public int cMemberNewsMod(BoardVo bv);
	
	//사업자 뉴스 작성창
	public ProjectVo cMemberNewsWriteProjNow(int sess_idx);
	
	//사업자 뉴스 작성
	public int cMemberNewsWrite(BoardVo bv);
	
	//사업자 뉴스 삭제
	public int cMemberNewsDel(int bIdx);
	
	//사업자 현재 진행중인 프로젝트 리스트
	public ProjectVo cMemberProjNowList(int sess_idx);
	
	//사업자 완료된 프로젝트 리스트
	public ArrayList<ProjectVo> cMemberProjHisList(int sess_idx);
}
