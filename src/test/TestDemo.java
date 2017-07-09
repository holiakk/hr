package test;

import test.dao.IMemberDAO;
import test.dao.factory.DAOFactory;
import test.vo.Member;

public class TestDemo {

	public static void main(String[] args) throws Exception {
		//��ʱ���ش�������󣬵�����ʵ����������ʵ������ĸ��ӿ�
		IMemberDAO dao = (IMemberDAO)DAOFactory.getIMemberDAO();
		Member vo = new Member();
		dao.doCreate(vo);
		dao.findAll();
	}

}
