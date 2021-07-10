using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs
{

    public partial class login : System.Web.UI.Page
    {
        private DB db;

        protected void PageLoad(object sender, EventArgs args)
        {
            db = new DB();
        }

        public void Login(object sender, EventArgs args)
        {

        if (Page.IsValid)
        {
                db = new DB();
            if (db.UserExists(email.Text, password.Text))
                Response.Redirect("/welcome.aspx");
        }
    }
    }
}
