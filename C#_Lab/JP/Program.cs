using System;
using Npgsql;
using System.Collections.Generic;
using System.Linq;

namespace JP
{
    class Student{
        public int roll, score;
        public string name, city;
        public Student(int roll, string name, int score, string city){
            this.roll = roll; this.name = name; this.city = city; this.score = score;
        }
        public override string ToString(){
            return $"Roll Number: {roll}\tName: {name}\tCity: {city}\tScore: {score}";
        }
    }

    class Faculty{
        public int id, salary;
        public string name, city;
        public Faculty(int id, string name, int salary, string city){
            this.id = id; this.name = name; this.city = city; this.salary = salary;
        }
        public override string ToString(){
            return $"ID: {id}\tName: {name}\tCity: {city}\tSalary: {salary}";
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            string host = "localhost", username = "postgres", pass = "root", db = "bvicam";
            string connectionString = $"Host={host};Username={username};Password={pass};Database={db}";

            bool createTables = false;

            List<Student> stud = new List<Student>();
            List<Faculty> fac = new List<Faculty>();

            using(var con = new NpgsqlConnection(connectionString)){
                var cmd = new NpgsqlCommand();
                cmd.Connection = con;
                cmd.Connection.Open();
                if(createTables){
                    cmd.CommandText = "DROP TABLE IF EXISTS students"; cmd.ExecuteNonQuery();
                    cmd.CommandText = "DROP TABLE IF EXISTS faculty"; cmd.ExecuteNonQuery();
                    cmd.CommandText = "CREATE TABLE students(Roll INT PRIMARY KEY, Name VARCHAR(25), Score INT, City VARCHAR(25))";
                    cmd.ExecuteNonQuery();
                    cmd.CommandText = "CREATE TABLE faculty(ID SERIAL PRIMARY KEY, Name VARCHAR(25), Salary INT, City VARCHAR(25))";
                    cmd.ExecuteNonQuery();
                    cmd.CommandText = "INSERT INTO students VALUES (1, 'Student_1', 95, 'City_1')"; cmd.ExecuteNonQuery();
                    cmd.CommandText = "INSERT INTO students VALUES (2, 'Student_2', 83, 'City_2')"; cmd.ExecuteNonQuery();
                    cmd.CommandText = "INSERT INTO students VALUES (3, 'Student_3', 89, 'City_3')"; cmd.ExecuteNonQuery();
                    cmd.CommandText = "INSERT INTO faculty(Name, Salary, City) VALUES ('Faculty_1', 4000, 'City_3')"; cmd.ExecuteNonQuery();
                    cmd.CommandText = "INSERT INTO faculty(Name, Salary, City) VALUES ('Faculty_2', 6500, 'City_3')"; cmd.ExecuteNonQuery();
                    cmd.CommandText = "INSERT INTO faculty(Name, Salary, City) VALUES ('Faculty_3', 5700, 'City_2')"; cmd.ExecuteNonQuery();
                }
                // JP 1
                cmd.CommandText = "SELECT * from students";
                using(NpgsqlDataReader reader = cmd.ExecuteReader()){
                    while(reader.Read()){
                        stud.Add(new Student(reader.GetInt32(0), reader.GetString(1), reader.GetInt32(2), reader.GetString(3)));
                    }
                }
                cmd.CommandText = "SELECT * from faculty";
                using(NpgsqlDataReader reader = cmd.ExecuteReader()){
                    while(reader.Read()){
                        fac.Add(new Faculty(reader.GetInt32(0), reader.GetString(1), reader.GetInt32(2), reader.GetString(3)));
                    }
                }
            }
            // JP 2
            var temp =
                from f in fac
                where f.salary>5000
                select f;
            Console.WriteLine("Faculty with salary>5000:");
            foreach(Faculty f in temp){
                Console.WriteLine(f);
            }

            // JP 3
            Console.WriteLine("\nNames of faculty and students that live in same city Using Linq Concat");
            var cities =
                (from f in fac
                select f.city).Union(
                    from s in stud
                    select s.city
                );
            foreach(var city in cities){
                var temp2 =
                    (from f in fac
                    where f.city == city
                    select f.name).
                    Concat(
                        from s in stud
                        where s.city == city
                        select s.name
                    );
                Console.WriteLine(city);
                foreach(var obj in temp2){
                    Console.WriteLine($"\t{obj}");
                }
            }

            // JP 4
            var temp3 =
                from f in fac
                join s in stud
                on f.city equals s.city
                select new {faculty = f, student = s};
            Console.WriteLine("\nDetails of faculty and students that live in same city Using Linq Join\n\t\tFaculty\t\t\t\t\t|\t\t\tStudent");
            foreach(var obj in temp3){
                Console.WriteLine($"{obj.faculty}\t|\t{obj.student}");
            }

            // JP 5
            Console.WriteLine("\nGrouping Students by score:");
            var temp4 =
                from s in stud
                let div = s.score>=85?"I":(s.score>=70?"II":"III")
                group s by div into divisionGroup
                select divisionGroup;
            foreach(var divGroup in temp4){
                Console.WriteLine($"Division: {divGroup.Key}");
                foreach(var obj in divGroup)
                    Console.WriteLine($"\t{obj}");
            }
        }
    }
}