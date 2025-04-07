package com.mbc.koh10.member;

import java.util.ArrayList;

public interface MemberService {

	void inserts(String id, String pw, String name);

	ArrayList<MemberDTO> allout();

	int idcheck(String id);

}
