package com.mirin.tech.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardNewsServiceImpl implements BoardNewsMapper {
	
	@Autowired
	private SqlSession sqlSession;
			
	//뉴스 카테고리 별 리스트
	@Override
	public ArrayList<BoardVo> boardNewsListCate(String cate){
			
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		BoardNewsMapper boardNewsMapper = sqlSession.getMapper(BoardNewsMapper.class);
	    alist = boardNewsMapper.boardNewsListCate(cate);			
		
		return alist;
	
	}

	@Override
	public BoardVo boardNewsCon(int bIdx){
		
		BoardVo bv = new BoardVo();
		BoardNewsMapper boardNewsMapper = sqlSession.getMapper(BoardNewsMapper.class);
		bv = boardNewsMapper.boardNewsCon(bIdx);
		
		return bv;
	
	}
	
	@Override
	public ArrayList<Map<String, Object>> boardNewsCommList(int bIdx){
		
		ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		BoardNewsMapper boardNewsMapper = sqlSession.getMapper(BoardNewsMapper.class);		
		data =  boardNewsMapper.boardNewsCommList(bIdx);
		
		return data;
	
	}
	
	@Override
	public int boardNewsHit(int bIdx){
				
		int row = 0;
		BoardNewsMapper boardNewsMapper = sqlSession.getMapper(BoardNewsMapper.class);
		row = boardNewsMapper.boardNewsHit(bIdx);
		
		return row;	 
	
	}
	
	@Override
	public ArrayList<Map<String, Object>> BoardNewsSubCommList(int commIdx){
		
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
		BoardNewsMapper boardNewsMapper = sqlSession.getMapper(BoardNewsMapper.class);			
		alist = boardNewsMapper.BoardNewsSubCommList(commIdx);	
						
		return alist;
	
	}
	
	@Override
	public int boardNewsCommWrite(BoardCommVo vc){
		int row = 0;
		BoardNewsMapper boardNewsMapper = sqlSession.getMapper(BoardNewsMapper.class);
			
		
		return row;
	
	}

	@Override
	public int boardNewsCommWriteCntMod(BoardCommVo vc){
		
	
		int row = 0;
		BoardNewsMapper boardNewsMapper = sqlSession.getMapper(BoardNewsMapper.class);
		 	
		
		return row;
	
	}
	
	@Override
	public int boardNewsCommDel(int commIdx){
		  
		 int row = 0;
		 BoardNewsMapper boardNewsMapper = sqlSession.getMapper(BoardNewsMapper.class);		  		  
			
		 return row;
	  
	 }
	

		
	@Override
	public int boardNewsGood(int bIdx){
		
		int row = 0;
		BoardNewsMapper boardNewsMapper = sqlSession.getMapper(BoardNewsMapper.class);

		return row;	 
		
	}
	
	@Override
	public int boardNewsBad(int bIdx){
	
		int row = 0;
		BoardNewsMapper boardNewsMapper = sqlSession.getMapper(BoardNewsMapper.class);
							
		return row;	 
	
	}
	/*	
	//뉴스 대댓글 작성 
	public int boardNewsSubCommWriteTransaction(BoardCommVo vc){
		
		
		int row = 0;
		
		try{
			 
			con.setAutoCommit(false);
			
			this.sql = "UPDATE TF_BOARD_COMM_NEWS "
				+	"SET RCOMMIDX = RCOMMIDX + 1 "
				+	"WHERE OCOMMIDX = ? "
				+ 		"AND BIDX = ?";
		
			pstmt = con.prepareStatement(this.sql);	
			
			pstmt.setInt(1, vc.getCommIdx());
			pstmt.setInt(2, vc.getbIdx());
							
			row += pstmt.executeUpdate();
			
			this.sql = "INSERT INTO TF_BOARD_COMM_NEWS (COMMIDX, BIDX, IDX, COMMENTS, GOOD, BAD, OCOMMIDX, RCOMMIDX, COMMDEPTH, VIEWSTAT, INSDATE, MODDATE ) "
				+	"VALUES (SEQ_TF_COMMIDX_NEWS.NEXTVAL, ?, ?, ?, 0, 0, ?, 1, 1, 1, SYSDATE, SYSDATE )";	
				
			pstmt = con.prepareStatement(this.sql);
		
			pstmt.setInt(1, vc.getbIdx());
			pstmt.setInt(2, vc.getIdx());
			pstmt.setString(3, vc.getComments());
			pstmt.setInt(4, vc.getCommIdx());
				
			row += pstmt.executeUpdate();
			
			con.commit();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			try{
				con.rollback();
			} catch(SQLException e1){
				e1.printStackTrace();
			}
		}finally{
			try{
				con.setAutoCommit(true);
			}catch(Exception e){
				e.getMessage();
			}
			DBClose.close(con,pstmt);
		}
		
		return row;
		
	}
	*/

		
}
