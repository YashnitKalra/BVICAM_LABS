<%@ Page Language="C#" Inherits="Assignment_B.BP_3" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>BP_3</title>
    <style>
        #button{
            background-color: Gray; 
        }
        #button:hover{
            background-color: Yellow;
        }    
    </style>
</head>
<body>
	<form id="form1" runat="server">
        <asp:Button runat="server" Text="Click Me" OnClick="TurnRed" id="button"></asp:Button>
	</form>
</body>
</html>
