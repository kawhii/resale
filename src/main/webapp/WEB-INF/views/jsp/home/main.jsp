<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/19
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="<c:choose><c:when test="${pageContext.request.requestURL.indexOf('jsp/index.jsp') >= 0}">main-banner</c:when></c:choose> banner text-center">
    <div class="container">
        <h1>出售或转让 <span class="segment-heading">    任何在线 </span> 广告</h1>

        <p>嘟嘟网是一个方便快捷的广告式电商平台</p>
        <a href="post-ad.html">免费发布广告</a>
    </div>
</div>