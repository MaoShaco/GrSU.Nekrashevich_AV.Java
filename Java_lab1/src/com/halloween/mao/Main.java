package com.halloween.mao;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        LogFileProcessor httpParser = new LogFileProcessor();
        httpParser.process(args[0], args[1], args[2], args[3]);
    }
}




