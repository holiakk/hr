package my.learn;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UseFactory {
	/**
	 * ȡ�ù��������ʵ������������
	 * @return ����"��.������"
	 */
	public String className();
}
