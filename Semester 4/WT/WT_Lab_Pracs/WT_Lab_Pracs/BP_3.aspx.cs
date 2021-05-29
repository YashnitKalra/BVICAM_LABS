using System;
using System.Web;
using System.Web.UI;
using System.Drawing;

namespace WT_Lab_Pracs
{

    public partial class BP_3 : System.Web.UI.Page
    {
        public void TurnRed(object sender, EventArgs args)
        {
            button.BackColor = System.Drawing.Color.Red;
        }
    }
}
