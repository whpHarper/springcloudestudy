package com.springcloude.common.message;

import java.io.Serializable;

public class ResponseOAJson implements Serializable {
    private int msgCode;
    private String msg;

    public ResponseOAJson(int msgCode,String msg){
        this.msgCode=msgCode;
        this.msg=msg;
    }
    public int getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
