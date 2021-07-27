using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs
{

    public partial class GP_1 : System.Web.UI.Page
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
                Response.Redirect("CookieRetreival.aspx");
            }
        }

        protected void btn_login_Click(object sender, EventArgs e)
        {
            HttpCookie userInfo = new HttpCookie("userInfo");
            userInfo["username"] = username.Text;
            userInfo["password"] = password.Text;
            //userInfo.Expires.Add(new TimeSpan(744,0,0));  //Add One month time in hours
            userInfo.Expires = DateTime.Now.AddMonths(12); //cookies will expires in a year
            Response.Cookies.Add(userInfo);
            Response.Redirect("CookieRetreival.aspx");
        }
    }
}
