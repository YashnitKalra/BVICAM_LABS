using System;
using System.Collections.Generic;

namespace Question_2
{
    class Program
    {
        interface SoundInterface{
            public string Sound();
        }
        class Animal:SoundInterface{
            public int age;
            public string name, gender;
            public Animal(int age, string name, string gender){
                this.age = age; this.name = name; this.gender = gender;
            }
            public virtual string Sound(){return null;}
        }
        class Dog:Animal{
            public Dog(int age, string name, string gender):base(age, name, gender){}
            public override string Sound(){return "bow-wow";}
        }
        class Frog:Animal{
            public Frog(int age, string name, string gender):base(age, name, gender){}
            public override string Sound(){return "croak";}
        }
        class Cat:Animal{
            public Cat(int age, string name, string gender):base(age, name, gender){}
            public override string Sound(){return "meow";}
        }
        class Kitten:Cat{
            public Kitten(int age, string name, string gender):base(age, name, gender){}
        }
        class Tomcat:Cat{
            public Tomcat(int age, string name, string gender):base(age, name, gender){}
        }
        static void Main(string[] args)
        {
            Dictionary<string, string> dict = new Dictionary<string, string>(){
                {"bow-wow","Dog"}, {"croak","Frog"}, {"meow","Cat"} 
            };
            List<Animal> list = new List<Animal>(){
                new Dog(3, "ABC", "Male"), new Frog(2, "PQR", "Male"), new Cat(5, "XYZ", "Female"),
                new Kitten(1, "EFG", "Female"), new Tomcat(4, "IJK", "Male")
            };
            Console.WriteLine("Name\tAge\tGender\tSound\tAnimal_Category");
            foreach(Animal animal in list){
                Console.WriteLine(
                    "{0}\t{1}\t{2}\t{3}\t{4}",
                    animal.name, animal.age, animal.gender, animal.Sound(), dict[animal.Sound()]
                );
            }
        }
    }
}
