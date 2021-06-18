using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs
{

    public partial class DemoP : System.Web.UI.Page
    {
        DB db;
        protected void Page_Load(object sender, EventArgs args)
        {
            db = new DB();
        }
        public void Login(object sender, EventArgs args)
        {
            if(db.UserExists(username.Text, password.Text))
            {
                Session["username"] = username.Text;
                Response.Redirect("~/Class_Programs/Home.aspx");
            }
            else
            {
                Response.Write("User does not exist / Invalid Passowrd");
            }
        }
    }
}
