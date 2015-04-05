package com.halloween.mao;

import java.util.List;

/**
 * Created by Mao on 3/28/2015.
 */
public class TotalSumAnswers extends PreReportGenerater implements IReportGenerater<ReportParams, TotalSumBytesClass> {
	public TotalSumAnswers(ILogSearcher logSearcher) {
		super(logSearcher);
	}


	@Override
	public TotalSumBytesClass Report(ReportParams reportParams) {
		this.Logs = reportParams.Logs;
		int TotalSum = 0;
		for (AccessLog str : findByDate(reportParams.starterData, reportParams.finalData)) {
			TotalSum += str.getReplyBytes();
		}
		TotalSumBytesClass Sum = new TotalSumBytesClass(TotalSum);
		return Sum;
	}
}
