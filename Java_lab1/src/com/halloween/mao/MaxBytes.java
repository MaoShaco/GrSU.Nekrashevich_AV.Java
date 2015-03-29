package com.halloween.mao;

import java.util.List;

/**
 * Created by Mao on 3/28/2015.
 */
public class MaxBytes extends PreReportGenerater implements IReportMaxBytes

{
	public MaxBytes(ILogSearcher logSearcher) {
		super(logSearcher);
	}

	@Override
	public MaxBytesClass Report(int starterData, int finalData, List<AccessLog> Logs) {
		this.Logs = Logs;
		int Max = 0;
		for (AccessLog str : findByDate(starterData, finalData)) {
			if (str.getReplyBytes() > Max)
				Max = str.getReplyBytes();
		}
		MaxBytesClass MaxBytes = new MaxBytesClass(Max);
		return MaxBytes;
	}
}
