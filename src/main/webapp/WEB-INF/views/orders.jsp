<html>
<head>
    <title>Orders</title>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<div class="menuArt">
    <div class='article'>
        <h1>Orders</h1>
        <table>
            <tr>
                <th>Created by</th>
                <th>Room</th>
                <th>Hotel</th>
                <th>Start date</th>
                <th>End date</th>
                <c:if test="${userDet.admin}">
                    <th>Delete</th>
                </c:if>
            </tr>
            <c:forEach var="order" items="${orders}">
                <fmt:formatDate value="${order.startDate}" var="startDate" pattern="dd/MM/yyyy"/>
                <fmt:formatDate value="${order.endDate}" var="endDate" pattern="dd/MM/yyyy"/>
                <td>${order.creatorName}</td>
                <td>${order.roomName}</td>
                <td>${order.hotelName}</td>
                <td>${startDate}</td>
                <td>${endDate}</td>
                <c:if test="${userDet.admin}">
                    <td><form:form cssClass="simpleForm" action="/order/delete?id=${order.id}"
                                   method="post">
                        <button>Delete</button>
                    </form:form>
                    </td>
                </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
