<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=0.3">
<title>搜索结果</title>
<%@include file="../common/import.jsp"%>
</head>
<body>
	<div class="container" style="height:90%;box-shadow: 0px 0px 1px #666;">
		<%@include file="../common/head.jsp"%><br>
		<h3>搜索标签:<span style="color:red">${lab }</span>---共${fn:length(resultList) }篇帖子！</h3>
		<table class="table table-hover">
			<c:forEach var="s" items="${resultList }">
			  <tr>
			  	<td>
				  	<span class="glyphicon glyphicon-tag" aria-hidden="true"></span>
				  	<a href="${pageContext.request.contextPath}/article/details/${s.aid }" target="_blank">
				  	<c:out value="${s.title }"></c:out>
				  	</a>
				  	<div style="float: right;">
				  		 / <fmt:formatDate value="${s.date }" pattern="yyyy/MM/dd HH:mm:ss" />
				  	</div>
				</td>
			  </tr>
			</c:forEach>
		</table>
		
	</div><%@include file="../common/foot.jsp"%>
</body>
</html>
