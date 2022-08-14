package com.ll.commu.comment;

import lombok.Data;

@Data
public class JsonToMapResult<T> {
    private String resultCode;
    private String msg;
    private T data;
    public JsonToMapResult(String resultCode,String msg, T data){
        this.resultCode=resultCode;
        this.msg=msg;
        this.data=data;
    }
}
