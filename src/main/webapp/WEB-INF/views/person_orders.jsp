<html>
<head>
    <title>Orders</title>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<div class="menuArt">
    <div class='article'>
        <h1>My orders</h1>
        <table>
            <tr>
                <th>Room</th>
                <th>Hotel</th>
                <th>Start date</th>
                <th>End date</th>
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <fmt:formatDate value="${order.startDate}" var="startDate" pattern="dd/MM/yyyy"/>
                    <fmt:formatDate value="${order.endDate}" var="endDate" pattern="dd/MM/yyyy"/>
                    <td>${order.roomName}</td>
                    <td>${order.hotelName}</td>
                    <td>${startDate}</td>
                    <td>${endDate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>

