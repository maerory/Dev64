package net.n1books.dev.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.ClassUtils;

public class MessageBeanTest {
	public static void main(String[] args) {
		ApplicationContext context = 
				new GenericXmlApplicationContext(
					ClassUtils.classPackageAsResourcePath(MessageBeanTest.class) + 
					"/beaninit.xml");
		
		MessageBean mbean = (MessageBean) context.getBean("mbean");
		mbean.sayHello();
	}
}
