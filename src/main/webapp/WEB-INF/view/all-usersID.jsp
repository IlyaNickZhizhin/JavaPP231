<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All Users</h2>
<br>

<table>
    <tr>
        <th>id</th>

    </tr>

    <c:forEach var="user" items="${allUsers}">

        <tr>
            <td>${user.getId()}</td>

        </tr>

    </c:forEach>


</table>

</body>
</html>
