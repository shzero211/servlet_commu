import com.ll.commu.article.dto.ArticleDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void 테스트_assertThat(){
        int rs=10+20;
        assertEquals(rs,30);
    }
    @Test
    public void ArticleDto_를_json_타입으로변경(){
        ArticleDto articleDto=new ArticleDto(1,"title1","content1");
        String json=articleDto.toJson();
        assertEquals(json, "{\"id\":1,\"title\":\"title1\",\"content\":\"content1\"}");
    }

    @Test
    public void JSON_을_ArticleDto타입으로_변경(){
        ArticleDto articleDto=new ArticleDto(1,"title1","content1");

        ArticleDto articleDto2=articleDto.toObj(articleDto.toJson());
        assertEquals(articleDto.toString(),articleDto2.toString());
    }
}
