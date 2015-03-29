package com.halloween.mao;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Mao on 3/28/2015.
 */
public abstract class PreReportGenerater {
	protected ILogSearcher logSearcher;
	protected List<AccessLog> Logs;

	public PreReportGenerater(ILogSearcher logSearcher) {
		this.logSearcher = logSearcher;
	}

	protected List<AccessLog> findByDate(int starterDate, int finalDate) {

		String pattern = "[dd/MMM/yyyy:HH:mm:ss Z]";
		String sDate = "[" + starterDate + "/Aug/1995:00:00:00 -0400]";
		String fDate = "[" + finalDate + "/Aug/1995:23:59:59 -0400]";

		Date StarterDate = new SimpleDateFormat(pattern)
				.parse(sDate, new ParsePosition(sDate.indexOf("[")));
		Date FinalDate = new SimpleDateFormat(pattern)
				.parse(fDate, new ParsePosition(fDate.indexOf("[")));

		int starterIndex = logSearcher.binarySearch(StarterDate, Logs, 0, Logs.size());
		int finalIndex = logSearcher.binarySearch(FinalDate, Logs, 0, Logs.size());


		return Logs.subList(starterIndex, finalIndex);
	}
}
