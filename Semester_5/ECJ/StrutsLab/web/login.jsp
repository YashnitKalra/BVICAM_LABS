<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            table{
                background-color: skyblue;
                text-align: center;
                padding: 5px;
                margin: auto;
                margin-top: 50px;
                border: 2px solid darkblue;
                border-radius: 20px;
            }
            td{
                padding:5px 20px;
            }
            input{
                width: 100%;
                padding: 5px;
            }
        </style>
        <html:base/>
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
                        <td colspan="2">
                            <bean:write name="LoginForm" property="error" filter="false"/>&nbsp;
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><html:submit value="Login" style="cursor:pointer;"/></td>
                    </tr>
                </tbody>
            </table>
        </html:form>

    </body>
</html:html>
