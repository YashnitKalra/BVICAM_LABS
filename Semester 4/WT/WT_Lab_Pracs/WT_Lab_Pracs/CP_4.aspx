<%@ Page Language="C#" Inherits="WT_Lab_Pracs.CP_4" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>CP_4</title>
    <style>
        input{
            margin-bottom: 10px;
            display: block;
        }     
    </style>
</head>
<body>
	<form id="form1" runat="server">
        <asp:TextBox id="zipcode" runat="server" placeholder="Zip Code"></asp:TextBox>
        <asp:RegularExpressionValidator ControlToValidate="zipcode" ErrorMessage="The zip code must be 5 numeric digits!" runat="server" ValidationExpression="\d{5}"></asp:RegularExpressionValidator>
        <asp:Button runat="server" Text="Submit" OnClick="Validate"></asp:Button>
        <asp:Label id="label" runat="server"></asp:Label>
	</form>
</body>
</html>
