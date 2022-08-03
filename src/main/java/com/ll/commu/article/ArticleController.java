package com.ll.commu.article;

import com.ll.commu.Rq;
import com.ll.commu.article.dto.ArticleDto;

public class ArticleController {
    private ArticleService articleService;
    public ArticleController(){
        articleService=new ArticleService();
    }

    //article 작성
    public void write(Rq rq){
        String name=rq.getStrParam("title","");
        String content=rq.getStrParam("content","");
        long id=articleService.write(name,content);
        rq.appendBody("""
                %d 번 정보 저장완료 %s ,%s!
                """.formatted(id,name,content));
    }

    public void showWrite(Rq rq) {
        rq.view("/usr/article/write");
    }
}
