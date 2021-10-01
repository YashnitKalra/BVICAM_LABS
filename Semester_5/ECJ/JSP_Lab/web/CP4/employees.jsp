<%-- 
    Document   : employees
    Created on : 21 Sep, 2021, 11:13:31 PM
    Author     : yashnit
--%>

<%@page import="java.sql.*"%>
<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Employees"/>
</jsp:include>
    <body>
        <table class="table table-striped bg-light text-center">
            <thead>
                <tr><th colspan="5"><h2>Employees</h2></th></tr>
                <tr><th>Username</th><th>Name</th><th>Date</th><th>Salary</th><th>Contact Number</th></tr>
            </thead>
        <%
            try{
                String user = "postgres", dbPassword = "root", url = "jdbc:postgresql://localhost/wt";
                DriverManager.registerDriver(new org.postgresql.Driver());
                Connection conn = DriverManager.getConnection(url, user, dbPassword);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM employee;");
                while(rs.next()){
                    %>
            <tr>
                <td><% out.print(rs.getString(1)); %></td>
                <td><% out.print(rs.getString(2)); %></td>
                <td><% out.print(rs.getDate(3).toString()); %></td>
                <td><% out.print(rs.getDouble(4)); %></td>
                <td><% out.print(rs.getString(5)); %></td>
            </tr>
            <%
                }
                conn.close();
            }catch(Exception e){}
        %>
        </table>
    </body>
</html>
