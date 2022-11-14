<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="includes/taglib.jsp" %>
<html>
<head>
    <title>Create rooms</title>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<div class="menuArt">
    <div class='article'>
        <div class="border">
        <form:form cssClass="simpleForm" modelAttribute="createRoomsModel" method="post" action="/hotels/rooms/create">
            <form:hidden path="hotelId" value="${hotelId}"/><br>
            Amount of rooms: <form:input title="Amount of rooms" type="number" path="amountOfRooms"/><br>
            Prefix: <form:input path="prefix" title="prefix"/><br>
            Suffix: <form:input path="suffix" title="sufix"/><br>
            Numbering starts from: <form:input path="startIndex" type="number" title="Start numbering from"/><br>
            Delimiter: <form:input path="delimiter" title="Delimiter"/><br>
            <button>Create</button>
        </form:form>
    </div></div>
</div>
</body>
</html>
