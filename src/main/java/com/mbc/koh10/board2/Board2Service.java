package com.mbc.koh10.board2;

import java.util.ArrayList;

public interface Board2Service {

	void insertb(String name, String title, String content);

	ArrayList<Board2DTO> allout();

	void readcntup(int bnum);

	Board2DTO detail(int bnum);

	Board2DTO data(int bnum);

	void stetup(int groups, int step);

	void appendc(int bnum, String title, String name, String content, int groups, int step, int indent);

	int total();

	ArrayList<Board2DTO> page(PageDTO dto);

}
