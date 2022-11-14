<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="includes/taglib.jsp" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/style.css" />
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/style/favicon.ico">
    <title>Login</title>
</head>
<body>
<div class="header">
    <img src="${pageContext.request.contextPath}/resources/style/img/logo.png" alt="">
    <a href="/hotels" class="rightSide"> Hotels</a>
    <a href="/register" class="rightSide">Sigh up</a>
</div>
<div class="menuArt">
    <div class='article'>
        <div class="border">
            <form:form action="/login" method="POST" cssClass="simpleForm"><br>
                <h1>Sign in</h1><br>
                <label for="email"></label>
                <input type="email" placeholder="Email" name="email" id="email"/><br>
                <label for="password"></label>
                <input type="password" placeholder="Password" name="password" id="password" pattern="{3,}"><br>
                <label class="simpleCheckBox">Remember me:
                <input type="checkbox" name="rememberMe">
                </label><br>
                <button value="login">Sign in</button>
                <c:if test="${param.fail}">
                    <p style="color:red;">Login or password is incorrect</p>
                </c:if>
                <br>
            </form:form>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>
