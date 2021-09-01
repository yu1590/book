<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2021/8/23
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>

<%
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + application.getContextPath() + "/";

    request.setAttribute("path",path);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="<%=path%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
