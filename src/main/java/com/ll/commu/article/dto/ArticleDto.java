package com.ll.commu.article.dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//게시글
public class ArticleDto {
    private long id;
    private String title;
    private String content;

}
