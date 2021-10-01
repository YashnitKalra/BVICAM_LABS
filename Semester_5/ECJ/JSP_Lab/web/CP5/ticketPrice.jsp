<%
    String name = request.getParameter("name");
    String age = request.getParameter(("age"));
    if(name!=null && age!=null){
        int a = Integer.parseInt(age);
        response.setContentType("text/plain");
        if(a<0)
            out.print(String.format("{\"err\": \"Age is negative: %d\"}", a));
        else{
            int price = a>62?100:(a<10?50:75);
            out.print(String.format("{\"msg\": \"%s your ticket price is Rs. %d\"}", name, price));
        }
    }
    else{
%>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Movie Ticket Price"/>
</jsp:include>
    <body>
        <table class="mx-auto bg-light w-50 text-center mt-5 table">
            <thead><tr><th colspan="2"><h3>Movie Ticket Price</h3></th></tr></thead>
            <tr>
                <td>Name:</td>
                <td><input type="text" id="name" class="form-control"></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><input type="number" id="age" class="form-control"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="button" class="btn btn-success" id="btn">Get Movie Price</button>
                    <div id="msg" class="font-weight-bold"></div>
                </td>
            </tr>
        </table>
    </body>
</html>
<script>
    $("#btn").click(() => {
        let name = $("#name").val();
        let age = $("#age").val();
        $.ajax({
            url: "ticketPrice.jsp",
            type: "GET",
            data: {name: name, age: age},
            success: (res) => {
                let result = JSON.parse(res);
                if(result['msg'])
                    $("#msg").html('<span class="text-success">'+result['msg']+'</span>');
                else
                    $("#msg").html('<span class="text-danger">'+result['err']+'</span>')
            }
        });
    });
</script>
<% } %>
