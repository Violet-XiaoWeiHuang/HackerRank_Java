/**
Java Comparator

Data Structure, Comparator

https://www.hackerrank.com/challenges/java-comparator/problem
*/

import java.util.*;
import java.lang.Integer; 

// Write your Checker class here
class Checker implements Comparator<Player>{
    @Override 
    public int compare(Player player1, Player player2){
        // compare fields
        /*
        int scoreComp;
        if(player1.score == player2.score){
            scoreComp = 0;
        }else if(player1.score > player2.score){
            scoreComp =  -1; 
        }else{
            scoreComp = 1;
        }
        */

        int scoreComp = - (Integer.compare(player1.score, player2.score)); 
        int nameComp = player1.name.compareTo(player2.name);

        if(scoreComp == 0){
            return ((nameComp == 0) ? scoreComp : nameComp);
        }else{
            return scoreComp;
        }
    }
}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class JavaComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
