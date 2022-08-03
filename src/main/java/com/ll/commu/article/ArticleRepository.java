package com.ll.commu.article;

import com.ll.commu.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private List<ArticleDto> articles;
    int id;
    public ArticleRepository(){
        articles=new ArrayList<>();
        id=0;
    }
    public long save(String name,String content){
        ArticleDto articleDtoNew=new ArticleDto();
        articleDtoNew.setId(++id);
        articleDtoNew.setTitle(name);
        articleDtoNew.setContent(content);
        articles.add(articleDtoNew);
        return id;
    }
}
