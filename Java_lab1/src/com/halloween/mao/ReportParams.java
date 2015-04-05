package com.halloween.mao;

import java.util.List;

/**
 * Created by Mao on 4/4/2015.
 */
public class ReportParams {
	int starterData;
	int finalData;
	List<AccessLog> Logs;

	public ReportParams(int starterData, int finalData, List<AccessLog> Logs) {
		this.starterData = starterData;
		this.finalData = finalData;
		this.Logs = Logs;
	}
}
