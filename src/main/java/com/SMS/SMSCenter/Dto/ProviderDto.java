package com.SMS.SMSCenter.Dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class ProviderDto {


    private String userName;
    private String password;
    private Map<String,String> stringObjectMap;
    private String request;





    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, String> getStringObjectMap() {
        return stringObjectMap;
    }

    public void setStringObjectMap(Map<String, String> stringObjectMap) {
        this.stringObjectMap = stringObjectMap;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "ProviderDto{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", stringObjectMap=" + stringObjectMap +
                '}';
    }
}
