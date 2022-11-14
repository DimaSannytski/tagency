<html>
<head>
  <title>Persons</title>
</head>
<body>
<%@include file="/WEB-INF/views/includes/header.jsp" %>
<div class="menuArt">
  <div class='article'>
    <h1>Users</h1>
    <table>
      <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
      <c:forEach var="person" items="${persons}">
        <tr>
          <td>${person.firstName}</td>
          <td>${person.lastName}</td>
          <td>${person.email}</td>
          <td> <a class="likeButton" href="/person/edit/${person.id}">Edit</a></td>
          <td><form:form cssClass="simpleForm" action="/person/delete?id=${person.id}"
                         method="post" >
            <button>Delete</button>
          </form:form></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>

</body>
</html>
