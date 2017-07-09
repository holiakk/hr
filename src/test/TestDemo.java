package test;

import test.dao.IMemberDAO;
import test.dao.factory.DAOFactory;
import test.vo.Member;

public class TestDemo {

	public static void main(String[] args) throws Exception {
		//此时返回代理类对象，但是它实现了所有真实主题类的父接口
		IMemberDAO dao = (IMemberDAO)DAOFactory.getIMemberDAO();
		Member vo = new Member();
		dao.doCreate(vo);
		dao.findAll();
	}

}
