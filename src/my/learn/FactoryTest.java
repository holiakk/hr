package my.learn;

import java.lang.annotation.Annotation;

interface Fruit {
	public void eat();
}

class Apple implements Fruit {

	@Override
	public void eat() {
		System.out.println("³ÔÆ»¹û");
	}
	
}
@UseFactory(className="my.learn.Apple")
public class FactoryTest {
	
	public static Fruit newIntance() {
		Fruit instance = null;
		Class<?> cls = FactoryTest.class;
		Annotation an = cls.getAnnotation(UseFactory.class);
		UseFactory uf = (UseFactory)an;
		try {
			instance = (Fruit)Class.forName(uf.className()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return instance;
	}

	public static void main(String[] args) {
		Fruit f = newIntance();
		f.eat();
	}

}
