/**
Java Anagrams

Strings

https://www.hackerrank.com/challenges/java-anagrams/
*/

import java.util.Scanner;

public class isAnagram {

    static boolean isAnagram(String a, String b) {
        if(a == null || b == null || a.length() != b.length()){
            return false;
        }

        // convert strings  to lower case 
        //String a_lc = a.toLowerCase();
        //String b_lc = b.toLowerCase(); 
        a = a.toLowerCase();
        b = b.toLowerCase(); 

/*
        // convert strings to string arrays 
        String[] alist = a_lc.split("");
        String[] blist = b_lc.split("");

        // sort arrays
        //Arrays.sort(alist);
        //Arrays.sort(blist);

        // apply HashMap to hash the Strings and each char as key 
        Map<Character, Integer>ahm = new HashMap<>();
        Map<Character, Integer>bhm = new HashMap<>(); 
        
        // maping the string array in to hashmap 
        for(int i = 0; i < alist.length; i++){
            Integer count_a = ahm.get(alist[i]);
            Integer count_b = bhm.get(blist[i]);
            if(count_a == null){
                ahm.put(alist[i], 1);
            }else{
                ahm.put(alist[i], count+1);
            }

            if(count_b == null){
                bhm.put(alist[i], 1);
            }else{
                bhm.put(blist[i], count+1);
            }
        }
        
        for(int i = 0; i < alist.length; i++){
            if(ahm.get(alist[i] != bhm.get(blist[i]))){
                return false;
            }
                
            
        } */

        int[] countA = new int[26];
        int[] countB = new int[26];

        for(int i=0; i<a.length(); i++){
            countA[a.charAt(i) - 'a']++;
            countB[b.charAt(i) - 'a']++;
        }

        for(int i = 0; i< 26; i++){
            if(countA[i] != countB[i]){
                return false;
            }
        }

        return true; 
    }

	public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}