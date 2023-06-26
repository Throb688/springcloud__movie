package com.example.hzscommon.uitl;

import java.util.HashMap;
import java.util.Map;

public class Msg {

    private int code;
    private String msg;
    private Map<String, Object> data;

    public Msg() {
        // 默认构造函数
        this.data = new HashMap<>();
    }

    private Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = new HashMap<>();
    }

    public static Msg success() {
        return new Msg(200, "Success");
    }

    public static Msg success(String msg) {
        return new Msg(200, msg);
    }

    public static Msg fail() {
        return new Msg(500, "Failure");
    }

    public static Msg fail(String msg) {
        return new Msg(500, msg);
    }

    public Msg addData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Map<String, Object> getData() {
        return data;
    }
}