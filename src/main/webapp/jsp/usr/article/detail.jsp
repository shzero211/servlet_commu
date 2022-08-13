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
    function Comments_load(){
        $.ajax({
            url : "/usr/comment/getList/1",
            dataType : "json",
            type : "GET",
            success : function(data){
               alert(data.data[0].nickName);
            }

        });
    }
</script>
<div class="comments">

</div>
<button onclick=" Comments_load();" class="btn btn-xs">최신글 가져오기</button>


<%@ include file="../common/footer.jspf"%>