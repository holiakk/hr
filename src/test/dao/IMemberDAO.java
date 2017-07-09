package test.dao;

import java.util.List;

import test.vo.Member;

public interface IMemberDAO {
	public boolean doCreate(Member vo) throws Exception;
	public List<Member> findAll()throws Exception;
}
