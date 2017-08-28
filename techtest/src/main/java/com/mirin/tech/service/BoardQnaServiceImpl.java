package com.mirin.tech.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardQnaServiceImpl implements BoardQnaService {
	
	@Autowired
	private SqlSession sqlSession;

	
	@Override  
	public ArrayList<BoardVo> boardQnaList(int sess_idx){

		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();	  
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		alist = boardQnaMapper.boardQnaList(sess_idx);
		  
		return alist;
		  
	}	
	
	@Override 
	public BoardVo boardQnaCon(int bIdx){
		
		BoardVo bv = new BoardVo();
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		bv = boardQnaMapper.boardQnaCon(bIdx);
					  	
		 return bv;
		  
	 }
	@Override
	public BoardVo boardQnaModCon(int bIdx){
		
		BoardVo bv = new BoardVo();
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		bv = boardQnaMapper.boardQnaModCon(bIdx);
		
		return bv;
	}

	
	@Override
	public int boardQnaWrite(BoardVo bv){
		
		int row = 0;
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		row = boardQnaMapper.boardQnaWrite(bv);
			 		 
		return row;
		  
	  }

	@Override
	public int boardQnaMod(BoardVo bv){
		
		int row = 0;
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);	  
		row = boardQnaMapper.boardQnaMod(bv);	  
		  
		 return row;
		  
	  }

	@Override 
	public int boardQnaDel(int bIdx){
		  
		int row = 0; 
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);	
		row = boardQnaMapper.boardQnaDel(bIdx);	  
			
		  return row;
	  
	  }

	@Override
	public int boardQnaHit(int bIdx){
		
		int row = 0;
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		row = boardQnaMapper.boardQnaHit(bIdx);
			
		return row;	 
	
	}
		
	@Override
	public int boardQnaGood(int bIdx){
		
		int row = 0;
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		row = boardQnaMapper.boardQnaGood(bIdx);

		return row;	 
		
	}
	
	@Override
	public int boardQnaBad(int bIdx){

		int row = 0;
		BoardQnaMapper boardQnaMapper = sqlSession.getMapper(BoardQnaMapper.class);
		row = boardQnaMapper.boardQnaBad(bIdx);
		
		return row;	 
	
	}
		
}
