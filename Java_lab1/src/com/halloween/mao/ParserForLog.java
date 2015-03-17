package com.halloween.mao;

/**
 * Created by Mao on 3/7/2015.
 */
public class ParserForLog implements IParserForLog {

    @Override
    public AccessLog  getAccessLog(String str){
        AccessLog Buffer = new AccessLog();

        String[] buffer = str.split("\"");
        Buffer.setRequest(buffer[1]);
        String[] secondPart = buffer[0].split("- ");
        Buffer.setLocalHost(secondPart[0].trim());
        Buffer.setTimestamp(secondPart[2]);
        secondPart = buffer[2].split(" ");
        Buffer.setReplyCode(Integer.parseInt(secondPart[1]));
        Buffer.setReplyBytes(Integer.parseInt(secondPart[2]));

        return Buffer;
    }
}
