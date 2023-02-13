<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All Users</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>e-mail</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="user" items="${allUsers}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteUser">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <tr>
            <td>${user.getName()}</td>
            <td>${user.getSurname()}</td>
            <td>${user.getEmail()}</td>
            <td>
                <input type="button" value="UPDATE"
                onClick = "window.location.href = '${updateButton}'"/>
                <input type="button" value="DELETE"
                       onClick = "window.location.href = '${deleteButton}'"/>
            </td>
        </tr>



    </c:forEach>


</table>

<br>
<input type="button" value="Add"
    onclick="window.location.href='addNewUser'"/>

</body>
</html>
