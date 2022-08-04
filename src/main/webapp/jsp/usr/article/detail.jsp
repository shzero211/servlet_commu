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
<%@ include file="../common/footer.jspf"%>