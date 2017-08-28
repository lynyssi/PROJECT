package com.mirin.tech.service;

import java.util.ArrayList;

public interface BoardNoticeMapper {
	public ArrayList<BoardVo> boardNoticeList();
	public BoardVo boardNoticeCon(int bIdx);
	//BoardNoticeCommList 댓글 리스트 
	public ArrayList<BoardCommVo> boardNoticeCommList(int bIdx);
	public int boardNoticeHit(int bIdx);
}
