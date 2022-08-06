import com.fasterxml.jackson.core.type.TypeReference;
import com.ll.commu.Ut.Ut;
import com.ll.commu.article.dto.ArticleDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UtTest {
    @Test
    public void ObjtoJson(){
        ArticleDto articleDto=new ArticleDto(1,"title","content");
        String json=Ut.str.toJson(articleDto,"");
        assertEquals("{\"id\":1,\"title\":\"title\",\"content\":\"content\"}",json);
    }
    @Test
    public void ListtoJson(){
        List<ArticleDto> articles=new ArrayList<>();
        articles.add(new ArticleDto(1,"title1","content1"));
        articles.add(new ArticleDto(2,"title2","content2"));
        String json=Ut.str.toJson(articles,"");
        assertEquals("[{\"id\":1,\"title\":\"title1\",\"content\":\"content1\"},{\"id\":2,\"title\":\"title2\",\"content\":\"content2\"}]",json);
    }
    @Test
    public void MaptoJson(){
        Map<String ,ArticleDto> map=new HashMap<>();
       map.put("m1",new ArticleDto(1,"title1","content1"));
        map.put("m2",new ArticleDto(2,"title2","content2"));
        String json=Ut.str.toJson(map,"");
        assertEquals("{\"m1\":{\"id\":1,\"title\":\"title1\",\"content\":\"content1\"},\"m2\":{\"id\":2,\"title\":\"title2\",\"content\":\"content2\"}}",json);
    }
    @Test
    public void jsonToList(){
        List<ArticleDto> articles=new ArrayList<>();
        articles.add(new ArticleDto(1,"title1","content1"));
        articles.add(new ArticleDto(2,"title2","content2"));

        String json=Ut.str.toJson(articles,"");
        List<ArticleDto> articlesjsontoObj = Ut.str.toObj(json, new TypeReference<List<ArticleDto>>(){}, null);

        assertEquals(articles.get(0).getId(),articlesjsontoObj.get(0).getId());
        assertEquals(articles.get(0).getTitle(),articlesjsontoObj.get(0).getTitle());
        assertEquals(articles.get(0).getContent(),articlesjsontoObj.get(0).getContent());
    }
    @Test
    public void jsontoMap(){
        Map<String ,ArticleDto> map=new HashMap<>();
        map.put("m1",new ArticleDto(1,"title1","content1"));
        map.put("m2",new ArticleDto(2,"title2","content2"));
        String json=Ut.str.toJson(map,"");
        Map<String,ArticleDto> mapjsonToObj=Ut.str.toObj(json, new TypeReference<Map<String,ArticleDto>>() {},null);
        assertEquals(mapjsonToObj.get("m1").getContent(),map.get("m1").getContent());
    }
}
