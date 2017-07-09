package test.dao.factory;

import test.dao.MemberDAOImpl;
import test.dao.proxy.DAOProxy;

public class DAOFactory {
	public static Object getIMemberDAO() {
		//������ʵ������󣬷��ش������
		return new DAOProxy().bind(new MemberDAOImpl());
	}
}
