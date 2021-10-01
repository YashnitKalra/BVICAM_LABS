<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Calculator"/>
</jsp:include>
<%@page errorPage="../error.jsp" %>
    <body>
        <%
            String num1 = request.getParameter("num1"), op = request.getParameter("op"), num2 = request.getParameter("num2");
            if(num1!=null && num2!=null && op!=null){
                double res = 0, n = Double.parseDouble(num1), m = Double.parseDouble(num2);
                switch(Integer.parseInt(op)){
                    case 0:
                        res = n+m; break;
                    case 1:
                        res = n-m; break;
                    case 2:
                        res = n*m; break;
                    case 3:
                        res = n/m; break;
                }
            
        %>
            <h2 class="m-5">Result = <%= res %></h2>
        <%
            }
            else{
        %>
        <form action="calculator.jsp" method="GET" class="mt-5 mx-auto bg-light text-center p-3">
            <h2>Calculator</h2>
            <div class="input-group">
                <input name="num1" type="text" placeholder="num1" class="form-control">
                <select name="op" class="form-control">
                    <option value="0">+</option>
                    <option value="1">-</option>
                    <option value="2">*</option>
                    <option value="3">/</option>
                </select>
                <input name="num2" type="text" placeholder="num2" class="form-control">
                <div class="input-group-append">
                    <input type="submit" value="Calculate" class="form-control btn btn-success">
                </div>
            </div>
        </form>
        <%
            }
        %>
    </body>
</html>
