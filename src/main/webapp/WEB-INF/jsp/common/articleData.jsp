<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<a href="${pageContext.request.contextPath}/article/details/${t.aid }" target="_blank">
	<c:out value="${t.title }"></c:out>
</a>
<div style="float: right;">
	<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
	
	<a href="${pageContext.request.contextPath}/user/info/${t.uid}" target="_blank">${t.author.username }</a>
	</div>
	<br />
</h4>
<c:if test="${!empty t.lable }">
	<span class="label label-success" onclick="send(this)" style="cursor:pointer">#${t.lable }#</span>
</c:if>
<p style="float: right;">
<fmt:formatDate value="${t.date }" pattern="MM/dd HH:mm:ss" />
</p>
<br>
<script>
	function send(obj) {
		var data = obj.innerHTML;
		var sub = data.substring(1,data.length-1);
		var u = "/MyForum/article/lable/" + sub;
		window.location.href=u;
	}
</script>