<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Profile"/>
</jsp:include>
    <body class="text-center">
        <jsp:useBean id="u" class="Beans.User" scope="session">
            <jsp:setProperty name="u" property="email"/>
            <jsp:setProperty name="u" property="password"/>
        </jsp:useBean>
        <% if(u.validate()) { %>
            <table class="table table-striped text-center w-50 mx-auto mt-5">
                <tr><thead><th colspan="2"><h2>Profile</h2></th></thead></tr>
                <tr>
                    <th>Name:</th>
                    <td><jsp:getProperty name="u" property="name"/></td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td><jsp:getProperty name="u" property="email"/></td>
                </tr>
                <tr>
                    <th>Phone:</th>
                    <td><jsp:getProperty name="u" property="phone"/></td>
                </tr>
            </table>
                <a href="login.jsp?logout=true" class="btn btn-dark">Logout</a>
        <% }
            else{
                session.invalidate();
                response.sendRedirect("login.jsp?u=f");
            }
        %>
    </body>
</html>
