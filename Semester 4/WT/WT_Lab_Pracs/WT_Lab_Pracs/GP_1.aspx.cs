using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs
{

    public partial class GP_1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs args)
        {
            HttpCookie cookie = Request.Cookies["nameCookie"];
            if (cookie != null)
            {
                Response.Write("Name From Cookie: " + cookie["name"]);
            }
        }

        public void AddNameToCookie(object sender, EventArgs args)
        {
            HttpCookie cookie = new HttpCookie("nameCookie");
            cookie["name"] = name.Text;
            Response.Cookies.Add(cookie);
        }

    }
}
