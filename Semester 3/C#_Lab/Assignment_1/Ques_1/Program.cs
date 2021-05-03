using System;
using System.Collections;
using System.Collections.Generic;

namespace Ques_1
{
    class People{
        protected string name;
        public string Name{
            get{ return name; }
            set{ name=value; }
        } 
    }

    class Student:People{
        private int rno;
        public int Rno{
            get{ return rno; }
            set{ rno=value; }
        } 
    }

    class Teacher:People{
        public List<Course> courses = new List<Course>();
        public void addCourse(Course course){
            courses.Add(course);
        }
        public void removeCourse(string courseName){
            int i=0;
            for(i=0;i<courses.Count;i++)
                if(courses[i].Name.CompareTo(courseName)==0)
                    break;
            if(i<courses.Count)
                courses.RemoveAt(i);
        }
    }

    class Course{
        private string name;
        private int count_of_classes, count_of_exercises;
        public string Name{
            get{ return name; }
            set{ name=value; }
        }
        public int Count_of_classes{
            get{ return count_of_classes; }
            set{ count_of_classes=value; }
        }
        public int Count_of_exercises{
            get{ return count_of_exercises; }
            set{ count_of_exercises=value; }
        }
    }

    class Class{
        private string name;
        public List<Teacher> teachers = new List<Teacher>();
        public List<Student> students = new List<Student>();
        public string Name{
            get{ return name; }
            set{ name=value; }
        }
        public void addTeacher(Teacher teacher){
            teachers.Add(teacher);
        }
        public void removeTeacher(int index){
            try{
                teachers.RemoveAt(index);
            }catch(Exception e){Console.WriteLine(e.Message);}
        }
        public void addStudent(Student stud){
            students.Add(stud);
        }
        public void removeStudent(int rno){
            int i=0;
            for(i=0;i<students.Count;i++)
                if(students[i].Rno==rno)
                    break;
            if(i<students.Count)
                students.RemoveAt(i);
        }

    }

    class Program
    {
        static void Main(string[] args)
        {
            Class a = new Class();
            a.Name = "MCA (LE)";
            
            Student s1 = new Student(); s1.Name = "Student1"; s1.Rno = 1;
            Student s2 = new Student(); s2.Name = "Student2"; s2.Rno = 2;
            Student s3 = new Student(); s3.Name = "Student3"; s3.Rno = 3;
            a.addStudent(s1); a.addStudent(s2); a.addStudent(s3);

            Course c1 = new Course(); c1.Name = "Information Security"; c1.Count_of_classes=32; c1.Count_of_exercises=10;
            Course c2 = new Course(); c2.Name = "Advance Algorithms"; c2.Count_of_classes=26; c2.Count_of_exercises=18;
            Course c3 = new Course(); c3.Name = "FullStack Development"; c3.Count_of_classes=28; c3.Count_of_exercises=15;
            Course c4 = new Course(); c4.Name = "Crytography Techniques"; c4.Count_of_classes=30; c4.Count_of_exercises=20;

            Teacher t1 = new Teacher(); t1.Name="Teacher1"; t1.addCourse(c1); t1.addCourse(c3);
            Teacher t2 = new Teacher(); t2.Name="Teacher2"; t2.addCourse(c2); t2.addCourse(c4);
            a.addTeacher(t1); a.addTeacher(t2);

            Console.WriteLine("Class: {0}", a.Name);
            Console.WriteLine("Students:");
            foreach(Student s in a.students)
                Console.WriteLine("\tRoll Number: {1}, Name: {0}", s.Name, s.Rno);
            Console.WriteLine("Teachers:");
            foreach(Teacher t in a.teachers){
                Console.WriteLine("\tName: {0}", t.Name);
                Console.WriteLine("\tCourses:\n\t\tName\t\t\tCount of Classes\tCount of Excercises");
                foreach(Course c in t.courses)
                    Console.WriteLine("\t\t{0}\t\t{1}\t\t\t{2}",c.Name,c.Count_of_classes,c.Count_of_exercises);
            }

        }
    }
}