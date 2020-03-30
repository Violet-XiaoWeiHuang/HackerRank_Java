/**
Java Sort

Data Structure, Sort, Comparator

https://www.hackerrank.com/challenges/java-comparator/problem
*/

import java.util.*;
import java.lang.Integer;
import java.lang.Double; 
import java.util.Collections; 

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

class StuSort implements Comparator<Student>{
    @Override
    public int compare(Student stu1, Student stu2){
        int cgpaComp = - (Double.compare(stu1.getCgpa(), stu2.getCgpa()));
        int nameComp = stu1.getFname().compareTo(stu2.getFname());
        int idComp = - (Integer.compare(stu1.getId(), stu2.getId()));

        if(cgpaComp == 0){
            if(nameComp == 0){
                return ((idComp == 0)? cgpaComp : idComp);
            }else{
                return nameComp; 
            }
        }else{
            return cgpaComp; 
        }
    }
}

//Complete the code
public class JavaSort{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
      
        Collections.sort(studentList, new StuSort());
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}
