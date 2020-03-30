/**
Java String Tokens

Strings 

https://www.hackerrank.com/challenges/java-string-tokens/
*/
import java.io.*;
import java.util.*;

public class StringToken {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        // loop through the String by each char
        boolean isInToken = false;
        int tokenStart = 0;  
        ArrayList<String> tokenAL = new ArrayList<String>(); 

        for(int i = 0; i< s.length(); i++){
            //int tokenStart;  
            // identify the char whether it's a alphabetic letter 
            // truncate the expression and load in arrayList
            switch(s.charAt(i)){
            case ' ':
            case '!':
            case ',':
            case '?':                
            case '.':                
            case '_':                
            case '\'':
            case '@':
                if(isInToken){
                    tokenAL.add(s.substring(tokenStart, i));
                }
                isInToken = false;
                
                break;
            default:
                if(!isInToken){
                    isInToken = true; 
                    tokenStart = i; 
                }
            }
        }
		
		// case: end of line char is a alphabetic letter
        if(isInToken){
            tokenAL.add(s.substring(tokenStart));
        }
        
        System.out.println(tokenAL.size());
        for(String i: tokenAL){
            System.out.println(i);
        }

        scan.close();
    }
}

