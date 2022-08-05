package com.ll.commu.article.dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleDto {
    private long id;
    private String title;
    private String content;

    public String toJson() {
    ObjectMapper om=new ObjectMapper();
        try {
            return om.writeValueAsString(this);
        } catch (JsonProcessingException e) {
           return "";
        }
    }
    public ArticleDto toObj(String json){
        ObjectMapper om=new ObjectMapper();
        try {
            return om.readValue(json,ArticleDto.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
