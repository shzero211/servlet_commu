package com.ll.commu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;
    //req,resp 초기화및 설정 추가
    Rq(HttpServletRequest req,HttpServletResponse resp){
        this.req=req;
        this.resp=resp;
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
    }

    //int 값인 파라미터 찾아주는 기능(숫자변환 예외처리)
    public int getIntParam(String paramName,int defaultValue){
        String value=req.getParameter(paramName);
        if(value==null){
            return defaultValue;
        }
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            return defaultValue;
        }
    }

    //값을 resp 에 써서 보내줌
    public void appendBody(String str){
        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
