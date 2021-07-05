<%@ Page Language="C#" Inherits="WT_Lab_Pracs.EP" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>EP</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <asp:Table id="table_routine" ClientID="table" runat="server" CssClass="table text-center table-striped">
        <asp:TableHeaderRow>
            <asp:TableHeaderCell ColumnSpan="7"><h2>Patient Routine</h2></asp:TableHeaderCell>    
        </asp:TableHeaderRow>
        <asp:TableHeaderRow>
            <asp:TableHeaderCell>Patient ID</asp:TableHeaderCell>
            <asp:TableHeaderCell>Patient Name</asp:TableHeaderCell>
            <asp:TableHeaderCell>Patient's Disease</asp:TableHeaderCell>
            <asp:TableHeaderCell>Nurse Assigned</asp:TableHeaderCell>
            <asp:TableHeaderCell>Medicine Prescribed</asp:TableHeaderCell>
            <asp:TableHeaderCell>Medicine Time</asp:TableHeaderCell>
            <asp:TableHeaderCell>Time Left</asp:TableHeaderCell> 
        </asp:TableHeaderRow>    
    </asp:Table>
</body>
</html>
<script>
    var rows = $("tr").length - 2;
    var time_left = [];
    
    for(var i=1; i<=rows; i++){
        d = getDate(i);
        var minutes = Math.round((d-Date.now())/1000);
        time_left.push(minutes);
    }
    
    function getDate(i){
        var arr = $(`#time_${i}`).text().split(":");
        var d = new Date();
        d.setHours(parseInt(arr[0]));
        d.setMinutes(parseInt(arr[1]));
        d.setSeconds(parseInt(arr[2]));
        if(d-Date.now()<=0)
            d.setDate(d.getDate() + 1);
        return d;
    }
    
    function refreshTime(event){
        console.log(time_left);
        var n = parseInt(event.id.split("_")[1]);
        d = getDate(n+1);
        var minutes = Math.round((d-Date.now())/1000);
        time_left[n] = minutes;
        $(`#row_${n+1}`).removeClass("bg-warning");
        console.log(n+" "+minutes);
        console.log(time_left);
    }
    
    function format(n){
        var p = `${n}`;
        if(p.length==1)
            p = "0" + p;
        return p;
    }
    
    function update_time_left(){
        for(var i=0; i<rows; i++){
            if(time_left[i]==0){
                $(`#row_${i+1}`).addClass("bg-warning");
                $(`#time_left_${i+1}`).html(`<input type="checkbox" class="form-check-input" onchange="refreshTime(this)" id="consumed_${i}"> Consumed?`);
            }
            else if(time_left[i]>0){
                $(`#time_left_${i+1}`).text(`${format(parseInt(time_left[i]/(60*60)))} : ${format(parseInt(time_left[i]/60)%60)} : ${format(time_left[i]%60)}`);
            }
            time_left[i]-=1;
        }
    }
    update_time_left();
    setInterval(update_time_left, 1000);
</script>
