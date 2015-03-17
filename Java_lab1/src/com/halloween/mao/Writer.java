package com.halloween.mao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Mao on 3/7/2015.
 */
public class Writer implements IWriter {
    @Override
    public void write(String fileName, String text) {

        File file = new File(fileName);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter;
            fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter out;
            out = new BufferedWriter(fileWriter);

            try {
                out.append(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
