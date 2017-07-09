package test;


import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import test.vo.Member;

class MemberDAOImpl {
	public void doCreate(Member vo) {
		System.out.println("���Ӵ������ ...");
	}
}

class MyProxy implements MethodInterceptor {
	private Object target; //��ʵ��������
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
		System.out.println("�ر����ݿ��Զ��ύ");
	}
	public void commit() {
		System.out.println("���ݿ��������");
	}
	
}

public class TestCGLIB {
	public static void main(String[] args) {
		MemberDAOImpl realDAO = new MemberDAOImpl(); //��ʵ����
		//����ģʽ�����й������ϵ㣬���磺�ӿڣ�����CGLIBû�нӿ�
		//����ʹ�������ַ���
		Enhancer enhancer = new Enhancer(); //����һ����������
		enhancer.setSuperclass(MemberDAOImpl.class); //����һ��ģ�⸸��
		enhancer.setCallback(new MyProxy(realDAO)); //���ô���Ļص�����
		//�������������
		MemberDAOImpl proxyDAO = (MemberDAOImpl)enhancer.create();
		proxyDAO.doCreate(new Member());
	}
}
