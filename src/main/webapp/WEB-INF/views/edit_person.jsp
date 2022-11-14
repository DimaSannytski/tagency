<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="includes/taglib.jsp" %>
<html>
<head>
  <title>Edit person</title>
  <%@include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<div class="menuArt">
  <div class='article'>
    <div class="border">
      <form:form cssClass="simpleForm" modelAttribute="personModel" action="/person/edit" method="post">
        <form:input path="firstName" placeHolder="First name"/><br>
        <form:input path="lastName" placeHolder="Last name"/><br>
        <form:input path="email" placeHolder="Email"/><br>
        <form:hidden path="id"/>
        <button>Save</button>
        <a class="likeButton" href="/person/${personModel.id}">Cancel</a>
      </form:form>

    </div>
  </div></div>
</body>
</html>