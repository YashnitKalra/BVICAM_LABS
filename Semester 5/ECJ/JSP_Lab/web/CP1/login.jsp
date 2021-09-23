<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Welcome"/>
</jsp:include>
    <body class="m-5">
        <!-- Properties are automatically set if received data has same name as property -->
        <jsp:useBean id="u" class="Beans.User">
            <jsp:setProperty name="u" property="email" />       
            <jsp:setProperty name="u" property="password" />
        </jsp:useBean>
        <% if(u.validate()) { %>
            <h2>Welcome, <jsp:getProperty name="u" property="email"/></h2>
        <% }
            else {
                response.sendRedirect("loginForm.jsp?user=f");
            } 
        %>
    </body>
</html>
