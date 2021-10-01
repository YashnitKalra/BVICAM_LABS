<jsp:useBean id="u2" class="Beans.User">
    <jsp:setProperty name="u2" property="email"/>
    <jsp:setProperty name="u2" property="name"/>
    <jsp:setProperty name="u2" property="password"/>
    <jsp:setProperty name="u2" property="phone"/>
</jsp:useBean>
<%
    if(u2.emailOrPhoneExists())
        response.sendRedirect("registrationForm.jsp?invalid=t");
    else{
        u2.save();
%>
<jsp:useBean id="u" class="Beans.User" scope="session">
    <jsp:setProperty name="u" property="email"/>
    <jsp:setProperty name="u" property="password"/>
</jsp:useBean>
<%
        response.sendRedirect("login.jsp");
    }
%>
