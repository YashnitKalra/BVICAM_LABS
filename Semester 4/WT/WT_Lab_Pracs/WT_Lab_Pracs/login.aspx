<%@ Page Language="C#" Inherits="WT_Lab_Pracs.login" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<form id="form1" runat="server" class="container-fluid w-25 border mt-5 bg-light" style="margin: 0 auto;">
        <h1 class="text-center mt-3">Login</h1><hr>
        <div class="row m-3">
            <asp:Label runat="server" CssClass="col-sm-3">Email: </asp:Label>
            <asp:TextBox runat="server" id="email" TextMode="Email" CssClass="col-sm-6"></asp:TextBox>
            <div class="col-sm-3">
                <asp:RequiredFieldValidator runat="server" ControlToValidate="email" Display="Dynamic" ErrorMessage="Required"></asp:RequiredFieldValidator>
                <asp:RegularExpressionValidator runat="server" ControlToValidate="email" ValidationExpression="^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$" Display = "Dynamic" ErrorMessage = "Invalid email address"/>
            </div>
        </div>
        <div class="row m-3">    
            <asp:Label runat="server" CssClass="col-sm-3">Password: </asp:Label>
            <asp:TextBox runat="server" id="password" TextMode="Password" CssClass="col-sm-6"></asp:TextBox>
            <div class="col-sm-3">
                <asp:RequiredFieldValidator runat="server" ControlToValidate="password" Display="Dynamic" ErrorMessage="Required"></asp:RequiredFieldValidator>
            </div>
        </div>
        <div class="row m-3">
            <asp:Button runat="server" CssClass="col-sm-12" Text="Login" OnClick="Login"></asp:Button>        
        </div>
        <div class="row my-3">
            <a href="/register.aspx" class="col-sm-12">Not registered? Click here</a>
        </div>
	</form>
</body>
</html>
