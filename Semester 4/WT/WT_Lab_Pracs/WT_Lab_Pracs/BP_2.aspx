<%@ Page Language="C#" Inherits="WT_Lab_Pracs.BP_2" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>BP_2</title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:Image id="image" runat="server" Height="200" ImageUrl="https://media-services.digital-rb.com/s3/live-productcatalogue/sys-master/images/h52/hd4/8867996598302/DettolOriginalSoap.jpg?width=1280&height=1280"/>   
        <br>
        <asp:Label runat="server">Store Items: </asp:Label>
        <asp:ListBox id="storeList" runat="server" SelectionMode="Single" OnSelectedIndexChanged="ChangeImage" Rows="1" AutoPostBack="true">
            <asp:ListItem Text="Soap"></asp:ListItem>
            <asp:ListItem Text="Toothpaste"></asp:ListItem>
            <asp:ListItem Text="Butter"></asp:ListItem>
            <asp:ListItem Text="Jam"></asp:ListItem>
        </asp:ListBox>
        <br>
        <asp:Button id="getPriceButton" Text="Get Price" runat="server" OnClick="GetPrice"></asp:Button>
        <br>
        <div>Price: Rs. <span runat="server" id="price">90</span></div>
    </form>
</body>
</html>
