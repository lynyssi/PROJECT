package com.mirin.tech.service;

import java.util.ArrayList;

public interface BoardFaqService {
	public ArrayList<BoardVo> boardFaqList();
	public BoardVo boardFaqCon(int bIdx);
	public int boardFaqHit(int bIdx);
}
