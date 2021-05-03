using System;
using System.Collections.Generic;

namespace DP
{

    class Session{
        Dictionary<string,string> details = new Dictionary<string,string>();

        public String this[string key]{
            get{
                if(!details.ContainsKey(key)) return "Invalid Key";
                return details[key]; 
            }
            set{ details.Add(key, value); }
        }
    }
    class Program
    {
        static Session createSession(string username, Dictionary<string, string> details){
            Session session = new Session();
            session["username"] = username;
            foreach(KeyValuePair<string, string> detail in details){
                if(detail.Key.CompareTo("password")!=0)
                    session[detail.Key] = detail.Value;
            }
            return session;
        }
        static void Main(string[] args)
        {
            Dictionary<string,Dictionary<string,string>> auth = new Dictionary<string, Dictionary<string,string>>();
            auth.Add("demoUser1", new Dictionary<string, string>(){{"password","123456"}, {"id","1"}, {"name","Demo User 1"}, {"age","28"}});
            auth.Add("demoUser2", new Dictionary<string, string>(){{"password","abcdef"}, {"id","2"}, {"name","Demo User 2"}, {"age","34"}});
            Session session;
            while(true){
                Console.WriteLine("Enter Username: ");
                string username = Console.ReadLine();
                if(auth.ContainsKey(username)){
                    Console.WriteLine("Enter Password: ");
                    string password = Console.ReadLine();
                    if(auth[username]["password"].CompareTo(password)==0){
                        Console.WriteLine("\n*****Welcome {0}*****", username);
                        session = createSession(username, auth[username]);
                        break;
                    }else Console.WriteLine("Invalid Password");
                }else Console.WriteLine("Username Not Found");
            }
            string choice;
            do{
                Console.WriteLine("\nEnter index/key name: ");
                string index = Console.ReadLine();
                Console.WriteLine("{0}: {1}", index, session[index]);
                Console.WriteLine("Do you want to continue? (Enter 'y' or 'Y' for YES): ");
                choice = Console.ReadLine().ToLower();
            }while(choice.CompareTo("y")==0);
        }
    }
}