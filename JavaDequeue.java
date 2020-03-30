/*
Java Dequeue

Data Structure, Dequeue

https://www.hackerrank.com/challenges/java-dequeue/problem
*/

import java.util.*;
public class JavaDequeue {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<>();
		//Map<Integer, Integer> dequeMap = new HashMap<>();
		Set<Integer> hashset = new HashSet<>();
		int n = in.nextInt();   // total number of integers 
		int m = in.nextInt();   // size of the subarray

		int numTemp;   // check whether the int is unique in the subarray
		int max = 0; 

		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			int temp = 0;   // temp hold the amount of unique numbers

			// add new element in when deque size less then m
			if(deque.size() < m){
				//System.out.println("in deque  < m" );
				deque.add(num);
				//dequeMap.put(Integer.valueOf(num),Integer.valueOf(num));
				hashset.add(Integer.valueOf(num));
				//temp = dequeMap.size();
				temp = hashset.size();
				//System.out.println("temp = " + temp +" : hashset = " + hashset );
			}else if(deque.size() == m){
				//System.out.println("in deque  = m" );
				numTemp = (int)deque.peekFirst();
				deque.pollFirst();
				//dequeMap.remove(Integer.valueOf(numTemp));
				hashset.remove(Integer.valueOf(numTemp));
				
				//for(Iterator<Integer> it = deque.iterator(); it.hasNext(); ){
				for(Iterator<Integer> it = deque.iterator(); it.hasNext(); ){
					Integer curNum = it.next();
					//dequeMap.put(curNum, curNum);
					hashset.add(curNum);
				}
				
				deque.addLast(num);
				//dequeMap.put(Integer.valueOf(num),Integer.valueOf(num));
				//temp = dequeMap.size();
				hashset.add(Integer.valueOf(num));
				temp = hashset.size();

				//System.out.println("temp = " + temp +" : hashset = " + hashset );
			}

			if(max <= temp){
				max = temp;
			}
		}

		System.out.print(max);
	}
}



