package com.halloween.mao;

import java.util.List;

/**
 * Created by Mao on 3/22/2015.
 */
public interface IReportGenerater {
	List<Host> Report(int starterData, int finalData, List<AccessLog> Logs);

    /*void SumAnswers(int starterDate, int finalDate, List<AccessLog> Logs);

    void MaxBytesPerAnswer(int starterDate, int finalDate, List<AccessLog> Logs);*/
}
