using System;

namespace _23_Jan_21
{
    class Program
    {
        static void Main(string[] args)
        {
            Student stud1 = new Student("ABC", "CourseX", "SubjectX", "UniversityX");
            stud1.displayStudentInfo();

            Student stud2 = new Student("XYZ", "CourseY", "SubjectY", "UniversityY", "email@example.com", "9999999999");
            stud2.displayStudentInfo();
        }
    }
}