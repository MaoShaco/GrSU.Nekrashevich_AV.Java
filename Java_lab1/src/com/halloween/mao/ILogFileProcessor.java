package com.halloween.mao;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Mao on 3/22/2015.
 */
public interface ILogFileProcessor {
    List<AccessLog> getLogs();

    void process(String DataBasePath, String StarterPosition, String RowsAmount, String OutBasePath, String ReportNumber) throws FileNotFoundException;
}
