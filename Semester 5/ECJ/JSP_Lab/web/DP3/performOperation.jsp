<%@page import="java.sql.Date"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<c:catch var="exception">
    <sql:setDataSource var="db" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost/wt" user="postgres" password="root"/>
    <c:choose>
        <c:when test="${param.op == 'Add'}">
            <sql:update dataSource="${db}" var="rows">
                INSERT INTO employee VALUES(?, ?, ?, ?, ?);
                <sql:param value="${param.username}"/>
                <sql:param value="${param.name}"/>
                <sql:dateParam value="<%= Date.valueOf(request.getParameter("joiningDate")) %>"/>
                <sql:param value="${Double.parseDouble(param.salary)}"/>
                <sql:param value="${param.contact}"/>
            </sql:update>
        </c:when>
                
        <c:when test="${param.op == 'Delete'}">
            <sql:update dataSource="${db}" var="rows">
                DELETE FROM employee WHERE username=?;
                <sql:param value="${param.username}"/>
            </sql:update>
        </c:when>
                
        <c:when test="${param.op == 'Save'}">
            <sql:update dataSource="${db}" var="rows">
                UPDATE employee SET username=?, name=?, joining_date=?, salary=?, contact=? WHERE username=?;
                <sql:param value="${param.newUsername}"/>
                <sql:param value="${param.name}"/>
                <sql:dateParam value="<%= Date.valueOf(request.getParameter("joiningDate")) %>"/>
                <sql:param value="${Double.parseDouble(param.salary)}"/>
                <sql:param value="${param.contact}"/>
                <sql:param value="${param.username}" />
            </sql:update>
        </c:when>
                
    </c:choose>
    <% response.sendRedirect("crud.jsp"); %>
</c:catch>

<c:if test="${exception!=null}">
    <h2>Error!! ${exception}</h2>
    <h3>You will be redirected in 3 seconds</h3>
    <% response.setHeader("Refresh", "300; crud.jsp"); %>
</c:if>