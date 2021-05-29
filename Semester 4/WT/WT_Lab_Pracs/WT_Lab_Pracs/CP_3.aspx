<%@ Page Language="C#" Inherits="WT_Lab_Pracs.CP_3" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>CP_3</title>
    <style>
        input,select{
            margin-bottom: 10px;
        }    
    </style>
</head>
<body>
	<form id="form1" runat="server">
        <asp:Label runat="server">Username: </asp:Label>
        <asp:TextBox runat="server" id="username"></asp:TextBox>
        <asp:RequiredFieldValidator runat="server" ControlToValidate="username" ErrorMessage="Username Required"></asp:RequiredFieldValidator>
        <br>
        <asp:Label runat="server">Payment Mode: </asp:Label>
        <asp:DropDownList runat="server" id="payment_mode">
            <asp:ListItem Text="Credit Card"></asp:ListItem>
            <asp:ListItem Text="Debit Card"></asp:ListItem>
        </asp:DropDownList>
        <br>
        <asp:RequiredFieldValidator runat="server" ControlToValidate="payment_mode"></asp:RequiredFieldValidator>
        <asp:Label runat="server">Card Number: </asp:Label>
        <asp:TextBox id="card_number" runat="server"></asp:TextBox>
        <asp:RequiredFieldValidator runat="server" ControlToValidate="card_number" ErrorMessage="Card Number Required"></asp:RequiredFieldValidator>
        <asp:RegularExpressionValidator runat="server" ControlToValidate="card_number" ErrorMessage="Invalid Card Number" ValidationExpression="^\d{16}$"></asp:RegularExpressionValidator>
	    <br>
        <asp:Label runat="server">CVC: </asp:Label>
        <asp:TextBox id="cvc" TextMode="Password" runat="server"></asp:TextBox>
        <asp:RequiredFieldValidator ControlToValidate="cvc" runat="server" ErrorMessage="CVC Required"></asp:RequiredFieldValidator>
        <asp:RegularExpressionValidator runat="server" ControlToValidate="cvc" ErrorMessage="Invalid CVC" ValidationExpression="^\d{3}$"></asp:RegularExpressionValidator>
        <br>
        <asp:Button Text="Submit" runat="server"></asp:Button>
    </form>
</body>
</html>
