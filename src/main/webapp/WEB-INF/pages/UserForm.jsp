<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit User</title>
</head>
<body>
<div align="center">
    <h1>New/Edit User</h1>
    <form:form action="saveUser" method="post" modelAttribute="user">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Login:</td>
                <td><form:input type ="text" path="login" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input type ="password" path="password" /></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:input type ="text" path="name" /></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input type ="number" path="age" /></td>
            </tr>
            <td>Role</td>
            <td>
                <p><select size="1" name="role">
                    <option value="user">User</option>
                    <option value="admin">Admin</option>
                </select></p>
            </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
            </form>
        </table>
    </form:form>
</div>
</body>
</html>
