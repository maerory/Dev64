package net.n1books.dev.di04;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mbean")
public class MessageBeanImpl implements MessageBean {
	@Value("${name}")
	private String name;
	
	@Value("${greeting}")
	private String greeting;
	
	@Autowired
	private FileOutput output;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void setOutput(FileOutput output) {
		this.output = output;
	}
	
	@Override
	public void sayHello() {
		System.out.println(greeting + " " + name + "씨~");
		try {
			output.outputter(greeting + " " + name + "씨~");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
