<%@ Page Language="C#" Inherits="WT_Lab_Pracs.GP_1" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>GP_1</title>
</head>
<body>
	<form id="form1" runat="server">
        <asp:TextBox runat="server" id="name" placeholder="Enter Name"></asp:TextBox>
        <asp:Button OnClick="AddNameToCookie" Text="Submit" runat="server"></asp:Button>
	</form>
</body>
</html>
