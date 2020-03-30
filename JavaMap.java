/**
Java Map

Data Structures, Map

https://www.hackerrank.com/challenges/phone-book/problem
*/

import java.util.*;
import java.io.*;
import java.lang.Integer;

class JavaMap{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();     // total entries in the phone book
        // use HashMap to store person's name and phone number
        Map<String, Integer>phonebook = new HashMap<>();

		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			in.nextLine();
            if(!phonebook.containsKey(name)){
                phonebook.put(name, Integer.valueOf(phone));
            }
		}
        
		while(in.hasNext())
		{
			String s=in.nextLine();
            if(phonebook.containsKey(s)){
                System.out.println(s + "=" + phonebook.get(s));
            }else{
                System.out.println("Not found");
            }

		}

        in.close();
	}
}
