package com.halloween.mao;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Mao on 3/14/2015.
 */
public class LogFileProcessor implements ILogFileProcessor {

	IParserForLog parser;
	IWriter logWriter;
	ILogSearcher logSearcher;

	List<AccessLog> Logs;

	public LogFileProcessor(IWriter logWriter, IParserForLog parser, ILogSearcher logSearcher) {
		this.logWriter = logWriter;
		this.parser = parser;
		this.logSearcher = logSearcher;
	}

	@Override
	public List<AccessLog> getLogs() {
		return this.Logs;
	}

	@Override
	public void process(String DataBasePath, String StarterPosition, String RowsAmount, String OutBasePath, String ReportNumber) throws FileNotFoundException {

		Logs = new Vector<AccessLog>();

		String dataBasePath = DataBasePath;
		IReader textReader = new Reader(dataBasePath);

		int starterPosition = Integer.parseInt(StarterPosition) + 1;
		int rowsAmount = Integer.parseInt(RowsAmount) - 1;
		String[] RequiredStrings = textReader.GetStrings(starterPosition, rowsAmount).split("\n");
		for (String str : RequiredStrings) {

			Logs.add(parser.getAccessLog(str));
		}

		String outBasePath = OutBasePath;
		logWriter.write(outBasePath, Logs);

		int reportNumber = Integer.parseInt(ReportNumber);
		switch (reportNumber) {
			case 1: {
				IReportGenerater Reporter = new MostOften(logSearcher);
				List<Host> mostOftenHost = Reporter.Report(1, 5, Logs);
				break;
			}
			case 2: {
				IReportSumAnswers Reporter = new TotalSumAnswers(logSearcher);
				TotalSumBytesClass totalSum = Reporter.Report(1, 5, Logs);
				break;
			}
			case 3: {
				IReportMaxBytes Reporter = new MaxBytes(logSearcher);
				MaxBytesClass maxBytes = Reporter.Report(1, 5, Logs);
				break;
			}
		}
	}
}
