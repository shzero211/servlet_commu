package com.ll.commu.comment;

import com.ll.commu.comment.dto.CommentDto;

import javax.xml.stream.events.Comment;
import java.util.List;

public class CommentService {
    private CommentRepository commentRepository;
    public CommentService(){
        this.commentRepository=new CommentRepository();
    }
    public List<CommentDto> findAll() {
        return commentRepository.findAll();
    }

    public List<CommentDto> findByArticleId(long articleId) {
        return commentRepository.findByArticleId(articleId);
    }

    public long write(long articleId, String nickName, String content) {
        return commentRepository.write(articleId,nickName,content);
    }
}
