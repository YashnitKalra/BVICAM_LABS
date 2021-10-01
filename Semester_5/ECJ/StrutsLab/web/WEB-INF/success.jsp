<%-- 
    Document   : success
    Created on : 30 Sep, 2021, 6:18:49 PM
    Author     : yashnit
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
    </head>
    <body>
        <h1>Login Success!</h1>

        <h2>Welcome User (<bean:write name="LoginForm" property="email" />)</h2>

    </body>
</html>
