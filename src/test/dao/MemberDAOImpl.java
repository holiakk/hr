package test.dao;


import java.util.List;

import test.vo.Member;

public class MemberDAOImpl implements IMemberDAO {

	@Override
	public boolean doCreate(Member vo) throws Exception {
		System.out.println("数据库增加！");
		return false;
	}

	@Override
	public List<Member> findAll() throws Exception {
		System.out.println("数据列表！");
		return null;
	}

}
