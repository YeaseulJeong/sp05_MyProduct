<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{text-align: center;}
</style>
</head>
<body>
<h2 align="center">상품 정보를 출력합니다</h2>
<table border="2" algin="center" width="60%">
	<thead>
		<tr>
			<th>상품 번호</th> <th>상품 명</th> <th>제조사</th><th>상품 가격</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="vo">
			<tr>
				<th>${vo.id}</th>
				<th>${vo.name}</th>
				<th>${vo.maker}</th>
				<th>${vo.price}</th>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>