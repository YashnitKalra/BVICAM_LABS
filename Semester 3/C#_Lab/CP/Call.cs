using System;
using System.Collections;

class Call{
    protected ArrayList history;
    public Call(){
        history = new ArrayList();
    }
    public void AddCall(DateTime startedAt, long duration){
        history.Add(new Object[]{startedAt, duration});
    }
    public string GetDuration(long sec){
        long min = sec/60;
        sec %= 60;
        long hrs = min/60;
        min %= 60;
        return String.Format("{0} hrs, {1} min, {2} sec", hrs, min, sec);
    }
    public void PrintHistory(){
        int i = 1;
        foreach(Object[] o in history){
            Console.WriteLine("{0}. Called At: {1}\tDuration: {2}", i++, (DateTime)o[0], GetDuration((long)o[1]));
        }
    }
}