<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Banking Operations</title>
        <style>
            form{
                padding: 20px;
                background-color: skyblue;
                text-align: center;
                border: 2px solid black;
                width: 60%;
                margin: auto;
            }
            input,div{
                margin-top: 20px;
            }
        </style>
        <html:base/>
    </head>
    <body style="background-color:#e4e4e4">
        <html:form action="/performOperation">
            <h2 style="color: red;">Banking Operations</h2>
            <html:radio property="operation" value="deposit">Deposit</html:radio>
            <html:radio property="operation" value="withdraw">Withdraw</html:radio>
            <html:radio property="operation" value="balance">Balance</html:radio><br>
            <html:text property="money"/><br>
            <div><bean:write property="msg" name="Account" filter="false"/></div>
            <html:submit value="Submit"/>
            <html:reset value="Reset"/>
        </html:form>
        
        
    </body>
</html:html>

