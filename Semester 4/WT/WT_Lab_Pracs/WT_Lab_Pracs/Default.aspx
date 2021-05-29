<%@ Page Language="C#" Inherits="WT_Lab_Pracs.Default" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>WT Lab</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark overflow-auto">
      <div class="container-fluid">
        <a class="navbar-brand" href="~/" runat="server">Web Technologies Lab</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor02">
          <ul class="navbar-nav me-auto" id="link-list"></ul>
        </div>
      </div>
    </nav>
    <div class="text-center">   
        <iframe name="iframe" class="m-5 p-3"></iframe>
	</div>
</body>
</html>
<script>
    document.getElementsByName("iframe")[0].style.width = "75%";
    document.getElementsByName("iframe")[0].style.height = screen.availHeight * 0.75 + "px";
    var pracs = {'B':3, 'C':4, 'D':2, 'E':2, 'F':2, 'G':2, 'H':3, 'I':1, 'J':1};
    for(var assignment in pracs)
        for(var i = 1; i<=pracs[assignment]; i++)
            $("#link-list").append(`<\li class="nav-item"><a class="nav-link" href="~/${assignment}P_${i}.aspx" runat="server" target="iframe">${assignment}P${i}</a><\/li>`);
</script>