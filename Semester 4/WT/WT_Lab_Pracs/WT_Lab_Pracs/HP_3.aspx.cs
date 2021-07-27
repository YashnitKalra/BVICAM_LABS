using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs
{

    public partial class HP_3 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs args)
        {
            Response.Write("Cookies Available: " + Request.Cookies.Count);
            foreach(string s in Request.Cookies.AllKeys)
            {
                Response.Cookies[s].Expires = DateTime.Now.AddDays(-1);
                Response.Write("<br>" + "Cookie Deleted: " + s);
            }
        }
    }
}
