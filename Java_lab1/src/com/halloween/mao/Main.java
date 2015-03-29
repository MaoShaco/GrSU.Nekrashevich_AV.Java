package com.halloween.mao;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		IParserForLog parser = new ParserForLog();
		IWriter Writer = new Writer();
		ILogSearcher logSearcher = new LogSearcher();
		ILogFileProcessor httpParser = new LogFileProcessor(Writer, parser, logSearcher);

		httpParser.process(args[0], args[1], args[2], args[3], args[4]);

	}
}




