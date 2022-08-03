package com.ll.commu.article;

import com.ll.commu.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
    private static List<ArticleDto> articles;
    static int id;
    static {
        articles=new ArrayList<>();
        id=0;
        makeTestData();
    }
    //articles 에 save
    public static long save(String name,String content){
        ArticleDto articleDtoNew=new ArticleDto();
        articleDtoNew.setId(++id);
        articleDtoNew.setTitle(name);
        articleDtoNew.setContent(content);
        articles.add(articleDtoNew);
        return id;
    }

    public List<ArticleDto> findAll() {
        return articles;
    }

    public ArticleDto findById(long detailId) {
        for(ArticleDto articleDto:articles){
            if(articleDto.getId()==detailId){
                return articleDto;
            }
        }
        return null;
    }
    public static  void makeTestData(){
        IntStream.rangeClosed(1,10).forEach(id->{
            String title="제목%d".formatted(id);
            String content="내용%d".formatted(id);
            save(title,content);

        });
    }
//삭제를 객체를 찾아서 지워줌
    public void delete(long findId) {
        ArticleDto articleDto=findById(findId);
        if(articleDto==null) return ;
        articles.remove(articleDto);
    }
}
