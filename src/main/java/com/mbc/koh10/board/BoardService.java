package com.mbc.koh10.board;
import java.util.ArrayList;
public interface BoardService {
	void insertboard(String name, String title, String content);

	ArrayList<BoardDTO> boardallout();

	void readcntup(int bnum);

	BoardDTO detail(int bnum);

	BoardDTO dtodata(int bnum);

	void appendc(int bnum, String title, String name, String content, int groups, int step, int indent);

	void stetup(int groups, int step);

}

