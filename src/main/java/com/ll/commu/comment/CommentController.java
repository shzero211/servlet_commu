package com.ll.commu.comment;

import com.ll.commu.Rq;
import com.ll.commu.Ut.Ut;
import com.ll.commu.comment.dto.CommentDto;

import java.util.List;

public class CommentController {
    private  CommentService commentService;
    public CommentController(){
        this.commentService=new CommentService();
    }
    public void getAllComment(Rq rq) {
        long articleId=(long)rq.getIdxValue(1,0);
        List<CommentDto> commentDtos=null;
        if(articleId==0){
           commentDtos=commentService.findAll();
        }else{
            commentDtos=commentService.findByArticleId(articleId);
        }

        rq.json(new JsonToMapResult("결과코드","메세지",commentDtos));
    }

    public void write(Rq rq) {
        //  CommentDto newComment=Ut.str.toObj(rq.getParam("data",""), new TypeReference<CommentDto>(){}, null);
        String articleId=rq.getParam("articleId","");
        String nickName=rq.getParam("nickName","");
        String content=rq.getParam("content","");

        long comment_id=commentService.write(Integer.parseInt(articleId),nickName,content);

        rq.json(new JsonToMapResult("결과코드","메세지",comment_id));
    }
}
