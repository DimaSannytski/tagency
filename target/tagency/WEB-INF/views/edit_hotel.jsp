<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="includes/taglib.jsp" %>
<html>
<head>
    <title>Edit hotel</title>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<div class="menuArt">
    <div class='article'>
        <div class="border">
        <form:form cssClass="simpleForm" modelAttribute="hotelModel" action="/hotels/edit" method="POST">
            <h1>Edit hotel</h1><br>
            <form:input path="name" type="text" placeholder="Name"/><form:errors path="name"/>
            <br>
            <form:textarea path="address" placeholder="Address"/><form:errors path="address"/>
            <br>
            <form:textarea path="description" placeholder="Description"/>
            <br>
            <form:select path="countryId" name="country">
                <c:forEach items="${countries}" var="country">
                    <option value="${country.id}">${country.name}</option>
                </c:forEach>
            </form:select>
            <form:hidden path="id"/>
            <br>
            <button>Save</button>
            <a href="/hotels/${hotelModel.id}" class="likeButton"> Cancel</a>
        </form:form>
        </div></div>
</div>
</body>
</html>
