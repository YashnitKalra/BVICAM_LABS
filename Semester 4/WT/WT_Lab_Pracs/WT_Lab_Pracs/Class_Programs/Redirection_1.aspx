<%@ Page Language="C#" Inherits="WT_Lab_Pracs.Class_Programs.Redirection_1" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>Redirection_1</title>
</head>
<body>
	<form id="form1" runat="server">
        <asp:TextBox runat="server" id="name"></asp:TextBox>
        <asp:Button id="serverTransferBtn" runat="server" Text="Server Transfer" OnClick="ServerTransfer"></asp:Button>
        <asp:Button id="serverExecuteBtn" runat="server" Text="Server Execute" OnClick="ServerExecute"></asp:Button>
	</form>
</body>
</html>
