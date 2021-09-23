<jsp:include page="../header.jsp">
    <jsp:param name="title" value="String Operations"/>
</jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <body>
        <c:choose>
            <c:when test="${param.string!=null}">
                <pre>
                    <c:set var="string" value="${param.string}"/>
                    <table class="table bg-light text-center w-50 mx-auto mt-5">
                        <thead><tr><th>Operation</th><th>Result</th></tr></thead>
                        <tr>
                            <td>Uppercase</td>
                            <td><c:out value="${fn:toUpperCase(string)}"/></td>
                        </tr>
                        <tr>
                            <td>Index of "Server"</td>
                            <td><c:out value="${fn:indexOf(string, 'Server')}"/></td>
                        </tr>
                        <tr>
                            <td>Length of String</td>
                            <td><c:out value="${fn:length(string)}"/></td>
                        </tr>
                        <tr>
                            <td>Removal of Extra spaces</td>
                            <td><c:out value="${fn:trim(string)}"/></td>
                        </tr>
                        <tr>
                            <td>Existence of word "SERVER"</td>
                            <td><c:out value="${fn:contains(string, 'SERVER')}" /></td>
                        </tr>
                        <tr>
                            <td>Replace "Pages" with "Project"</td>
                            <td><c:out value="${fn:replace(string, 'Pages', 'Project')}" /></td>
                        </tr>
                    </table>
                </pre>
            </c:when>
            <c:otherwise>
                <form action="stringOperations.jsp" method="GET" class="mt-5 mx-auto bg-light text-center p-3" accept-charset="utf-8">
                    <label>Enter String:</label>
                    <input type="text" name="string" class="form-control" value=" Java Server    Pages    ">
                    <input type="submit" value="Submit" class="btn btn-success mt-2">
                </form>
            </c:otherwise>
        </c:choose>
    </body>
</html>
