<%@ Page Language="C#" Inherits="WT_Lab_Pracs.DP_1" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>DP_1</title>
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
    <h2>Student Registration Form</h2>
	<form id="form1" runat="server">
        <table>
            <tr>
                <td><asp:Label runat="server">Name:</asp:Label></td>
                <td><asp:TextBox runat="server" id="student_name"></asp:TextBox></td>
                <td><asp:RequiredFieldValidator runat="server" ControlToValidate="student_name" Display="Dynamic" ErrorMessage="Cannot be empty"></asp:RequiredFieldValidator></td>
            </tr>
            <tr>
                <td><asp:Label runat="server">Father's Name:</asp:Label></td>
                <td><asp:TextBox runat="server" id="father_name"></asp:TextBox></td>
                <td><asp:RequiredFieldValidator runat="server" ControlToValidate="father_name" Display="Dynamic" ErrorMessage="Cannot be empty"></asp:RequiredFieldValidator></td>
            </tr>
            <tr>
                <td><asp:Label runat="server">Mobile:</asp:Label></td>
                <td><asp:TextBox runat="server" id="mobile" TextMode="Phone"></asp:TextBox></td>
                <td><asp:RequiredFieldValidator runat="server" ControlToValidate="mobile" Display="Dynamic" ErrorMessage="Cannot be empty"></asp:RequiredFieldValidator></td>
            </tr>
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
                <td><asp:Label runat="server">Confirm Password:</asp:Label></td>
                <td><asp:TextBox runat="server" id="confirm_password" TextMode="Password"></asp:TextBox></td>
                <td>
                    <asp:RequiredFieldValidator runat="server" ControlToValidate="confirm_password" Display="Dynamic" ErrorMessage="Cannot be empty"></asp:RequiredFieldValidator>
                    <asp:CompareValidator runat="server" ControlToValidate="confirm_password" ControlToCompare="password" ErrorMessage="Password does not match" Display="Dynamic"></asp:CompareValidator>
                </td>
            </tr>
            <tr>
                <td><asp:Label runat="server">Course:</asp:Label></td>
                <td><asp:DropDownList runat="server" id="course" Width="100%"></asp:DropDownList></td>
            </tr>
            <tr>
                <td colspan="2"><asp:Button OnClick="RegisterStudent" runat="server" Text="Submit"></asp:Button></td>
            </tr>
        </table>
	</form>
</body>
</html>
