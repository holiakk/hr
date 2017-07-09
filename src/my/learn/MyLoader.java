package my.learn;

import java.io.*;
import java.lang.reflect.Method;

public class MyLoader extends ClassLoader {
	public Class<?> getMyClass(String className) throws ClassNotFoundException {
		//��������ļ�
		byte d[] = this.getFileData(className);
		return super.defineClass(className, d, 0, d.length);
	}
	private byte[] getFileData(String className) { //ͨ���ļ�������
		byte ret[] = null;
		try {
			File file = new File("D:" + File.separator + 
					className.substring(className.lastIndexOf(".") + 1) + ".class");
			InputStream input = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte data[] = new byte[1024];
			int len = 0;
			while((len = input.read(data)) != -1) {
				bos.write(data, 0, len);
			}
			ret = bos.toByteArray();
			bos.close();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	public static void main(String[] args) throws Exception {
		//ʹ���Զ����������
		Class<?> cls = new MyLoader().getMyClass("my.learn.ClassLoaderTest");
		Method m = cls.getMethod("fun");
		Object obj = cls.newInstance();
		m.invoke(obj);
	}
}
