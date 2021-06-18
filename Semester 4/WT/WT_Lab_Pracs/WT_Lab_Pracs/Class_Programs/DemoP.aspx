<%@ Page Language="C#" Inherits="WT_Lab_Pracs.DemoP" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>DemoP</title>
</head>
<body>
	<form id="form1" runat="server">
        <table>
            <tr>
                <td><asp:Label runat="server">Username:</asp:Label></td>
                <td><asp:TextBox runat="server" id="username"></asp:TextBox></td>
            </tr>
            <tr>
                <td><asp:Label runat="server">Password:</asp:Label></td>
                <td><asp:TextBox runat="server" id="password" TextMode="Password"></asp:TextBox></td>
                <td><asp:RequiredFieldValidator runat="server" ControlToValidate="password" Display="Dynamic" ErrorMessage="Cannot be empty"></asp:RequiredFieldValidator></td>
            </tr>
            <tr>
                <td colspan="2"><asp:Button runat="server" Text="Login" OnClick="Login"></asp:Button></td>    
            </tr>
        </table>
	</form>
</body>
</html>
