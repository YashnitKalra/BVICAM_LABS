using System;

namespace Question_1
{
    delegate double Area();
    abstract class Shape{
        public double height, width;
        public abstract double CalculateSurface();
    }
    class Triangle:Shape{
        public Triangle(double h, double w){
            height = h; width = w;
        }
        public override double CalculateSurface(){
            return height*width/2;
        }
    }
    class Rectangle:Shape{
        public Rectangle(double h, double w){
            height = h; width = w;
        }
        public override double CalculateSurface(){
            return height*width;
        }
    }
    class Circle:Shape{
        public Circle(double radius){
            height = width = radius;
        }
        public override double CalculateSurface(){
            return (22 * height * width)/7;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Shape[] shapes = new Shape[]{new Triangle(8,9), new Rectangle(8,9), new Circle(5)};
            double[] areas = new double[3];
            Area d = null;
            for(int i=0;i<3;i++){
                d += shapes[i].CalculateSurface;
                areas[i] = d();
            }
            Console.WriteLine("Areas of Triangle, Rectangle and Circle are\n{0} unit sq. | {1} unit sq. | {2} unit sq. respectively", areas[0], areas[1], areas[2]);
        }
    }
}