<%@ Page Language="C#" Inherits="WT_Lab_Pracs.GP_1" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>GP_1</title>
</head>
<body>
	<form id="form1" runat="server">
        <div>
            <asp:Table ID="Table1" runat="server">
                <asp:TableHeaderRow runat="server">
                    <asp:TableHeaderCell ColumnSpan="2" runat="server">Login Details</asp:TableHeaderCell>
                </asp:TableHeaderRow>
                <asp:TableRow runat="server">
                    <asp:TableCell runat="server">Username:</asp:TableCell>
                    <asp:TableCell runat="server">
                        <asp:TextBox ID="username" runat="server"></asp:TextBox>
                    </asp:TableCell>
                </asp:TableRow>
                <asp:TableRow runat="server">
                    <asp:TableCell runat="server">Password:</asp:TableCell>
                    <asp:TableCell runat="server">
                        <asp:TextBox ID="password" runat="server"></asp:TextBox>
                    </asp:TableCell>
                </asp:TableRow>
                <asp:TableFooterRow runat="server">
                    <asp:TableCell runat="server">
                        <asp:Button ID="btn_login" runat="server" Text="Login" OnClick="btn_login_Click" />
                    </asp:TableCell>
                </asp:TableFooterRow>
            </asp:Table>
        </div>
	</form>
</body>
</html>
