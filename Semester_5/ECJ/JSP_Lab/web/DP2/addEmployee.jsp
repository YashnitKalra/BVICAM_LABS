<%@page import="java.sql.Date"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Add Employee"/>
</jsp:include>
    <body>
        <form action="addEmployee.jsp" method="POST" class="mt-5 mx-auto text-center bg-light p-2">
            <table class="table table-striped bg-light">
                <h2>Add Employee</h2>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" class="form-control"></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" class="form-control"></td>
                </tr>
                <tr>
                    <td>Joining Date</td>
                    <td><input type="date" name="joiningDate" class="form-control"></td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td><input type="number" name="salary" class="form-control"></td>
                </tr>
                <tr>
                    <td>Contact</td>
                    <td><input type="number" name="contact" pattern="\d{10}" class="form-control"></td>
                </tr>
                
                <c:catch var="exception">
                    <c:if test="${param.username!=null}">
                        <sql:setDataSource var="db" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost/wt" user="postgres" password="root"/>
                        <sql:update dataSource="${db}" var="rows">
                            INSERT INTO employee VALUES(?, ?, ?, ?, ?);
                            <sql:param value="${param.username}"/>
                            <sql:param value="${param.name}"/>
                            <sql:dateParam value="<%= Date.valueOf(request.getParameter("joiningDate")) %>"/>
                            <sql:param value="${Double.parseDouble(param.salary)}"/>
                            <sql:param value="${param.contact}"/>
                        </sql:update>
                        <tr><td colspan="2" class="text-success font-weight-bold">Employee Added Successfully!! You will redirected in 3 seconds.</td></tr>
                        <% response.setHeader("Refresh", "3; employees.jsp"); %>
                    </c:if>
                </c:catch>
                
                <c:if test="${exception!=null}">
                    <tr><td colspan="2" class="text-danger font-weight-bold">Error</td></tr>
                </c:if>
                
                <tr>
                    <td colspan="2"><input type="submit" value="Add Employee" class="form-control btn btn-success"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
