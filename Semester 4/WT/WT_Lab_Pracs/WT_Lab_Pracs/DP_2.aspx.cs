using System;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using Npgsql;

namespace WT_Lab_Pracs
{

    public partial class DP_2 : System.Web.UI.Page
    {
        private DB db;
        protected void Page_Load(object sender, EventArgs args)
        {
            db = new DB();
        }

        public void GetSubjects(object sender, EventArgs args)
        {
            if (Page.IsValid)
            {
                if (db.StudentExists(email.Text, password.Text))
                {
                    NpgsqlDataReader reader = db.GetSubjects(email.Text);
                    DataTable dt = new DataTable();
                    dt.Load(reader);
                    subjects.DataSource = dt;
                    subjects.DataBind();
                }
                else
                {
                    Response.Write("Student not Found / Wrong Password");
                }
            }
        }
    }
}
