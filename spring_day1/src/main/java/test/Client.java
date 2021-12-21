package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		/*BeanFactory factory=new BeanFactory();
		Phone phone=(Phone)factory.getBean(args[0]);
		phone.volumeUp();
		phone.msg();*/
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		Phone phone=(Phone)factory.getBean("phone");
		phone.volumeUp();
		phone.volumeDown();
		phone.msg();
		
		/*Phone p1=(Phone)factory.getBean("galaxyPhone");
		Phone p2=(Phone)factory.getBean("galaxyPhone");
		Phone p3=(Phone)factory.getBean("galaxyPhone");*/
		
		
		
		factory.close();
	}
}