<%@ Page Language="C#" Inherits="WT_Lab_Pracs.HP_1" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>HP_1</title>
</head>
<body>
	<form id="form1" runat="server">
        <div>
            <asp:Button runat="server" OnClick="IncrementGoogle" Text="Google"></asp:Button>
            <asp:Button runat="server" OnClick="IncrementFacebook" Text="Facebook"></asp:Button>
            <div>Google Clicked: <label runat="server" id="googleCount">0</label></div>
            <div>Facebook Clicked: <label runat="server" id="facebookCount">0</label></div>
            <asp:AdRotator ID="AdRotator1" runat="server" AdvertisementFile="~/ad.xml" OnLoad="ADLoad" />
        </div>
	</form>
</body>
</html>
