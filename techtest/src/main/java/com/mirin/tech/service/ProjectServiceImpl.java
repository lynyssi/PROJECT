package com.mirin.tech.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<ProjectVo> projListByCate(String pCate){
		
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>(); 
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		alist = projectMapper.projListByCate(pCate);
		
		return alist;
	}
	
	@Override
	public ArrayList<ProjectVo> projListByPower(){
		
		ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>(); 
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		plist = projectMapper.projListByPower();
	
		return plist;
	}
	
	@Override
	public ArrayList<ProjectVo> projListByTech(){
		
		ArrayList<ProjectVo> plist = new ArrayList<ProjectVo>(); 
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		plist = projectMapper.projListByTech();
		
		return plist;
	}

	@Override
	public ProjectVo projCon(int pIdx){
		
		ProjectVo pv = new ProjectVo(); 
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		pv = projectMapper.projCon(pIdx);
		
		return pv;
	}

	@Override
	public MemberVo projConCmem(int pIdx){
		
		MemberVo mv = new MemberVo(); 
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		mv = projectMapper.projConCmem(pIdx);
		
		return mv;
	}
	
	@Override
	public ArrayList<ProjectCommVo> projConCommList(int pIdx){
		
		ArrayList<ProjectCommVo> pclist = new ArrayList<ProjectCommVo>(); 
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		pclist = projectMapper.projConCommList(pIdx);
		
		return pclist;
	}
	
	@Override
	public ArrayList<ItemVo> projConItemList(int pIdx){
		
		ArrayList<ItemVo> itemList = new ArrayList<ItemVo>();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);		
		itemList = projectMapper.projConItemList(pIdx);
		
		return itemList;
	}
	
	@Override
	public ItemVo projPayItem(int itIdx){
		
		ItemVo iv = new ItemVo();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		iv = projectMapper.projPayItem(itIdx);
		
		return iv;
	}
	
	@Override
	public Map<String, Object> projPayMyMoney(int sess_idx){
		
		Map<String, Object> data = new HashMap<String, Object>();
		ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
		data = projectMapper.projPayMyMoney(sess_idx);
		
		return data;
	}
