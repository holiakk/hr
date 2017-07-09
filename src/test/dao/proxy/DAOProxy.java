package test.dao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//这是一个动态代理类，可以代理所有对象
public class DAOProxy implements InvocationHandler { 
	//在随后的invoke()操作中必须知道真实主题是哪一个
	private Object obj; //这是真实对象主题
	/**
	 * 将要操作的真实主题对象保存到代理之中，随后返回一个代理类对象
	 * @param obj 真实主题对象
	 * @return 代理类对象
	 */
	public Object bind(Object obj) {
		this.obj = obj; //保存真实主题
		//此时代理对象是由Java系统自动生成的
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), this);

	}
	
	//下面是代理类的辅助接口
	public void prepare() {
		System.out.println("取消JDBC自动提交");
	}
	public void commit() {
		System.out.println("提交JDBC事务");
	}
	public void rollback() {
		System.out.println("出现错误，回滚JDBC事务");
	}
	//只要执行了操作方法，一定会触发invoke()
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object retObj = null;
		if(method.getName().contains("do")) { //更新操作，必须进行事务处理
			this.prepare();
			try {
				retObj = method.invoke(this.obj, args);
				this.commit();
			} catch(Exception e) {
				this.rollback();
			}
			
		} else { //查询操作，不进行事务处理
			retObj = method.invoke(obj, args);
		}
		return retObj;
	}

}
