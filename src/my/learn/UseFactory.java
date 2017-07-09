package my.learn;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UseFactory {
	/**
	 * 取得工厂类可以实例化的类名称
	 * @return 返回"包.类名称"
	 */
	public String className();
}
