<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <title>User for add</title>
</head>

<body>

<br>
<h2>User Info</h2>

<form:form action="saveUser" modelAttribute="user">

    <form:hidden path="id"/>
    Name <form:input path="name"/>
    <br>
    Surname <form:input path="surname"/>
    <br>
    e-mail <form:input path="email"/>
    <br>
    <input type="submit" value="OK">

</form:form>

</body>

</html>
