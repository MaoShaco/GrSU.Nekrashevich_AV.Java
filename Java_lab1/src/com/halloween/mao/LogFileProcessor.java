package com.halloween.mao;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Vector;

/**
 * Created by Mao on 3/14/2015.
 */
public class LogFileProcessor implements ILogFileProcessor {

    @Override
    public  void process(String DataBasePath, String StarterPosition, String RowsAmount, String OutBasePath) throws FileNotFoundException {

        List<AccessLog> Logs = new Vector<AccessLog>();

        String dataBasePath = DataBasePath;
        IReader textReader = new Reader(dataBasePath);

        int starterPosition = Integer.parseInt(StarterPosition) + 1;
        int rowsAmount = Integer.parseInt(RowsAmount) - 1;
        String[] RequiredStrings = textReader.GetStrings(starterPosition, rowsAmount).split("\n");
        for (String str : RequiredStrings) {
            IParserForLog Parser = new ParserForLog();
            Logs.add(Parser.getAccessLog(str));
        }

        String outBasePath = OutBasePath;
        for (AccessLog str : Logs) {
            IWriter LogWriter = new Writer();
            LogWriter.write(outBasePath, str.toString());
        }
    }
}
