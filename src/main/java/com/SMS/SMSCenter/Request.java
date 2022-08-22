package com.SMS.SMSCenter;

public class Request {

    private String request;

    public Request( String request) {

        this.request = request;
    }

    @Override
    public String toString() {
        return "Request{" +
                "request='" + request + '\'' +
                '}';
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
