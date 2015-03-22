package com.halloween.mao;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mao on 3/2/2015.
 */
public class AccessLog {

    final String timestampPattern = "[dd/MMM/yyyy:HH:mm:ss Z]";

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = new SimpleDateFormat(timestampPattern).parse(timestamp, new ParsePosition(timestamp.indexOf("[")));
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
        String dataBuff = new SimpleDateFormat(timestampPattern).format(getTimestamp());
        return String.format("__________________________\n Host: " + getLocalHost() + "\n TimeStamp: " + dataBuff + "\n Request: " + getRequest() + "\n ReplyCode: " + getReplyCode() + "\n Bytes: " + getReplyBytes());
    }

}
