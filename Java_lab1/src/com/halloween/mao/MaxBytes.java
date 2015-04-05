package com.halloween.mao;

import java.util.List;

/**
 * Created by Mao on 3/28/2015.
 */
public class MaxBytes extends PreReportGenerater implements IReportGenerater<ReportParams, MaxBytesClass>

{
	public MaxBytes(ILogSearcher logSearcher) {
		super(logSearcher);
	}

	@Override
	public MaxBytesClass Report(ReportParams reportParams) {
		this.Logs = reportParams.Logs;
		int Max = 0;
		AccessLog MaxReq = Logs.get(0);
		for (AccessLog str : findByDate(reportParams.starterData, reportParams.finalData)) {
			if (str.getReplyBytes() > Max) {
				Max = str.getReplyBytes();
				MaxReq = str;
			}
		}
		MaxBytesClass MaxBytes = new MaxBytesClass(MaxReq);
		return MaxBytes;
	}
}
