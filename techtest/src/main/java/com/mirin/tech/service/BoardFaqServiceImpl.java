package com.mirin.tech.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardFaqServiceImpl implements BoardFaqService{
	
	@Autowired
	private SqlSession sqlSession;
		
	@Override
	public ArrayList<BoardVo> boardFaqList(){

		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		BoardFaqMapper boardFaqMapper = sqlSession.getMapper(BoardFaqMapper.class);
		alist = boardFaqMapper.boardFaqList();
		
		return alist;
		
	}

	@Override
	public BoardVo boardFaqCon(int bIdx){
		
		BoardVo vo = new BoardVo();	
		BoardFaqMapper boardFaqMapper = sqlSession.getMapper(BoardFaqMapper.class);
		vo = boardFaqMapper.boardFaqCon(bIdx);	
							
		return vo;
	}
	
	@Override
	public int boardFaqHit(int bIdx){
		
		int row = 0;
		BoardFaqMapper boardFaqMapper = sqlSession.getMapper(BoardFaqMapper.class);
		row = boardFaqMapper.boardFaqHit(bIdx);
		
		return row;
	}
		
}
