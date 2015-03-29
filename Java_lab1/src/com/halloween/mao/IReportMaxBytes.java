package com.halloween.mao;

import java.util.List;

/**
 * Created by Mao on 3/28/2015.
 */
public interface IReportMaxBytes {
	MaxBytesClass Report(int starterData, int finalData, List<AccessLog> Logs);
}
