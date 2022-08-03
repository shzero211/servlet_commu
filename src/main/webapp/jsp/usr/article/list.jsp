<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul>
<c:forEach items="${articles}" var="article">
       <li>${article.id}</li>
       <li>${article.title}</li>
       <li>${article.content}</li>
</c:forEach>
</ul>