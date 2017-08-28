package com.mirin.tech.service;


import java.util.ArrayList;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardNoticeServiceImpl implements BoardNoticeMapper{
	
	@Autowired
	private SqlSession sqlSession;
			
	@Override 
	public ArrayList<BoardVo> boardNoticeList(){
			
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		BoardNoticeMapper boardNoticeMapper = sqlSession.getMapper(BoardNoticeMapper.class);
		alist = boardNoticeMapper.boardNoticeList();
			
		
		return alist;
		
	}	

	@Override 
	public BoardVo boardNoticeCon(int bIdx){
		
		BoardVo bv = new BoardVo();	
		BoardNoticeMapper boardNoticeMapper = sqlSession.getMapper(BoardNoticeMapper.class);
		bv = boardNoticeMapper.boardNoticeCon(bIdx);	
		
		return bv;
	
	}
	
	//BoardNoticeCommList 댓글 리스트 
	@Override 
	public ArrayList<BoardCommVo> boardNoticeCommList(int bIdx){
		
		ArrayList<BoardCommVo> alist = new ArrayList<BoardCommVo>();
		BoardNoticeMapper boardNoticeMapper = sqlSession.getMapper(BoardNoticeMapper.class);
		alist = boardNoticeMapper.boardNoticeCommList(bIdx);
		
		return alist;
	}
	
	@Override 
	public int boardNoticeHit(int bIdx){
		
		int row = 0;
		BoardNoticeMapper boardNoticeMapper = sqlSession.getMapper(BoardNoticeMapper.class);
		row = boardNoticeMapper.boardNoticeHit(bIdx);
		
		return row;
	}
	
}
