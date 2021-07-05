using System;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Collections.Generic;

namespace WT_Lab_Pracs
{

    public partial class EP : System.Web.UI.Page
    {
        private String[] keys = { "patient_id", "patient_name", "disease", "nurse", "medicine", "time" };

        protected void Page_Load(object sender, EventArgs args)
        {
            DB db = new DB();
            TableRow tr;
            TableCell tc;
            Dictionary<String, Dictionary<String, String>> data = db.GetRoutine();
            int i = 1;
            foreach(KeyValuePair<String, Dictionary<String, String>> k in data)
            {
                tr = new TableRow();
                foreach(String key in keys)
                {
                    tc = new TableCell();
                    tc.Text = data[k.Key][key];
                    tc.Text = "13:07:00";
                    tc.ID = $"{key}_{i}";
                    tr.Cells.Add(tc);
                }
                tc = new TableCell();
                tc.ID = $"time_left_{i}";
                tr.Cells.Add(tc);
                tr.ID = $"row_{i}";
                i++;
                table_routine.Rows.Add(tr);
            }

        }
    }
}
