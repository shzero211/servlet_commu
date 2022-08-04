package com.ll.commu;

import com.ll.commu.article.ArticleController;
import com.ll.commu.article.ArticleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    private  ArticleController articleController=new ArticleController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Rq rq=new Rq(req,resp);
        switch (rq.getMethod()){
            case "GET":
                switch (rq.getPath()){
                    case "/usr/article/write":
                        articleController.showWriteForm(rq);
                        break;
                    case "/usr/article/list":
                        articleController.showList(rq);
                        break;
                    case "/usr/article/detail":
                        articleController.showDetail(rq);
                        break;
                    case "/usr/article/modify":
                        articleController.modifyForm(rq);
                        break;
                }
                break;
            case "POST":
                switch (rq.getPath()){
                    case "/usr/article/write":
                        articleController.write(rq);
                        break;
                    case "/usr/article/delete":
                        articleController.delete(rq);
                        break;
                    case "/usr/article/modify":
                        articleController.modify(rq);
                        break;
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}