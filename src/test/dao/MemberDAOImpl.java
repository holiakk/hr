package test.dao;


import java.util.List;

import test.vo.Member;

public class MemberDAOImpl implements IMemberDAO {

	@Override
	public boolean doCreate(Member vo) throws Exception {
		System.out.println("���ݿ����ӣ�");
		return false;
	}

	@Override
	public List<Member> findAll() throws Exception {
		System.out.println("�����б�");
		return null;
	}

}
