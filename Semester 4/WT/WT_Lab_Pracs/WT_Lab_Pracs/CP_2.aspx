<%@ Page Language="C#" Inherits="WT_Lab_Pracs.CP_2" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>CP_2</title>
    <style>
        input{
            margin-bottom: 20px;
        }    
    </style>
</head>
<body>
	<form id="form1" runat="server">
        <asp:TextBox runat="server" id="name" placeholder="Name"></asp:TextBox>
        <asp:RequiredFieldValidator runat="server" ControlToValidate="name" ErrorMessage="Enter a Name"></asp:RequiredFieldValidator>
        <br>
        <asp:TextBox runat="server" id="city" placeholder="City"></asp:TextBox>
        <asp:RequiredFieldValidator runat="server" ControlToValidate="city" ErrorMessage="Enter a City"></asp:RequiredFieldValidator>
        <br>
        <asp:Button runat="server" Text="Submit"></asp:Button>
	</form>
</body>
</html>
