package com.mirin.tech.service;

import java.util.ArrayList;
import java.util.Map;

public interface BoardQnaMapper {
	public int boardQnaWrite(BoardVo bv);
	public ArrayList<BoardVo> boardQnaList(int idx);
	public BoardVo boardQnaCon(int bIdx);
	public int boardQnaMod(BoardVo bv);
	public int boardQnaDel(int bIdx);
	public int boardQnaHit(int bIdx);
	public int boardQnaGood(int bIdx);
	public int boardQnaBad(int bIdx);
	public BoardVo boardQnaModCon(int sess_idx);
	

}
