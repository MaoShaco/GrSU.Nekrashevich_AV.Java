package com.halloween.mao;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Mao on 3/2/2015.
 */
public class AccessLog {

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        String timestampPattern = "[dd/MMM/yyyy:HH:mm:ss Z]";
        this.timestamp = new SimpleDateFormat(timestampPattern, Locale.US)
                .parse(timestamp, new ParsePosition(timestamp.indexOf("[")));
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(int replyCode) {
        this.replyCode = replyCode;
    }

    public int getReplyBytes() {
        return replyBytes;
    }

    public void setReplyBytes(int replyBytes) {
        this.replyBytes = replyBytes;
    }

    public Host getLocalHost() {
        return localHost;
    }

    public void setLocalHost(String localHost) {
        this.localHost = new Host(localHost);
    }

    private Host localHost;
    private Date timestamp;
    private String request;
    private int replyCode;
    private int replyBytes;

    public String toString() {
        return String.format("\n__________________________\n Host: " + getLocalHost() + "\n TimeStamp: " + getTimestamp() + "\n Request: " + getRequest() + "\n ReplyCode: " + getReplyCode() + "\n Bytes: " + getReplyBytes());
    }

}
