using System;

namespace CP{
    class GSM:Call{
        public void Delete(){
            PrintHistory();
            Console.WriteLine("Enter S.No.: ");
            int index = Convert.ToInt32(Console.ReadLine()) - 1;
            if(index>=0 && index<history.Count)
                history.RemoveAt(index);
            Console.WriteLine("Deletion Succesful");
        }

        public void DeleteAll(){
            history.Clear();
            Console.WriteLine("History Cleared");
        }

        public void CalcAmount(float price){
            float total = 0f;
            foreach(Object[] o in history)
                total += (long)o[1]*price;
            Console.WriteLine("Total Amount is Rs {0}", total);
        }
    }
}