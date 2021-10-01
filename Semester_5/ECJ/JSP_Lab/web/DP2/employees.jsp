<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Employees"/>
</jsp:include>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
    <body>
        <table class="table table-striped bg-light text-center w-75 mt-5 mx-auto">
            <thead>
                <tr><th colspan="5"><h2>Employees</h2></th></tr>
                <tr><th>Username</th><th>Name</th><th>Date</th><th>Salary</th><th>Contact Number</th></tr>
            </thead>
            <sql:setDataSource var="db" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost/wt" user="postgres" password="root"/>
            <sql:query var="rs" dataSource="${db}">
                SELECT * FROM employee;
            </sql:query>
            <c:forEach var="row" items="${rs.rows}">
                <tr>
                    <td><c:out value="${row.username}"/></td>
                    <td><c:out value="${row.name}"/></td>
                    <td><c:out value="${row.joining_date}"/></td>
                    <td><c:out value="${row.salary}"/></td>
                    <td><c:out value="${row.contact}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
