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
}
