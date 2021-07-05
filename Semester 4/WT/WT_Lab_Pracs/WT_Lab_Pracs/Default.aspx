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
          <ul class="navbar-nav me-auto" id="link-list-1"></ul>
        </div>
      </div>
    </nav>
    
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark overflow-auto">
      <div class="container-fluid">
        <a class="navbar-brand" href="~/" runat="server">Class Programs</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor03">
          <ul class="navbar-nav me-auto" id="link-list-2"></ul>
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
    document.getElementsByName("iframe")[0].style.height = screen.availHeight * 0.68 + "px";
    var pracs = {"BP":3, "CP":4, "DP":2, "EP":0, "FP":0, "GP":2, "HP":3, "IP":0, "JP":1};
    for(var assignment in pracs)
        if(pracs[assignment]===0)
            $("#link-list-1").append(`<\li class="nav-item"><a class="nav-link" href="~/${assignment}.aspx" runat="server" target="iframe">${assignment}</a><\/li>`);
        else
            for(var i = 1; i<=pracs[assignment]; i++)
                $("#link-list-1").append(`<\li class="nav-item"><a class="nav-link" href="~/${assignment}_${i}.aspx" runat="server" target="iframe">${assignment}${i}</a><\/li>`);
    
    var programs = {'DemoP':0, 'Redirection':1};
    for(var assignment in programs)
        if(programs[assignment]===0)
            $("#link-list-2").append(`<\li class="nav-item"><a class="nav-link" href="~/Class_Programs/${assignment}.aspx" runat="server" target="iframe">${assignment}</a><\/li>`);
        else
            for(var i = 1; i<=programs[assignment]; i++)
                $("#link-list-2").append(`<\li class="nav-item"><a class="nav-link" href="~/Class_Programs/${assignment}_${i}.aspx" runat="server" target="iframe">${assignment}${i}</a><\/li>`);
</script>