<%@page import="java.text.*"%>
<%@page import="java.sql.*"%>
<%
    String username = request.getParameter("username");
    String name = request.getParameter("name");
    String date = request.getParameter("joiningDate");
    String salary = request.getParameter("salary");
    String contact = request.getParameter("contact");
    try{
        String user = "postgres", dbPassword = "root", url = "jdbc:postgresql://localhost/wt";
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection conn = DriverManager.getConnection(url, user, dbPassword);
        PreparedStatement pst = conn.prepareCall("INSERT INTO employee VALUES(?, ?, ?, ?, ?);");
        pst.setString(1, username);
        pst.setString(2, name);
        pst.setDate(3, Date.valueOf(date));
        pst.setDouble(4, Double.parseDouble(salary));
        pst.setString(5, contact);
        pst.execute();
        pst.close();
        conn.close();
        response.sendRedirect("addEmployeeForm.jsp?res=t");
    }catch(Exception e){
        response.sendRedirect("addEmployeeForm.jsp?res=f");
    }
%>
