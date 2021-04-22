package com.thymeleaf.test;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		File file = new File("tests/");

		System.out.println(file.isDirectory());
		if (!file.isDirectory())
			file.mkdir();

		file = new File("tests/test.txt");

		System.out.println(file.exists());
		if (!file.exists())
			file.createNewFile();
		else
			file.delete();
	}

}