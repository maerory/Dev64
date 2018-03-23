package net.n1books.dev2.di;

import org.springframework.stereotype.Component;

@Component("mbean")
public class MessageBeanImpl implements MessageBean{
	
	@Override
	public String sayhello() {
		return "Hello~";
	}
}
