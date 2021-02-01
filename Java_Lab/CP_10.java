import java.util.Scanner;

class DateUtil{
    static String days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    int year, month, day;
    
    DateUtil(int year, int month, int day){
        this.year = year; this.month = month; this.day = day;
    }
    static boolean isLeapYear(int year){
        return (year%4==0 && year%100!=0 || year%400==0);
    }
    static boolean isValidDate(int year, int month, int day){
        if(year>=1 && year<=9999 && month>=1 && month<=12 && day>=1 && day<=31){
            if(month==4 || month==6 || month==9 || month==11)
                return day<=30;
            else if(month==2)
                return isLeapYear(year) && day<=29 || !isLeapYear(year) && day<=28;
            return true;
        }
        return false;
    }
    static int getWeekDay(int year, int month, int day){
        return (day+month+year+year/4+year/100)%7;
    }
    public String toString(){
        if(DateUtil.isValidDate(year, month, day))
            return DateUtil.days[DateUtil.getWeekDay(year, month, day)] + " " + day + " " + DateUtil.months[month-1] + " " + year;
        return "Invalid Date"; 
    }
}

public class CP_10 {
    public static void main(String[] args){
        int choice;
        Scanner obj = new Scanner(System.in);
        int y,m,d;
        do{
            System.out.print("1. Check Date\n2. Exit\nEnter Choice: "); choice = obj.nextInt();
            if(choice==1){
                System.out.print("Enter Year: "); y = obj.nextInt();
                System.out.print("Enter Month: "); m = obj.nextInt();
                System.out.print("Enter Day: "); d = obj.nextInt();
                System.out.println(new DateUtil(y,m,d)+"\n");
            }
        }while(choice!=2);
    }
}
