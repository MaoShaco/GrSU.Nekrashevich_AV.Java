package com.halloween.mao;

import java.util.List;

/**
 * Created by Mao on 3/22/2015.
 */
public interface IReporter {
    void MostOften(int starterData, int finalData, int amount, List<AccessLog> Logs);

    void MostOften(int starterData, int finalData, int amount, List<AccessLog> Logs, String outFile);

    void SumAnswers(int starterDate, int finalDate, List<AccessLog> Logs);

    void MaxBytesPerAnswer(int starterDate, int finalDate, List<AccessLog> Logs);
}
