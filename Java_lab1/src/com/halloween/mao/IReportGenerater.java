package com.halloween.mao;

import java.util.List;

/**
 * Created by Mao on 3/22/2015.
 */
public interface IReportGenerater<ReportParametres, OutReport> {
	OutReport Report(ReportParametres reportParams);
}
