package test;


import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import test.vo.Member;

class MemberDAOImpl {
	public void doCreate(Member vo) {
		System.out.println("增加处理对象 ...");
	}
}

class MyProxy implements MethodInterceptor {
	private Object target; //真实操作主题
	public MyProxy(Object target) {
		this.target = target;
	}
	@Override
	public Object intercept(Object proxy, Method method, 
			Object[] args, MethodProxy mProxy)
			throws Throwable {
		Object retObj = null;
		this.prepare();
		retObj = method.invoke(this.target, args);
		this.commit();
		return retObj;
	}
	public void prepare() {
		System.out.println("关闭数据库自动提交");
	}
	public void commit() {
		System.out.println("数据库的事务处理");
	}
	
}

public class TestCGLIB {
	public static void main(String[] args) {
		MemberDAOImpl realDAO = new MemberDAOImpl(); //真实主题
		//代理模式必须有公共集合点，例如：接口，但是CGLIB没有接口
		//所以使用以下手法：
		Enhancer enhancer = new Enhancer(); //创建一个代理工具类
		enhancer.setSuperclass(MemberDAOImpl.class); //设置一个模拟父类
		enhancer.setCallback(new MyProxy(realDAO)); //设置代理的回调操作
		//创建代理类对象：
		MemberDAOImpl proxyDAO = (MemberDAOImpl)enhancer.create();
		proxyDAO.doCreate(new Member());
	}
}
