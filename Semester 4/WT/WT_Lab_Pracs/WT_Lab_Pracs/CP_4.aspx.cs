using System;
using System.Web;
using System.Web.UI;

namespace WT_Lab_Pracs
{

    public partial class CP_4 : System.Web.UI.Page
    {
        public void Validate(object sender, EventArgs args)
        {
            Page.Validate();
            label.Text = Page.IsValid? "The page is valid!": "The page is not valid!";
        }
    }
}
