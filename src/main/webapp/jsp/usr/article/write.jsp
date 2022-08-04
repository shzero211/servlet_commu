<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/head.jspf"%>
<script>
function ArticleSave_submit(form){
    form.title.value=form.title.value.trim();
    if(form.title.value.length==0){
        alert('제목을 입력해주세요.');
        form.title.focus();
        return ;
    }

    form.content.value=form.content.value.trim();
        if(form.content.value.length==0){
            alert('내용을 입력해주세요.');
            form.content.focus();
            return ;
        }
        form.submit();
}
</script>
<section>
    <!-- container(max-width) : 너비가 너무 넓게 퍼지는 것을 막는다 + 반응형은 잃지 않는다. -->
    <!-- mx-auto : margin-left:auto; margin-right:auto; -->
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 작성</h1>
        <form method="POST" onsubmit="ArticleSave_submit(this); return false;" >
            <div>
                <span>제목</span>
                <div>
                    <input class="border-[2px]" name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요." />
                </div>
            </div>

            <div>
                <span>내용</span>
                <div>
                    <input class="border-[2px]"  name="content" type="text" maxlength="300" placeholder="내용을 입력해주세요." />
                </div>
            </div>

            <div>
                <div>
                    <button class="btn btn-primary btn-sm">작성</button>
                </div>
            </div>
        </form>
    </div>
</section>
<%@ include file="../common/footer.jspf"%>