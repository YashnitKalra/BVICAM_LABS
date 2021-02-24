using System;
using System.Collections.Generic;

namespace Question_3
{
    class Event{
        public string name;
        public DateTime start,end;
        public Event(string name, DateTime start, DateTime end){
            this.name = name; this.start = start; this.end = end;
        }
        override public string ToString(){
            return String.Format("Event Name: {0}, Start: {1}, End: {2}", name, start, end);
        }
    }

    class AccordingToStart:IComparer<Event>{
        public int Compare(Event e1, Event e2){
            return e1.start.CompareTo(e2.start);
        }
    }

    class AccordingToEnd:IComparer<Event>{
        public int Compare(Event e1, Event e2){
            return e1.end.CompareTo(e2.end);
        }
    }

    class Program
    {
        static DateTime GetDateTime(){
            Console.Write("Enter Date and Time (YYYY MM DD hh mm ss): ");
            int[] t = Array.ConvertAll(Console.ReadLine().Split(" "), int.Parse);
            return new DateTime(t[0], t[1], t[2], t[3], t[4], t[5]);
        }

        static void Main(string[] args)
        {
            SortedSet<Event> startTimeSet = new SortedSet<Event>(new AccordingToStart());
            SortedSet<Event> endTimeSet = new SortedSet<Event>(new AccordingToEnd());
            int choice;
            Event e;
            DateTime from, to;
            string name;
            do{
                Console.Write("1. Add New Event\n2. Search Events\nEnter Choice: ");
                choice = int.Parse(Console.ReadLine());
                switch(choice){
                    case 1:
                        Console.Write("Enter event name: "); name = Console.ReadLine();
                        Console.Write("From: "); from = GetDateTime();
                        Console.Write("To: "); to = GetDateTime();
                        e = new Event(name, from, to);
                        startTimeSet.Add(e); endTimeSet.Add(e);
                        break;
                    case 2:
                        Console.Write("From: ");
                        from = GetDateTime();
                        Console.Write("To: ");
                        to = GetDateTime();
                        e = new Event("temp" ,from, to);
                        try{
                            SortedSet<Event> subset1 = startTimeSet.GetViewBetween(e, startTimeSet.Max);
                            SortedSet<Event> subset2 = endTimeSet.GetViewBetween(endTimeSet.Min, e);
                            Console.Write("\n");
                            foreach(Event ee in subset1){
                                if(subset2.Contains(ee))
                                    Console.WriteLine(ee.ToString());
                            }Console.Write("\n");
                        }catch(Exception excep){Console.WriteLine(excep.Message);}
                        break;
                }
            }while(choice>0 && choice<3);
        }
    }
}