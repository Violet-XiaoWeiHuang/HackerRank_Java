/**
Java Arraylist

Data Structures, Arraylist

https://www.hackerrank.com/challenges/java-arraylist/problem?h_r=internal-search
*/

import java.io.*;
import java.util.*;

public class JavaArraylist {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int totAL = input.nextInt();
        int arrSize;

        ArrayList[] sets = new ArrayList[totAL];

        for(int i= 0; i< totAL; i++){
            arrSize = input.nextInt();
            sets[i] = new ArrayList();
            
            for(int j= 0; j< arrSize; j++){
                sets[i].add(input.nextInt());
            }    
        }

        int query = input.nextInt(); 
        int set;
        int pos; 
        for(int i= 0; i< query; i++){
            set = input.nextInt(); 
            pos = input.nextInt();

            try{
                System.out.println(sets[set-1].get(pos-1));
            }catch(Exception error){
                System.out.println("ERROR!");
            }
        }
		
		input.close();
    }
}
