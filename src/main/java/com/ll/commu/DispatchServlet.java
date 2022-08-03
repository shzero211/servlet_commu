package com.ll.commu;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Rq rq=new Rq(req,resp);
        switch (rq.getMethod()){
            case "GET":
                switch (rq.getPath()){
                    case "/usr/article/test":
                        resp.getWriter().append("test!!");
                        break;
                }
                break;
            case "POST":
                break;
        }
    }
}