/*
	public ArrayList<ProjectCommVo> projConCommList(int pIdx, int listCnt, int pageCnt){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		ArrayList<ProjectCommVo> alist = new ArrayList<ProjectCommVo>(); 
		
		try { 
			
			this.sql = "SELECT * "
				+	"FROM TF_PROJECT_COMM "
				+	"WHERE VIEWSTAT = 1 "
				+		"AND PIDX = ? "
				+	"ORDER BY OPCOMMIDX DESC, RPCOMMIDX ASC";
					
			this.sql = new PagingQ().pagingStr(sql, listCnt, pageCnt);
			
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, pIdx);
			rs = pstmt.executeQuery();

			while(rs.next()) { 
				
				ProjectCommVo vo = new ProjectCommVo(); 
				vo.setpCommIdx(rs.getInt("pcommidx"));
				vo.setComments(rs.getString("comments"));
				vo.setGood(rs.getInt("good"));
				vo.setBad(rs.getInt("bad"));
				vo.setOpCommIdx(rs.getInt("opcommidx"));
				vo.setRpCommIdx(rs.getInt("rpcommidx"));
				vo.setpCommDepth(rs.getInt("pcommdepth"));
				vo.setViewStat(rs.getInt("viewstat"));
				
				alist.add(vo);
			}
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt,rs); 
		}
	
		return alist;
		
	}
	
	public int projPayTransaction(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			con.setAutoCommit(false);
			
			this.sql = "INSERT INTO TF_FUND_HIS (FIDX, PIDX, ITIDX, IDX, INFUNDS, BFUNDS, AFUNDS, STATUS, INSDATE) "
				+	"VALUES (SEQ_TF_FIDX.NEXTVAL, ?, ?, ?, ?, (SELECT * FROM (SELECT AFUNDS FROM TF_FUND_HIS WHERE PIDX = ? ORDER BY FIDX DESC) WHERE ROWNUM = 1), (SELECT * FROM (SELECT AFUNDS FROM TF_FUND_HIS WHERE PIDX = ? ORDER BY FIDX DESC) WHERE ROWNUM = 1) + ?, 1, SYSDATE)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getpIdx());
			pstmt.setInt(2, vo.getItIdx());
			pstmt.setInt(3, vo.getIdx());
			pstmt.setInt(4, vo.getInFunds());
			pstmt.setInt(5, vo.getpIdx());
			pstmt.setInt(6, vo.getpIdx());
			pstmt.setInt(7, vo.getInFunds());
			
			row = pstmt.executeUpdate();
			
			this.sql = "UPDATE TF_WISH_LIST "
				+	"SET VIEWSTAT = 0 "
				+	"WHERE VIEWSTAT = 1 "
				+		"AND IDX = ? "
				+		"AND PIDX = ?";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getIdx());
			pstmt.setInt(2, vo.getpIdx());
			
			row += pstmt.executeUpdate();
			
			this.sql = "UPDATE TF_IMEMBER_EXT "
				+	"SET MONEY = MONEY - ? "
				+	"WHERE IDX = ? ";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getInFunds());
			pstmt.setInt(2, vo.getIdx());
			
			row += pstmt.executeUpdate();
			
			this.sql = "UPDATE TF_PROJECT_LIST "
				+	"SET PNFUNDS = PNFUNDS + ? "
				+	"WHERE PIDX = ? ";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, vo.getInFunds());
			pstmt.setInt(2, vo.getpIdx());
						
			row += pstmt.executeUpdate();
			
			this.sql = "UPDATE TF_ITEM_LIST "
				+	"SET ITSCNT = ITSCNT + 1 "
				+	"WHERE ITIDX = ? ";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, vo.getItIdx());
						
			row += pstmt.executeUpdate();
			
			con.commit();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try{
				con.setAutoCommit(true);
			}catch(Exception e){
				e.getMessage();
			}
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projPay(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "INSERT INTO TF_FUND_HIS (FIDX, PIDX, ITIDX, IDX, INFUNDS, BFUNDS, AFUNDS, STATUS, INSDATE) "
				+	"VALUES (SEQ_TF_FIDX.NEXTVAL, ?, ?, ?, ?, (SELECT * FROM (SELECT AFUNDS FROM TF_FUND_HIS WHERE PIDX = ? ORDER BY FIDX DESC) WHERE ROWNUM = 1), (SELECT * FROM (SELECT AFUNDS FROM TF_FUND_HIS WHERE PIDX = ? ORDER BY FIDX DESC) WHERE ROWNUM = 1) + ?, 1, SYSDATE)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getpIdx());
			pstmt.setInt(2, vo.getItIdx());
			pstmt.setInt(3, vo.getIdx());
			pstmt.setInt(4, vo.getInFunds());
			pstmt.setInt(5, vo.getpIdx());
			pstmt.setInt(6, vo.getpIdx());
			pstmt.setInt(7, vo.getInFunds());
			
			row = pstmt.executeUpdate();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally {
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projConCommWrite(ProjectCommVo vo){
		
		int row = 0;
		
		try { 
			
			this.sql = "INSERT INTO TF_PROJECT_COMM (PCOMMIDX, PIDX, IDX, COMMENTS, GOOD, BAD, OPCOMMIDX, RPCOMMIDX, PCOMMDEPTH, VIEWSTAT, INSDATE, MODDATE) "
				+	"VALUES (SEQ_TF_PCOMMIDX.NEXTVAL, ?, ?, ?, 0, 0, SEQ_TF_PCOMMIDX.CURRVAL, 1, 1, 1, SYSDATE, SYSDATE)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getpIdx());
			pstmt.setInt(2, vo.getIdx());
			pstmt.setString(3, vo.getComments());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}

	public int projConSubCommWriteTransaction(ProjectCommVo vo) {
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			con.setAutoCommit(false);
			
			this.sql = "UPDATE TF_PROJECT_COMM "
				+	"SET RPCOMMIDX = RPCOMMIDX + 1 "
				+	"WHERE OPCOMMIDX = (SELECT OPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) "
				+		"AND RPCOMMIDX > (SELECT RPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getOpCommIdx());
			pstmt.setInt(2, vo.getOpCommIdx());
						
			row = pstmt.executeUpdate();
			
			this.sql = "INSERT INTO TF_PROJECT_COMM (PCOMMIDX, PIDX, IDX, COMMENTS, GOOD, BAD, OPCOMMIDX, RPCOMMIDX, PCOMMDEPTH, VIEWSTAT, INSDATE, MODDATE) "
				+	"VALUES (SEQ_TF_PCOMMIDX.NEXTVAL, ?, ?, ?, 0, 0, (SELECT OPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?), (SELECT RPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) + 1, (SELECT PCOMMDEPTH FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) + 1, 1, SYSDATE, SYSDATE)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getpIdx());
			pstmt.setInt(2, vo.getIdx());
			pstmt.setString(3, vo.getComments());
			pstmt.setInt(4, vo.getOpCommIdx());
			pstmt.setInt(5, vo.getOpCommIdx());
			pstmt.setInt(6, vo.getOpCommIdx());
			
			row += pstmt.executeUpdate();
	
			con.commit();
			
		}catch(Exception e) { 
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try{
				con.setAutoCommit(true);
			}catch(Exception e){
				e.getMessage();
			}
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projConSubCommWriteUpdate(ProjectCommVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "UPDATE TF_PROJECT_COMM "
				+	"SET RPCOMMIDX = RPCOMMIDX + 1 "
				+	"WHERE OPCOMMIDX = (SELECT OPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) "
				+		"AND RPCOMMIDX > (SELECT RPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getOpCommIdx());
			pstmt.setInt(2, vo.getOpCommIdx());
						
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projConSubCommWriteInsert(ProjectCommVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "INSERT INTO TF_PROJECT_COMM (PCOMMIDX, PIDX, IDX, COMMENTS, GOOD, BAD, OPCOMMIDX, RPCOMMIDX, PCOMMDEPTH, VIEWSTAT, INSDATE, MODDATE) "
				+	"VALUES (SEQ_TF_PCOMMIDX.NEXTVAL, ?, ?, ?, 0, 0, (SELECT OPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?), (SELECT RPCOMMIDX FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) + 1, (SELECT PCOMMDEPTH FROM TF_PROJECT_COMM WHERE PCOMMIDX = ?) + 1, 1, SYSDATE, SYSDATE)";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getpIdx());
			pstmt.setInt(2, vo.getIdx());
			pstmt.setString(3, vo.getComments());
			pstmt.setInt(4, vo.getOpCommIdx());
			pstmt.setInt(5, vo.getOpCommIdx());
			pstmt.setInt(6, vo.getOpCommIdx());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projPayWishListDel(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "UPDATE TF_WISH_LIST "
				+	"SET VIEWSTAT = 0 "
				+	"WHERE VIEWSTAT = 1 "
				+		"AND IDX = ? "
				+		"AND PIDX = ?";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getIdx());
			pstmt.setInt(2, vo.getpIdx());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projPayMyMoneyChg(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "UPDATE TF_IMEMBER_EXT "
				+	"SET MONEY = MONEY - ? "
				+	"WHERE IDX = ? ";
		
			pstmt = con.prepareStatement(this.sql); 
			pstmt.setInt(1, vo.getInFunds());
			pstmt.setInt(2, vo.getIdx());
			
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projPayPnFundsMod(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "UPDATE TF_PROJECT_LIST "
				+	"SET PNFUNDS = PNFUNDS + ? "
				+	"WHERE PIDX = ? ";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, vo.getInFunds());
			pstmt.setInt(2, vo.getpIdx());
						
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
	
	public int projPayItemSellCntMod(FundVo vo){
		
		Connection con = dbconnect.getConnection(); 
		PreparedStatement pstmt = null; 
		int row = 0;
		
		try { 
			
			this.sql = "UPDATE TF_ITEM_LIST "
				+	"SET ITSCNT = ITSCNT + 1 "
				+	"WHERE ITIDX = ? ";
		
			pstmt = con.prepareStatement(this.sql);
			pstmt.setInt(1, vo.getItIdx());
						
			row = pstmt.executeUpdate();
	
		}catch(Exception e) { 
			System.out.println(e.getMessage());
		}finally { 
			DBClose.close(con,pstmt); 
		}
	
		return row;
		
	}
*/	
}

