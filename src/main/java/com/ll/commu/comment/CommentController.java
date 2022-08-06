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
        long articleId=rq.getIdxValue(1,0);
        List<CommentDto> commentDtos=null;
        if(articleId==0){
           commentDtos=commentService.findAll();
        }else{
            commentDtos=commentService.findByArticleId(articleId);
        }

        rq.json(commentDtos);
    }
}
