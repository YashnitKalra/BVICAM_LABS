using System;
using Npgsql;
using System.Collections.Generic;

namespace WT_Lab_Pracs
{
    public class DB
    {
        private string connectionString;
        private NpgsqlConnection con;
        private NpgsqlCommand cmd;
        public DB()
        {
            string host = "localhost", username = "root", pass = "root", db = "wt";
            connectionString = $"Host={host};Username={username};Password={pass};Database={db}";
            con = new NpgsqlConnection(connectionString);
            cmd = new NpgsqlCommand();
            cmd.Connection = con;
            cmd.Connection.Open();
        }

        public string GetCourses()
        {
            string s = "";
            try
            {
                cmd.CommandText = "SELECT * FROM course";
                using (NpgsqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                        s += $"{reader.GetInt32(0)}, {reader.GetString(1)}, {reader.GetInt32(2)}, {reader.GetFloat(3)}\n";
                }
                
            }
            catch (Exception e) { return e.Message; };
            return s;
        }

        public void AddStudent(String name, String father_name, String mobile, String password, int course_id, String email)
        {
            cmd.CommandText = "INSERT INTO student VALUES (@name, @father_name, @mobile, @password, @course_id, @email)";
            cmd.Parameters.AddWithValue("name", name);
            cmd.Parameters.AddWithValue("father_name", father_name);
            cmd.Parameters.AddWithValue("mobile", mobile);
            cmd.Parameters.AddWithValue("password", password);
            cmd.Parameters.AddWithValue("course_id", course_id);
            cmd.Parameters.AddWithValue("email", email);
            cmd.ExecuteNonQuery();
        }

        public bool StudentExists(String email, String password)
        {
            cmd.CommandText = $"SELECT COUNT(*) as num FROM student WHERE email='{email}' AND password='{password}'";
            bool res;
            using (NpgsqlDataReader reader = cmd.ExecuteReader())
            {
                res = reader.Read() && Convert.ToInt32(reader["num"]) == 1;
            }
            return res;
        }

        public bool UserExists(String username, String password)
        {
            cmd.CommandText = $"SELECT COUNT(*) as num FROM student WHERE name='{username}' AND password='{password}'";
            bool res;
            using (NpgsqlDataReader reader = cmd.ExecuteReader())
            {
                res = reader.Read() && Convert.ToInt32(reader["num"]) == 1;
            }
            return res;
        }

        public NpgsqlDataReader GetSubjects(String email)
        {
            cmd.CommandText = "SELECT name as Subjects FROM subjects WHERE id IN" +
                "(SELECT subject_id FROM course_subjects WHERE course_id IN" +
                $"(SELECT course_id FROM student WHERE email='{email}'))";
            return cmd.ExecuteReader();
        }

        private string GetPatientDetails(int id)
        {
            cmd.CommandText = $"SELECT name,disease FROM patient WHERE patient_id={id}";
            using (NpgsqlDataReader reader = cmd.ExecuteReader())
            {
                reader.Read();
                return reader.GetString(0) + "," + reader.GetString(1);
            }
        }

        private string GetNurse(int id)
        {
            cmd.CommandText = $"SELECT name FROM nurse WHERE nurse_id={id}";
            using (NpgsqlDataReader reader = cmd.ExecuteReader())
            {
                reader.Read();
                return reader.GetString(0);
            }
        }

        private string GetMedicine(int id)
        {
            cmd.CommandText = $"SELECT name FROM medicine WHERE medicine_id={id}";
            using (NpgsqlDataReader reader = cmd.ExecuteReader())
            {
                reader.Read();
                return reader.GetString(0);
            }
        }

        public Dictionary<String, Dictionary<String, String>> GetRoutine()
        {
            cmd.CommandText = "SELECT * FROM routine ORDER BY time";
            Dictionary<String, Dictionary<String, String>> data = new Dictionary<string, Dictionary<string, string>>();
            String id; 
            int p_id, n_id, m_id;
            DateTime dt;
            String[] temp;
            using (NpgsqlDataReader reader = cmd.ExecuteReader())
            {
                while (reader.Read())
                {
                    dt = reader.GetDateTime(4);
                    if (dt.TimeOfDay.CompareTo(DateTime.Now.TimeOfDay) != 0)
                    {
                        id = reader.GetInt32(0).ToString();
                        p_id = reader.GetInt32(1); n_id = reader.GetInt32(2); m_id = reader.GetInt32(3);
                        data.Add(id, new Dictionary<string, string>());
                        data[id].Add("time", dt.TimeOfDay.ToString());
                        data[id].Add("patient_id", p_id.ToString());
                        data[id].Add("medicine_id", m_id.ToString());
                        data[id].Add("nurse_id", n_id.ToString());
                    }
                }
            }
            foreach(KeyValuePair<String, Dictionary<String, String>> p in data){
                temp = GetPatientDetails(Convert.ToInt32(data[p.Key]["patient_id"])).Split(',');
                data[p.Key].Add("patient_name", temp[0]);
                data[p.Key].Add("disease", temp[1]);
                data[p.Key].Add("nurse", GetNurse(Convert.ToInt32(data[p.Key]["nurse_id"])));
                data[p.Key].Add("medicine", GetMedicine(Convert.ToInt32(data[p.Key]["medicine_id"])));
            }
            return data;
        }
    }
}
