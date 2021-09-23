<%-- 
    Document   : index
    Created on : 15 Sep, 2021, 12:15:50 PM
    Author     : yashnit
--%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Index"/>
</jsp:include>
    <body>
        <div class="m-3">
            <h3>Programs:</h3>
            <%
                String[][] links = new String[][]{
                    {"CP1", "CP1/loginForm.jsp"},
                    {"CP2 (User registration, login, profile, logout)", "CP2/login.jsp"},
                    {"CP3 (Calculator)", "CP3/calculator.jsp"},
                    {"CP4 (Add and View Employees)", "CP4/addEmployeeForm.jsp"},
                    {"CP5 (Ticket Price)", "CP5/ticketPrice.jsp"},
                    {"DP1 (String Operations using JSTL)", "DP1/stringOperations.jsp"},
                    {"DP2 (Add and View Employees JSTL)", "DP2/addEmployee.jsp"},
                    {"DP3 (View, Insert, Delete, Update JSTL)", "DP3/crud.jsp"}
                };
            %>
            <ul>
                <%
                    for(String[] s: links)
                        out.println("<li><a href='" + s[1] + "'>" + s[0]  + "</a></li>");
                %>
            </ul>
        </div>
    </body>
</html>