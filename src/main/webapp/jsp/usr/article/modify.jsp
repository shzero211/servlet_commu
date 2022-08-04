<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="POST">
    <div>
        <span>번호</span>
        <div>
            ${article.id}
        </div>
    </div>

    <div>
        <span>제목</span>
        <div>
            <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요." value="${article.title}" />
        </div>
    </div>

    <div>
        <span>내용</span>
        <div>
            <input name="content" type="text" maxlength="300" placeholder="내용을 입력해주세요." value="${article.content}" />
        </div>
    </div>

    <div>
        <span>수정</span>
        <div>
            <input type="submit" value="수정" />
        </div>
    </div>
</form>