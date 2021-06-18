using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs
{

    public partial class Home : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs args)
        {
            Response.Write("Welcome " + Session["username"]);
        }
    }
}
