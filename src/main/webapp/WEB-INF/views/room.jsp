<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="includes/taglib.jsp" %>
<html>
<head>
    <title>Room</title>
    <%@include file="/WEB-INF/views/includes/header.jsp" %>

</head>
<body>
<div class="menuArt">
    <div class='article'>
                <a href="/hotels/${roomModel.hotelId}">Back to hotel</a><br><br>
                <h1>${roomModel.name}</h1>
                <br>
            <c:if test="${userDet.admin}">
                <form:form cssClass="simpleForm"
                           action="/hotels/rooms/delete?id=${roomModel.id}&hotelId=${roomModel.hotelId}"
                           method="post">
                    <button>Delete</button>
                    <a class="likeButton" href="/room/${roomModel.id}/edit">Edit</a>
                </form:form>
            </c:if>
            <br>
            <c:if test="${userDet.user or userDet.admin}">
                <form:form cssClass="simpleForm" action="/order/create"
                           method="post" modelAttribute="orderModel">
                    <form:input path="startDate" placeholder="start date"/>
                    <br><form:errors path="startDate" cssClass="error"/> <br>
                    <form:input path="endDate" placeholder="end date"/>
                    <br><form:errors path="endDate" cssClass="error"/> <br>
                    <form:hidden path="roomId"/>
                    <form:hidden path="personId"/>
                    <button>Reserve</button>
                </form:form>
            </c:if>
        <br>
        <c:forEach items="${reservedDates}" var="date">
            <span class="room">
            ${date.startDateStr} - ${date.endDateStr}
        </span>
        </c:forEach>
    </div>
</div>
</body>
</html>
