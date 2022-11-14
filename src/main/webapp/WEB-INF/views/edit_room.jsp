<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="includes/taglib.jsp" %>
<html>
<head>
    <title>Edit room</title>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<div class="menuArt">
    <div class='article'>
        <div class="border">
  <form:form cssClass="simpleForm" modelAttribute="roomModel" action="/room/edit" method="post">
      <form:input path="name" title="name"/>
      <form:hidden path="id"/>
      <form:hidden path="hotelId"/>
      <button>Update</button>
      <a class="likeButton" href="/room/${roomModel.id}">Cancel</a>
  </form:form>

    </div>
</div></div>
</body>
</html>
