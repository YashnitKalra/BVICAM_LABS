<%-- 
    Document   : showNews
    Created on : 24 Oct, 2021, 9:24:16 PM
    Author     : yashnit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News</title>
    </head>
    <body style="background-color: #cbcbcb">
        <h1 style="text-align: center;">News</h1><hr>
        <sql:setDataSource var="db" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost/wt" user="postgres" password="root"/>
        <sql:query var="rs" dataSource="${db}">
               SELECT * FROM news;
        </sql:query>
        <c:forEach var="row" items="${rs.rows}">
            <div style="background-color: #2c2595; color: #ffffff; padding:20px; margin: auto; width: 30%; margin-bottom: 20px;">
                <h2><c:out value="${row.heading}"/></h2><hr>
                <p><c:out value="${row.content}"/></p>
            </div>
        </c:forEach>
        <% response.setHeader("Refresh", "120"); %>
    </body>
</html>
