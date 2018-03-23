package net.n1books.dev.di04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileOutputterImpl implements FileOutput {

	@Value("${fileName}")
	private File fileName;
	
	@Override
	public void outputter(String msg) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
		fileWriter.write(msg);
		fileWriter.close();
	}
}
