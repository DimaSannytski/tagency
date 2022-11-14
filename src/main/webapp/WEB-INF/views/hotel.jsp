<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="includes/taglib.jsp" %>
<html>
<head>
    <title>Hotel</title>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<div class="menuArt">
    <div class='article'>
        <h1>${hotelModel.name}</h1>
        <h2>${hotelModel.address}</h2>
        <h2>${hotelModel.countryName}</h2>
        <h3>${hotelModel.description}</h3>
        <br>
        <c:if test="${userDet.admin}">
        <a class="likeButton" href="../hotels/${hotelModel.id}/edit">Edit</a>
        <a class="likeButton" href="../hotels/${hotelModel.id}/rooms/create">Create rooms</a>
        <a class="likeButton" href="../hotels/${hotelModel.id}/create_room">Create one room</a>
        </c:if>
        <br> <br>
        <c:forEach var="room" items="${hotelModel.rooms}">
            <span class="room"><a href="/room/${room.id}">${room.name}</a></span>
        </c:forEach>
    </div>
</div>
</body>
</html>
