<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Crud Operations"/>
</jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <body>
        <table class="table text-center table-light table-striped w-75 mt-5 mx-auto border">
                <tr>
                    <th colspan="8"><h2>Employees</h2></th>
                </tr>
                <tr>
                    <th class="align-middle">Username</th>
                    <th class="align-middle">Name</th>
                    <th class="align-middle">Joining Date</th>
                    <th class="align-middle">Salary</th>
                    <th class="align-middle">Contact</th>
                    <th colspan="3" class="align-middle">
                        <button class="btn btn-outline-success btn-sm form-control" data-toggle="modal" data-target="#addModal">Add Employee</button>
                    </th>
                </tr>
            </thead>
            <sql:setDataSource var="db" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost/wt" user="postgres" password="root"/>
            <sql:query var="rs" dataSource="${db}">
                SELECT * FROM employee;
            </sql:query>
                
            <c:set var="i" value="0"/>
            
            <c:forEach var="row" items="${rs.rows}">
                <tr>
                    <form action="performOperation.jsp" method="POST">
                        <td><input type="text" value="<c:out value="${row.username}"/>" name="newUsername" class="form-control" disabled></td>
                        <td><input type="text" value="<c:out value="${row.name}"/>" name="name" class="form-control" disabled></td>
                        <td><input type="date" value="<c:out value="${row.joining_date}"/>" name="joiningDate" class="form-control" disabled></td>
                        <td><input type="text" value="<c:out value="${row.salary}"/>" name="salary" class="form-control" disabled></td>
                        <td><input type="text" value="<c:out value="${row.contact}"/>" name="contact" class="form-control" disabled></td>
                        <input type="text" value="<c:out value="${row.username}"/>" name="username" class="d-none" disabled>
                        <td><input type="submit" name="op" value="Save" class="btn btn-outline-dark btn-sm" disabled></td>
                    </form>
                        <td>
                            <button class="btn btn-outline-info btn-sm editButton" id="${i}">Edit</button>
                            <c:set var="i" value="${Integer.parseInt(i)+2}"/>
                        </td>
                    <td>
                        <form action="performOperation.jsp" method="POST">
                            <input type="hidden" name="username" value="${row.username}">
                            <input type="submit" value="Delete" name="op" class="btn btn-outline-danger btn-sm">
                        </form> 
                    </td>
                </tr>
            </c:forEach>
        </table>
            
        
        <!-- Add Modal -->
        <div class="modal fade" id="addModal">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header table-secondary">
                        <h4 class="modal-title">Add Employee</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <form class="w-100" method="POST" action="performOperation.jsp">
                        <!-- Modal body -->
                        <div class="modal-body text-center">
                            <div class="container-fluid">
                                <div class="row my-2">
                                    <div class="col-sm-4 my-auto">Username:</div>
                                    <div class="col-sm-8"><input type="text" name="username" class="form-control"></div>
                                </div>
                                <div class="row my-2">
                                    <div class="col-sm-4 my-auto">Name:</div>
                                    <div class="col-sm-8"><input type="text" name="name" class="form-control"></div>
                                </div>
                                <div class="row my-2">
                                    <div class="col-sm-4 my-auto">Joining Date:</div>
                                    <div class="col-sm-8"><input type="date" name="joiningDate" class="form-control"></div>
                                </div>
                                <div class="row my-2">
                                    <div class="col-sm-4 my-auto">Salary:</div>
                                    <div class="col-sm-8"><input type="text" name="salary" class="form-control"></div>
                                </div>
                                <div class="row my-2">
                                    <div class="col-sm-4 my-auto">Contact:</div>
                                    <div class="col-sm-8"><input type="text" name="contact" class="form-control"></div>
                                </div>
                            </div>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer table-secondary">
                            <input type="submit" name="op" value="Add" class="btn btn-success">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
    </body>
</html>
<script>
    $(".editButton").click( function(){
        let index = parseInt($(this).attr('id'));
        for(let i=0; i<=6; i++){
            document.forms[index][i].disabled ^= true;
        }
    });
</script>