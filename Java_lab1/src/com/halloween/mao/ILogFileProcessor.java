package com.halloween.mao;

import java.io.FileNotFoundException;

/**
 * Created by Mao on 3/17/2015.
 */
public interface ILogFileProcessor {
    void process(String DataBasePath, String StarterPosition, String RowsAmount, String OutBasePath) throws FileNotFoundException;
}
