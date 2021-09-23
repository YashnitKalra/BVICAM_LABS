<%@page contentType="text/html" isErrorPage="true"%>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Error"/>
</jsp:include>
    <body>
        <div class="m-5 text-danger">
            <h2>Error</h2>
            <h3><%= exception.getMessage() %></h3>
        </div>
    </body>
</html>
