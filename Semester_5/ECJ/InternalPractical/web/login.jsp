<%-- 
    Document   : login
    Created on : 28 Oct, 2021, 11:57:07 AM
    Author     : yashnit
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <html:form action="/login">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Enter your Email:</td>
                        <td><html:text property="email" /></td>
                    </tr>
                    <tr>
                        <td>Enter your Password:</td>
                        <td><html:password property="password" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><html:submit value="Login" style="cursor:pointer;"/></td>
                    </tr>
                </tbody>
            </table>
        </html:form>
    </body>
</html>
