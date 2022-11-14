<html>
<head>
    <title>Hotels</title>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<div class="menuArt">
    <div class='article'>
        <c:if test="${userDet.admin}">
            <a class="likeButton" href="/hotels/create">Create hotel</a>
            <a class="likeButton" href="/admin">Admin page</a>
        </c:if>
        <br><br>
        <c:forEach var="hotel" items="${hotels}">
            <div class="hotel">
                <a href="/hotels/${hotel.id}">
                    <h2>${hotel.name}</h2>
                    <h3>${hotel.address}</h3>
                    <h3>${hotel.countryName}</h3>
                    <h4></h4>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>
