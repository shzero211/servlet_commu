package com.ll.commu.article;

import com.ll.commu.article.dto.ArticleDto;

import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;
    public ArticleService(){
        articleRepository=new ArticleRepository();
    }
    public long write(String name,String content){
        return articleRepository.save(name,content);
    }

    public List<ArticleDto> findAll() {
        return articleRepository.findAll();
    }

    public ArticleDto findById(long detailId) {
        return articleRepository.findById(detailId);
    }

    public void delete(long findId) {
        articleRepository.delete(findId);
    }
}
