package com.mbc.koh10.sang;

import java.util.ArrayList;

public interface SangService {

	void inserts(String sname, String simage);

	ArrayList<SangDTO> allout();

	void delete2(int snum);

	SangDTO delete1(int snum);

	SangDTO update1(int snum);

	void update2(int snum, String sname, String simage);

	ArrayList<SangDTO> search1(String spname);

}
