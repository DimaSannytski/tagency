<html>
<head>
  <title>Person</title>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<div class="menuArt">
  <div class='article'>
    <h1>${personModel.firstName} ${personModel.lastName}</h1>
    <h2>${personModel.email}</h2>
    <br>
    <br>

    <form:form action="/logout" method="POST" cssClass="simpleForm">
      <a class="likeButton" href="/person/edit/${personModel.id}">Edit</a>
      <button>Logout</button>
    </form:form>
    <br>
    <br>
    <h2>Orders</h2>
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

