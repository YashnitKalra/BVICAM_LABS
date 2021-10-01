<%-- 
    Document   : addEmployeeForm
    Created on : 21 Sep, 2021, 9:52:31 PM
    Author     : yashnit
--%>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Add Employee"/>
</jsp:include>
    <body>
        <form action="addEmployee.jsp" method="POST" class="mt-5 mx-auto text-center">
            <table class="table table-striped bg-light">
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
                <% if(request.getParameter("res")!=null) { 
                    if(request.getParameter("res").equals("t")){
                %>
                <tr><td colspan="2" class="text-success font-weight-bold">Employee Added Successfully!! You will redirected in 3 seconds.</td></tr>
                <% response.setHeader("Refresh", "3; employees.jsp"); } else{ %>
                <tr><td colspan="2" class="text-danger font-weight-bold">Error</td></tr>
                <% }} %>
                <tr>
                    <td colspan="2"><input type="submit" value="Add Employee" class="form-control btn btn-success"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
