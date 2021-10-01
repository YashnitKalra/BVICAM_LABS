<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Login"/>
</jsp:include>
    <body class="m-5">
        <form action="login.jsp" method="POST" class="m-auto">
            <table class="table table-borderless bg-light text-center">
                <tr>
                    <th colspan="2"><h3>Login</h3></th>
                </tr>
                <tr>
                    <td>Email ID:</td>
                    <td><input class="form-control" type="text" name="email"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input class="form-control" type="password" name="password"></td>
                </tr>
                <tr>
                    <td></td><td class="text-danger text-left font-weight-bold">
                        <%
                            String user = request.getParameter("user");
                            if(user!=null && user.equals("f"))
                                out.println("Invalid Email/Password");
                        %>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input class="form-control btn btn-info" type="submit" value="Login"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
