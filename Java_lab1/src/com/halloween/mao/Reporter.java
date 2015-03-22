package com.halloween.mao;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Mao on 3/22/2015.
 */
public class Reporter implements IReporter {

    ILogSearcher logSearcher;
    IWriter Writer;
    List<AccessLog> Logs;

    public Reporter(ILogSearcher logSearcher, IWriter Writer) {
        this.logSearcher = logSearcher;
        this.Writer = Writer;
    }
    private List<AccessLog> findByDate(int starterDate, int finalDate) {

        String pattern = "[dd/MMM/yyyy:HH:mm:ss Z]";
        String sDate = "[" + starterDate + "/Aug/1995:00:00:00 -0400]";
        String fDate = "[" + finalDate + "/Aug/1995:23:59:59 -0400]";

        Date StarterDate = new SimpleDateFormat(pattern)
                .parse(sDate, new ParsePosition(sDate.indexOf("[")));
        Date FinalDate = new SimpleDateFormat(pattern)
                .parse(fDate, new ParsePosition(fDate.indexOf("[")));

        int starterIndex = logSearcher.binarySearch(StarterDate, Logs, 0, Logs.size());
        int finalIndex = logSearcher.binarySearch(FinalDate, Logs, 0, Logs.size());

        return Logs.subList(starterIndex, finalIndex);
    }

    @Override
    public void MostOften(int starterData, int finalData, int amount, List<AccessLog> Logs) {
        MostOften(starterData, finalData, amount, Logs, "MostOftenReport.txt");
    }

    @Override
    public void MostOften(int starterData, int finalData, int amount, List<AccessLog> Logs, String outFile) {
        this.Logs = Logs;

        Map<String, Integer> Dict = new HashMap<String, Integer>();
        for (AccessLog str : findByDate(starterData, finalData)) {
            if (Dict.containsKey(str.getLocalHost().toString()))
                Dict.put(str.getLocalHost().toString(), Dict.get(str.getLocalHost().toString()) + 1);
            else
                Dict.put(str.getLocalHost().toString(), 1);
        }

        List list = new ArrayList(Dict.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> b, Map.Entry<String, Integer> a) {
                return a.getValue().compareTo(b.getValue());
            }
        });
        int subListIndex = amount;
        if(list.size() < amount)
            subListIndex = list.size();

        Writer.write(outFile, list.subList(0, subListIndex));
    }

    @Override
    public void SumAnswers(int starterDate, int finalDate, List<AccessLog> Logs) {
        this.Logs = Logs;
        int TotalSum = 0;
        for(AccessLog str : findByDate(starterDate, finalDate)){
            TotalSum += str.getReplyBytes();
        }
        System.out.println("Total Bytes for answers: " + TotalSum);
    }
    @Override
    public void MaxBytesPerAnswer(int starterDate, int finalDate, List<AccessLog> Logs) {
        this.Logs = Logs;
        int Max = 0;
        for(AccessLog str : findByDate(starterDate, finalDate)){
            if(str.getReplyBytes() > Max)
                Max = str.getReplyBytes();
        }
        System.out.println("Max Answer " + Max);
    }
}
