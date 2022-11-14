<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="includes/taglib.jsp" %>
<html>
<head>
    <title>Create room</title>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<div class="menuArt">
    <div class='article'>
        <div class="border">
    <form:form cssClass="simpleForm" action="/room/create" modelAttribute="roomModel" method="post">
        <form:hidden path="hotelId" value="${hotelId}"/>
        <form:input path="name" title="Name" placeholder="Name"/>
        <br>
        <button>Create</button>
    </form:form>
    </div></div>
</div>
</body>
</html>
