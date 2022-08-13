import com.ll.commu.comment.CommentController;
import com.ll.commu.comment.CommentService;
import com.ll.commu.comment.dto.CommentDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.stream.events.Comment;
import java.util.List;

public class CommentTest {
    private CommentService commentService=new CommentService();
    @Test
    public void ServiceTest(){
        List<CommentDto>comments=commentService.findAll();
        Assertions.assertEquals( comments.get(0).getNickName(),"익명1");
    }
    @Test
    public void findByArticleId(){
        List<CommentDto> comments=commentService.findByArticleId(1);
        Assertions.assertEquals(10,comments.size());
    }
}
