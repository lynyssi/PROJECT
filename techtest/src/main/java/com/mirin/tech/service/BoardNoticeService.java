package com.mirin.tech.service;

import java.util.ArrayList;

public interface BoardNoticeService {
	public ArrayList<BoardVo> boardNoticeList( );
	public BoardVo boardNoticeCon(int bIdx);
	public ArrayList<BoardCommVo> boardNoticeCommList(int bIdx);
	public int boardNoticeHit(int bIdx);
}
