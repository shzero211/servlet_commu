package com.ll.commu.article;

import com.ll.commu.Rq;
import com.ll.commu.article.dto.ArticleDto;

import java.util.List;

public class ArticleController {
    private ArticleService articleService;
    public ArticleController(){
        articleService=new ArticleService();
    }

    //article 작성(post요청)
    public void write(Rq rq){
        String name=rq.getParam("title","");
        String content=rq.getParam("content","");
        long id=articleService.write(name,content);
        rq.appendBody("<script>alert(\"해당글을 추가했습니다.\")</script>");
        rq.appendBody("<script>location.replace(\"/usr/article/list\")</script>");
    }

    //작성 페이지로 이동
    public void showWriteForm(Rq rq) {
        rq.view("/usr/article/write");
    }

    //articleDto의 모든 정보를 reqeust의 attribute에 담아서 직접 보내기(json X)
    public void showList(Rq rq){
        List<ArticleDto> articles=articleService.findAll();
        rq.setAttr("articles",articles);
        rq.view("/usr/article/list");
    }

//상세정보를 변수로 넘기고 jsp로 이동
    public void showDetail(Rq rq) {
        long detailId=rq.getIdxValue(1,0);
        if(detailId==0){
            rq.appendBody("<script>alert(\"상세페이지 번호를 입력해주세요\");</script>");
            rq.appendBody("<script>history.back()</script>");
            return;
        }
        ArticleDto articleDto=articleService.findById(detailId);
        if(articleDto==null){
            rq.appendBody("<script>alert(\"해당 글은 존재하지 않습니다.\");</script>");
            rq.appendBody("<script>history.back()</script>");
            return;
        }
        rq.setAttr("article",articleDto);
        rq.view("/usr/article/detail");
    }

    public void delete(Rq rq) {
        long findId=rq.getIdxValue(1,0);
        if(findId==0){
            rq.appendBody("<script>alert(\"번호를 입력해주세요\");</script>");
            rq.appendBody("<script>history.back();</script>");
            return;
        }
        ArticleDto articleDto=articleService.findById(findId);
        if(articleDto==null){
            rq.appendBody("<script>alert(\"해당글이 존재 하지 않습니다.\");</script>");
            rq.appendBody("<script>history.back()</script>");
            return;
        }
        articleService.delete(findId);
        rq.appendBody("<script>alert(\"해당글을 삭제하였습니다!\")</script>");
        rq.appendBody("<script>location.replace(\"/usr/article/list\")</script>");
    }

    public void modifyForm(Rq rq) {
        long id=rq.getIdxValue(1,0);
        if(id==0){
            rq.appendBody("<script>alert(\"번호를 입력해주세요\");</script>");
            rq.appendBody("<script>history.back();</script>");
            return;
        }
        ArticleDto articleDto=articleService.findById(id);
        if(articleDto==null){
            rq.appendBody("<script>alert(\"해당글이 존재 하지 않습니다.\");</script>");
            rq.appendBody("<script>history.back()</script>");
            return;
        }
        rq.setAttr("article",articleDto);
        rq.view("/usr/article/modify");
    }

    public void modify(Rq rq) {
        long id =rq.getIdxValue(1,0);
        String title=rq.getParam("title","");
        String content=rq.getParam("content","");
        articleService.modify(id,title,content);
        rq.appendBody("<script>alert(\"수정 완료\");</script>");
        rq.appendBody("<script>location.replace(\"/usr/article/list\")</script>");
    }
}
