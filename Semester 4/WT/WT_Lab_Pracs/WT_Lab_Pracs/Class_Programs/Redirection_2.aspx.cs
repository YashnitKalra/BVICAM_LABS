using System;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WT_Lab_Pracs.Class_Programs
{

    public partial class Redirection_2 : System.Web.UI.Page
    {
        protected void Page_Load()
        {
            // null with Response.Redirect()
            Page prevPage = Page.PreviousPage;
            if(prevPage != null)
            {
                Response.Write( ((TextBox)prevPage.FindControl("name")).Text );
            }

        }

        public void GoBack(object sender, EventArgs args)
        {
            Response.Redirect("Redirection_1.aspx");
        }
    }
}
