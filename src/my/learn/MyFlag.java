package my.learn;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyFlag {
	//����һ��name����
	public String name() default "hello";
	//����һ��value����
	public String value();
	
	
}
