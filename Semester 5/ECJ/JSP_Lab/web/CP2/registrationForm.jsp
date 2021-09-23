<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Registration"/>
</jsp:include>
    <body>
        <form method="POST" action="register.jsp" class="mx-auto">
            <table class="mt-5 table table-striped text-center bg-light">
                <thead>
                    <tr>
                        <th colspan="2">Registration Form</th>
                    </tr>
                </thead>
                <tr>
                    <td>Name</td>
                    <td><input type="text" class="form-control" name="name"></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" class="form-control" name="email"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" class="form-control" name="password"></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" class="form-control" name="phone"></td>
                </tr>
                <% if(request.getParameter("invalid")!=null) { %>
                <tr>
                    <td colspan="2" class="text-danger font-weight-bold">Email / Phone already exists</td>
                </tr>
                <% } %>
                <tr>
                    <td colspan="2"><input type="submit" value="Register" class="form-control btn btn-success"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
