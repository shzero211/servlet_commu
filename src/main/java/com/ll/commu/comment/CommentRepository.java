package com.ll.commu.comment;

import com.ll.commu.comment.dto.CommentDto;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommentRepository {
    private static List<CommentDto> comments;
   private static long idx;
    public CommentRepository(){
        comments=new ArrayList<>();
        idx=0;
        makeTestData();
    }
    public static void save(CommentDto commentDto) {
       comments.add(commentDto);
    }
    public List<CommentDto> findAll() {
       return comments;
    }
    public static void makeTestData(){
        for(int i=1;i<=10;i++){
            CommentDto commentDto=new CommentDto();
            commentDto.setId(i);
            commentDto.setArticleId(1);
            commentDto.setNickName("익명"+i);
            commentDto.setContent("댓글내용"+i);
            save(commentDto);
        }
    }

    public List<CommentDto> findByArticleId(long articleId) {
        List<CommentDto> commentDtos=new ArrayList<>();
        for(CommentDto commentDto:comments){
            if(commentDto.getArticleId()==articleId){
                commentDtos.add(commentDto);
            }
        }
        return commentDtos;
    }

    public long write(long articleId, String nickName, String content) {
        long size=0;

        for(CommentDto commentDto1:comments){
            if(articleId==commentDto1.getArticleId()){
                size++;
            }
        }
        size++;
        CommentDto commentDto=new CommentDto(size,articleId,nickName,content);
        comments.add(commentDto);
        return size;
    }
}
