using System;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WT_Lab_Pracs
{

    public partial class DP_1 : System.Web.UI.Page
    {
        private DB db;

        protected void Page_Load(object sender, EventArgs args)
        {
            db = new DB();
            String[] courses = db.GetCourses().Split('\n');
            for(int i=0; i<courses.Length-1; i++)
            {
                String[] temp = courses[i].Split(',');
                course.Items.Add(new ListItem(temp[1], temp[0]));

            }
        }

        public void RegisterStudent(object sender, EventArgs args)
        {
            if (Page.IsValid)
            {
                try {
                    db.AddStudent(student_name.Text, father_name.Text, mobile.Text, password.Text, Convert.ToInt32(course.SelectedValue), email.Text);
                    Response.Write("Registration Succesful");
                }
                catch (Npgsql.PostgresException) { }
                catch (Exception e)
                {
                    Response.Write(e.Message);
                }
            }
        }
    }
}
