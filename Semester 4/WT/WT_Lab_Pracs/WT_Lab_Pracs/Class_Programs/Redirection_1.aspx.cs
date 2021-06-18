using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs.Class_Programs
{

    public partial class Redirection_1 : System.Web.UI.Page
    {
        public void ServerTransfer(object sender, EventArgs args)
        {
            Server.Transfer("Redirection_2.aspx");
        }

        public void ServerExecute(object sender, EventArgs args)
        {
            Server.Execute("Redirection_2.aspx");
        }
    }
}
