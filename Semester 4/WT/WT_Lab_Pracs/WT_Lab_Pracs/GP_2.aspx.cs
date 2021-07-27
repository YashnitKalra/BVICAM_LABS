using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs
{

    public partial class GP_2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Session["useragent"] = Request.Headers["User-Agent"].ToString();
            Session["ip"] = Request.ServerVariables["REMOTE_ADDR"];
            Session["time_created"] = DateTime.Now;
        }

        protected void btnDetails_Click(object sender, EventArgs e)
        {
            foreach (string key in Session.Keys)
            {
                Response.Write(key + "-> " + Session[key].ToString() + "<br>");
            }
        }
    }
}
