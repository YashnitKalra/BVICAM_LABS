using System;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Collections;
using System.Collections.Generic;


namespace WT_Lab_Pracs
{
    public partial class FP : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs args)
        {
            if (!Page.IsPostBack)
            {
                ViewState["count"] = 0;
                ViewState["controls"] = new String[10];
            }
            else
            {
                CreateControls();
            }
        }

        public void CreateControls()
        {
            for(int i=0; i<(int)ViewState["count"]; i++)
            {
                string[] arr = ViewState["control_" + i].ToString().Split('_');
                switch (arr[0])
                {
                    case "button":
                        Button b = new Button() { Text = "Control " + (i+1) };
                        form1.Controls.Add(b);
                        break;
                    case "textbox":
                        TextBox t = new TextBox() { Text = "Control " + (i+1) };
                        form1.Controls.Add(t);
                        break;
                }
            }
        }

        private void AddControl(WebControl wc, string control)
        {
            try
            {
                int n = (int)ViewState["count"];
                if (n == 10) throw new IndexOutOfRangeException("Maximum 10 dynamic controls allowed!!");
                ViewState["count"] = n + 1;
                ViewState["control_" + n] = control + "_" + n;
                form1.Controls.Add(wc);
            }
            catch (Exception e)
            {
                Response.Write(e.Message);
            }
        }

        public void AddButton(object sender, EventArgs args)
        {
            AddControl(new Button() { Text = "Control " + ((int)ViewState["count"] + 1) }, "button");
        }

        public void AddTextBox(object sender, EventArgs args)
        {
            AddControl(new TextBox() { Text = "Control " + ((int)ViewState["count"] + 1) }, "textbox");
        }
    }
}
