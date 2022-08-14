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
    let last_id=-1;
    function Comments_load(){
            $.ajax({
                url : "/usr/comment/getList/${article.id}",
                dataType : "json",
                type : "GET",
                success : function(response) {

                            $.each(response.data, function(index,item) {
                            					if(item.id>last_id){
                            					$(".comment_list").append("<li><a>");
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
        <h1>댓글</h1>
        <ul class="comment_list">
        </ul>
    </div>
    <script>Comments_load();</script>
</section>


<%@ include file="../common/footer.jspf"%>