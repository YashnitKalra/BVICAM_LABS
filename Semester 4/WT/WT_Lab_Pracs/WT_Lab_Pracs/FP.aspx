<%@ Page Language="C#" Inherits="WT_Lab_Pracs.FP" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>FP</title>
    <style>
        input, button{
            display: block;
            margin-top: 10px;
        }    
    </style>
</head>
<body>
	<form id="form1" runat="server">
        <asp:Button runat="server" OnClick="AddButton" Text="Add Button"></asp:Button>
        <asp:Button runat="server" OnClick="AddTextBox" Text="Add Text Box"></asp:Button>
        <hr>
    </form>
</body>
</html>