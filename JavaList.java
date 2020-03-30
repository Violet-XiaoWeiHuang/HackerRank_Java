/**
Java List

Data Structures, List

https://www.hackerrank.com/challenges/java-list/problem
*/

import java.io.*;
import java.util.*;

public class JavaList {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        List<Integer> al = new ArrayList<>(); 
        
        for(int i = 0; i< size; i++){
            al.add(input.nextInt());
        }

        int queries = input.nextInt(); 
        int insPos;
        int insEle; 
        int delPos;

        for(int i = 0; i< queries; i++){
            String que = input.next();
            //System.out.println(input.next());
            if(que.equals("Insert") ){
                insPos = input.nextInt();
                insEle = input.nextInt();
                //System.out.println("insPos = " + insPos + " insEle = " + insEle );
                al.add(insPos, insEle);
            }

            if(que.equals("Delete")){
                delPos = input.nextInt();
                al.remove(delPos);
            }
        }

        for (Integer value : al){
            System.out.print(value + " ");
        }
		
		input.close();
    }
}