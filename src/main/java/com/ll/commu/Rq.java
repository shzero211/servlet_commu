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
    //검색이후 특정 인덱스의 값을 찾는 메서드(idx 1부터 넣을수있음)
    public long getIdxValue(int idx,long defaultValue){
        String[] str=req.getRequestURI().split("/");
        String value;
       try{
           value=str[3+idx];
       }catch (ArrayIndexOutOfBoundsException e){
           return defaultValue;
       }
        if(value==null){
            return defaultValue;
        }
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            return defaultValue;
        }
    }
//http method 얻기
    public String getMethod(){
       return req.getMethod();
    }

//path 에서 /기준으로 3문장 받기(0번째는 빈값)
    public String getPath(){
        String path=req.getRequestURI();
        String[] pathBits=path.split("/");
        return "/%s/%s/%s".formatted(pathBits[1],pathBits[2],pathBits[3]);
    }

    public <T>T getParam(String paramName,T defaultValue){
        String value=req.getParameter(paramName);
        if(value==null){
            return defaultValue;
        }
        try{
            return (T)value;
        }catch (Exception e){
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

    //req 에 값을 변수에 담기
    public void setAttr(String name,Object value){
        req.setAttribute(name,value);
    }

    //서블릿 이동(req.getRequestDispatcher 로 forward)
    public void view(String path){
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/jsp/"+path+".jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
