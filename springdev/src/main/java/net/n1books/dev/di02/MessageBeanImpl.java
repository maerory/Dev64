package net.n1books.dev.di02;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String greeting;
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
