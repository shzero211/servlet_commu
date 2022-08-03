package com.ll.commu.article;

import com.ll.commu.article.dto.ArticleDto;

public class ArticleService {
    private ArticleRepository articleRepository;
    public ArticleService(){
        articleRepository=new ArticleRepository();
    }
    public long write(String name,String content){
        return articleRepository.save(name,content);
    }
}
