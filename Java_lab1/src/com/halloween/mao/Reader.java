package com.halloween.mao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Reader implements IReader {

	private String path;

	public Reader(String fileName) throws FileNotFoundException {
		{
			Exists(fileName);
			this.path = fileName;
		}
	}

	private void Exists(String fileName) throws FileNotFoundException {
		File DataBase = new File(fileName);
		if (!DataBase.exists()) {
			throw new FileNotFoundException(DataBase.getName());
		}
	}


	@Override
	public String GetStrings(int readFrom, int rowsToRead) {

		StringBuilder list = new StringBuilder();

		try {
			BufferedReader in = new BufferedReader(new FileReader(this.path));
			try {
				String bufferLine;
				int count = 0;
				while ((bufferLine = in.readLine()) != null && count - readFrom + 1 != rowsToRead) {
					count++;
					if (count >= readFrom - 1) {
						list.append(bufferLine);
						list.append('\n');
					}
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return list.toString();
	}
}
