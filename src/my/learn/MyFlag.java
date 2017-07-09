package my.learn;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyFlag {
	//定义一个name属性
	public String name() default "hello";
	//定义一个value属性
	public String value();
	
	
}
