<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/head.jspf"%>
<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 상세페이지</h1>
         <div>
               <div>
                             ID : ${article.id}
                </div>
                <div>
                              title : ${article.title}
                </div>
                 <div>
                               content : ${article.content}
                 </div>
         </div>
    </div>
</section>

<script>
    function Comment_submit(){
        $.ajax({
            url : "/usr/comment/write",
            dataType : "json",
            type : "post",
            data : {
            "articleId" : $("#articleIdNew").val(),
            "nickName" : $("#nickNameNew").val(),
            "content" : $("#contentNew").val()
            },
            success : function (response){
                alert(response.data+"번 댓글 작성 완료!");
            }
        });
    }
</script>
<section>
<div class="container container px-3 mx-auto">
    <form  method="POST"  onSubmit = "Comment_submit(); return false">
        <div>
            <input class="invisible" type="text" id ="articleIdNew" name="articleIdNew" value="${article.id}"/>
        </div>
        <div>
            <input type="text" id="nickNameNew" name="nickNameNew"placeholder="닉네임" class="input input-bordered input-warning w-full max-w-xs" />
        </div>
        <div>
            <textarea class="textarea textarea-warning" id ="contentNew"  name="contentNew" placeholder="댓글달기"></textarea>
        </div>
            <button class="btn btn-primary">Button</button>
     </form>
</div>
</section>

<script>
    let last_id=-1;
    function Comments_load(){
            $.ajax({
                url : "/usr/comment/getList/${article.id}",
                dataType : "json",
                type : "GET",
                success : function(response) {

                            $.each(response.data, function(index,item) {
                            					if(item.id>last_id){
                            					$(".comment_list").append("<li class=\"mt-2\"><a>");
                                                $(".comment_list").append(item.nickName);
                                                $(".comment_list").append("</a></li>");
                                                $(".comment_list").append("<li><a>");
                                                $(".comment_list").append(item.content);
                                                $(".comment_list").append("</a></li>");
                                                last_id=item.id;
                            					}
                            				});

                        }
            });
            setTimeout(Comments_load, 3000);
        }
</script>
<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold">댓글</h1>
        <ul class="comment_list">
        </ul>
    </div>
    <script>Comments_load();</script>
</section>




<%@ include file="../common/footer.jspf"%>