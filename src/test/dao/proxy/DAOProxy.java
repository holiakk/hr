package test.dao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//����һ����̬�����࣬���Դ������ж���
public class DAOProxy implements InvocationHandler { 
	//������invoke()�����б���֪����ʵ��������һ��
	private Object obj; //������ʵ��������
	/**
	 * ��Ҫ��������ʵ������󱣴浽����֮�У���󷵻�һ�����������
	 * @param obj ��ʵ�������
	 * @return ���������
	 */
	public Object bind(Object obj) {
		this.obj = obj; //������ʵ����
		//��ʱ�����������Javaϵͳ�Զ����ɵ�
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), this);

	}
	
	//�����Ǵ�����ĸ����ӿ�
	public void prepare() {
		System.out.println("ȡ��JDBC�Զ��ύ");
	}
	public void commit() {
		System.out.println("�ύJDBC����");
	}
	public void rollback() {
		System.out.println("���ִ��󣬻ع�JDBC����");
	}
	//ֻҪִ���˲���������һ���ᴥ��invoke()
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object retObj = null;
		if(method.getName().contains("do")) { //���²������������������
			this.prepare();
			try {
				retObj = method.invoke(this.obj, args);
				this.commit();
			} catch(Exception e) {
				this.rollback();
			}
			
		} else { //��ѯ������������������
			retObj = method.invoke(obj, args);
		}
		return retObj;
	}

}
