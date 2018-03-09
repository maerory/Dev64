package net.n1books.dev.di03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.ClassUtils;

public class TVUser {
	public static void main(String[] args) {
		ApplicationContext context =
			new GenericXmlApplicationContext(
				ClassUtils.classPackageAsResourcePath(TVUser.class) + "/beaninit.xml");
		
		TV tv = (TV) context.getBean("tv"); //new LgTV();
		tv.powerOn();
		tv.channelUp();
		tv.channelUp();
		tv.soundUp();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
	}
}
