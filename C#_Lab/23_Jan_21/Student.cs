using System;

class Student{
    string? full_name, course, subject, university, email, phone_number;
    public Student(string name, string course, string subject, string university){
        full_name = name; this.course = course;
        this.subject = subject; this.university = university;
        email = null; phone_number = null;
    }
    public Student(string name, string course, string subject, string university, string email, string phone_number){
        full_name = name; this.course = course;
        this.subject = subject; this.university = university;
        this.email = email; this.phone_number = phone_number;
    }
    public void displayStudentInfo(){
        Console.WriteLine(
            "Name: {0}, Course: {1}, Subject: {2}, University: {3}, E-Mail: {4}, Phone Number: {5}",
            full_name, course, subject, university, email, phone_number
        );
    }
}