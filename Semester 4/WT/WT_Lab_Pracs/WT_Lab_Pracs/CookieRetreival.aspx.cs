using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs
{

    public partial class CookieRetreival : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            HttpCookie userInfo = Request.Cookies["userInfo"];
            if (userInfo == null)
            {
                //do nothing
            }
            else
            {
                if (!string.IsNullOrEmpty(userInfo.Values["username"]))
                {
                    Response.Write("Username: " + userInfo["username"].ToString());
                    Response.Write("<br>Password: " + userInfo["password"].ToString());
                }
            }
        }
    }
}
