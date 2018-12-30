<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
    <div align="center">
    <h1>User List</h1>
    <h3>
        <a href="addUser">New User</a>
    </h3>
        <table border="1">
            <th>Login</th>
            <th>Password</th>
            <th>Name</th>
            <th>Age</th>
            <th>Role</th>
            <th>Action</th>
            <c:forEach items="${listUsers}" var="user">
                <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.role}</td>
            <td>
                <a href="editUser?id=${user.id}">Edit</a>
                <a href="deleteUser?id=${user.id}">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
    </div>
</body>
</html>
