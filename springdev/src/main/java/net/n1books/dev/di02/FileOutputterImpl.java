package net.n1books.dev.di02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputterImpl implements FileOutput {
	private File fileName;
	
	public void setFileName(File fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void outputter(String msg) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
		fileWriter.write(msg);
		fileWriter.close();
	}
}
