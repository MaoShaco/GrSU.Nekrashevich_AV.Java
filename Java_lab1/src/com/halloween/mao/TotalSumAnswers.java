package com.halloween.mao;

import java.util.List;

/**
 * Created by Mao on 3/28/2015.
 */
public class TotalSumAnswers extends PreReportGenerater implements IReportSumAnswers {
	public TotalSumAnswers(ILogSearcher logSearcher) {
		super(logSearcher);
	}

	@Override
	public TotalSumBytesClass Report(int starterData, int finalData, List<AccessLog> Logs) {
		this.Logs = Logs;
		int TotalSum = 0;
		for (AccessLog str : findByDate(starterData, finalData)) {
			TotalSum += str.getReplyBytes();
		}
		TotalSumBytesClass Sum = new TotalSumBytesClass(TotalSum);
		return Sum;
	}
}
