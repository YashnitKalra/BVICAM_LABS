<%@ Page Language="C#" Inherits="WT_Lab_Pracs.CP_1" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>CP_1</title>
</head>
<body>
    <form runat="server">
        <asp:Label>Boiling Point of Water (&#176;C): </asp:Label>
    	<asp:TextBox id="temperature" runat="server"></asp:TextBox>
        <asp:Button runat="server" Text="Validate"></asp:Button>
        <asp:CompareValidator runat="server" id="temperatureCompare" ControlToValidate="temperature" ErrorMessage="Incorrect" Operator="Equal" Type="Integer" ValueToCompare=100></asp:CompareValidator>
    </form>
</body>
</html>
