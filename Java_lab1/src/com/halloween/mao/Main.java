package com.halloween.mao;

import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        List<AccessLog> Logs = new Vector<AccessLog>();

        String dataBasePath = args[0];
        Reader textReader = new Reader(dataBasePath);

        int starterPosition = Integer.parseInt(args[1]) + 1;
        int rowsAmount = Integer.parseInt(args[2]) - 1;
        String[] RequiredStrings = textReader.GetStrings(starterPosition, rowsAmount).split("\n");
        for (String str : RequiredStrings) {
            Logs.add(ParserForLog.getAccessLog(str));
        }

        String outBasePath = args[3];
        for (AccessLog str : Logs) {
            Writer.write(outBasePath, str.toString());
        }
    }
}




