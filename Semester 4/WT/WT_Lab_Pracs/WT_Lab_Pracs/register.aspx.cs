using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs
{

    public partial class register : System.Web.UI.Page
    {
        private DB db;

        protected void PageLoad(object sender, EventArgs args)
        {
            db = new DB();
        }

        public void Register(object sender, EventArgs args)
        {
            if(db==null)
            db = new DB();
            if (Page.IsValid)
            {
                try
                {
                    db.AddUser(name.Text, password.Text, email.Text, contact_number.Text);
                    Response.Write("Registration Succesful");
                }
                catch(Exception e)
                {
                    Response.Write(e.Message);
                }
            }
        }
    }
}
