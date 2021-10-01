<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Login"/>
</jsp:include>
    <body>
        <%
            if(request.getParameter("logout")!=null && request.getParameter("logout").equals("true"))
                session.invalidate();
            else if(session.getAttribute("u")!=null)
                response.sendRedirect("profile.jsp");
        %>
        <form method="POST" action="profile.jsp" class="mx-auto text-center p-3 bg-light mt-5">
            <h2>Login</h2>
            <table class="table table-borderless">
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" class="form-control"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" class="form-control"></td>
            </tr>
            <% if(request.getParameter("u")!=null) { %>
                <tr><td></td><td class="text-left text-danger font-weight-bold">Invalid Email/Password</td></tr>
            <% } %>
            <tr>
                <td colspan="2"><input type="submit" value="Login" class="form-control btn btn-success"></td>
            </tr>
            <tr><td colspan="2"><a href="registrationForm.jsp">New User?</a>
            </table>
        </form>
    </body>
</html>
