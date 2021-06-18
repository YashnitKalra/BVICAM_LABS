<%@ Page Language="C#" Inherits="WT_Lab_Pracs.DP_2" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>DP_2</title>
    <style>
        table{
            text-align: right;
        }
        input,select{
            margin: 5px 3px;
        }
    </style>
</head>
<body>
	<form id="form1" runat="server" method="post">
        <table>
            <tr>
                <td><asp:Label runat="server">Email:</asp:Label></td>
                <td><asp:TextBox runat="server" id="email" TextMode="Email"></asp:TextBox></td>
                <td><asp:RequiredFieldValidator runat="server" ControlToValidate="email" Display="Dynamic" ErrorMessage="Cannot be empty"></asp:RequiredFieldValidator></td>
            </tr>
            <tr>
                <td><asp:Label runat="server">Password:</asp:Label></td>
                <td><asp:TextBox runat="server" id="password" TextMode="Password"></asp:TextBox></td>
                <td><asp:RequiredFieldValidator runat="server" ControlToValidate="password" Display="Dynamic" ErrorMessage="Cannot be empty"></asp:RequiredFieldValidator></td>
            </tr>
            <tr>
                <td colspan="2"><asp:Button runat="server" Text="Get Subjects" OnClick="GetSubjects"></asp:Button></td>    
            </tr>
        </table>
	</form>
    <asp:GridView runat="server" id="subjects"></asp:GridView>
</body>
</html>
