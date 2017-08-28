package com.mirin.tech.service;

import java.util.ArrayList;
import java.util.Map;

public interface BoardNewsService {
	public ArrayList<BoardVo> boardNewsListCate(String cate);
	public ArrayList<Map<String, Object>> boardNewsCommList(int bIdx);
	public BoardVo boardNewsCon(int bIdx);
	public ArrayList<Map<String, Object>> BoardNewsSubCommList(int commIdx);
	public int boardNewsCommWrite(BoardCommVo vc);
	public int boardNewsCommWriteCntMod(BoardCommVo vc);
	public int boardNewsCommDel(int commIdx);
	public int boardNewsHit(int bIdx);
	public int boardNewsGood(int bIdx);
	public int boardNewsBad(int bIdx);

}
