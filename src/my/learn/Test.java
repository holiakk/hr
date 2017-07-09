package my.learn;

import java.lang.annotation.Annotation;

@MyFlag(name="уехЩ", value="nihao!")
public class Test {
	
	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("my.learn.Test");
		Annotation an[] = cls.getAnnotations();
		for(int i = 0; i < an.length; ++i) {
			MyFlag mf = (MyFlag)an[i];
			System.out.println("name = " + mf.name());
			System.out.println("values = " + mf.value());
		}
	}
}
