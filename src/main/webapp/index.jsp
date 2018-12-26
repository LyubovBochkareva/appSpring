<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <title>Здравствуйте</title>
  </head>
  <body>
  <h3> WELCOME!</h3>
  <br/>
  <a href="<c:url value="/users"/>" target="_self">Список пользователей</a>
  <br/>
  </body>
</html>
