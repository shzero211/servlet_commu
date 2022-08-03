<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<h1>작성폼</h1>
<form  method="post" onsubmit=" ArticleSave_submit(this); return false">
    <div>
        <span>제목</span>
        <div>
            <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요"/>
        </div>
    </div>
      <div>
            <span>내용</span>
            <div>
                <input name="content" type="text" maxlength="50" placeholder="내용을 입력해주세요"/>
            </div>
        </div>
          <div>
                <span>작성</span>
                <div>
                    <input type="submit" value="작성"/>
                </div>
            </div>
</form>