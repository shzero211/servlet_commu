<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1>작성폼</h1>
<form  method="post">
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