import java.util.*;

class Player{
    private int teamId, playerId, age;
    private String name;

    public Player(int pId, int tId, String name, int age){
        playerId = pId;
        teamId = tId;
        this.name = name;
        this.age = age;
    }

    public int getTeamId(){
        return teamId;
    }

    public int getPlayerId(){
        return playerId;
    }

    public String toString(){
        return "Name: "+name+", Player ID: "+playerId+", Age: "+age+", Team ID: "+teamId;
    }

    static void printTeamDetails(Player p[], int t_id){
        System.out.printf("Players belonging to team %d:\n",t_id);
        for(Player player: p)
            if(player.getTeamId()==t_id)
                System.out.println(player);
    }
};

public class BP_6 {

    public static String getRandomString(){
        String string = "";
        for(int i=0;i<5;i++)
            string += (char)((int)(Math.random()*(90-65)+65));
        return string;
    }

    public static void main(String args[]){
        // assuming there are total 25 players and 5 teams with 5 players in each team.
        System.out.println("There are 5 teams with ID 1-5 and 25 players with ID 1-25\n");
        Player p[] = new Player[25];
        for(int i=0;i<25;i++)
            p[i] = new Player(i+1, i%5 + 1, getRandomString(), (int)(Math.random()*(50-20)+20));   // age between 20-50
        Scanner obj = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Get Team details\n2. Get Player details\n3. Exit");
            System.out.println("\nEnter Choice: "); choice = obj.nextInt();
            if(choice==1){
                System.out.print("Enter team ID: ");
                int tid=obj.nextInt();
                Player.printTeamDetails(p, tid);
            }else if(choice==2){
                System.out.print("Enter player ID: ");
                int pid = obj.nextInt();
                for(Player player: p)
                    if(player.getPlayerId()==pid)
                        System.out.println(player);
            }
        }while(choice!=3);
    }
}
