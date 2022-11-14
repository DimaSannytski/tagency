
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="includes/taglib.jsp" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/style.css" />
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/style/favicon.ico">
    <title>Register</title>
</head>
<body>
<div class="header">
    <img src="${pageContext.request.contextPath}/resources/style/img/logo.png" alt="">
    <a href="/hotels" class="rightSide"> Hotels</a>
    <a href="${pageContext.request.contextPath}/login" class="rightSide">Sigh in</a>
</div>
<div class="menuArt">
    <div class='article'>
        <div class="border">
<form:form action="/register" method="POST" modelAttribute="registerModel" cssClass="simpleForm"><br>
    <h1>Registration</h1><br>
    <form:input type="email"
                pattern="[a-zA-Z0-9_]+(?:\.[A-Za-z0-9!#$%&amp;'*+/=?^_`{|}~-]+)*@(?!([a-zA-Z0-9]*\.[a-zA-Z0-9]*\.[a-zA-Z0-9]*\.))(?:[A-Za-z0-9](?:[a-zA-Z0-9-]*[A-Za-z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?"
                placeholder="Email"  path="email" />
    <br><form:errors path="email" cssClass="error"/> <br>
    <form:input type="text" placeholder="First name" path="firstName" pattern="[A-Za-z]{2,}" />
    <br><form:errors path="firstName" cssClass="error"/> <br>
    <form:input type="text" placeholder="Last name"  path="lastName" pattern="[A-Za-z]{2,}" />
    <br><form:errors path="lastName" cssClass="error"/> <br>
    <form:input type="password" placeholder="Password" path="password"/>
    <br><form:errors path="password" cssClass="error"/><br>
    <form:input type="password" placeholder="Password confirmation" path="passwordConfirmation"/><br>
    <button id="register">Confirm</button>
</form:form>
        </div></div></div>
<%@include file="includes/footer.jsp" %>
</body>
</html>
