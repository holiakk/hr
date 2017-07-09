package test.dao.factory;

import test.dao.MemberDAOImpl;
import test.dao.proxy.DAOProxy;

public class DAOFactory {
	public static Object getIMemberDAO() {
		//传入真实主题对象，返回代理对象
		return new DAOProxy().bind(new MemberDAOImpl());
	}
}
