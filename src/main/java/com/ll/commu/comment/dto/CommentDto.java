package com.ll.commu.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//댓글
public class CommentDto {
    private long id;
    //article 게시물과 연결을 위한 요소
    private long articleId;
    //유저의 nickname
    private String nickName;
    //글
    private String content;
    public CommentDto(long articleId,String nickName,String content){
        this.articleId=articleId;
        this.nickName=nickName;
        this.content=content;
    }
}
