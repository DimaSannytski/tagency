<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="includes/taglib.jsp" %>
<html>
<head>
    <title>Create hotel</title>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<div class="menuArt">
    <div class='article'>
    <div class="border">
        <form:form cssClass="simpleForm" action="/hotels/create" method="POST" modelAttribute="hotelModel" >
            <h1>Create hotel</h1><br>
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
            <br>
            <button>Create</button>
        </form:form>
    </div></div>
</div>
</body>
</html>
