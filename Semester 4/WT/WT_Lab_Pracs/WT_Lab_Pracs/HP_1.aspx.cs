using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs
{

    public partial class HP_1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!Page.IsPostBack)
            {
                ViewState["google"] = 0;
                ViewState["facebook"] = 0;
            }
        }

        protected void ADLoad(object sender, EventArgs e)
        {

        }

        public void IncrementGoogle(object sender, EventArgs args)
        {
            ViewState["google"] = (int)ViewState["google"] + 1;
            googleCount.InnerText = ViewState["google"].ToString();
            AdRotator1.KeywordFilter = ((int)ViewState["google"] >= (int)ViewState["facebook"]) ? "Google" : "Facebook";
        }

        public void IncrementFacebook(object sender, EventArgs args)
        {
            ViewState["facebook"] = (int)ViewState["facebook"] + 1;
            facebookCount.InnerText = ViewState["facebook"].ToString();
            AdRotator1.KeywordFilter = ((int)ViewState["google"] >= (int)ViewState["facebook"]) ? "Google" : "Facebook";
        }
    }
}
