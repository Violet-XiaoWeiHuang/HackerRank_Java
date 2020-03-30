/**
Java Priority Queue

Data Structure, Priority Queue, Comparator

https://www.hackerrank.com/challenges/java-priority-queue/problem
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.lang.Integer;
import java.lang.Double;

class Student implements Comparator<Student>{
    private String name;
    private double cgpa;
    private int id;

    public Student(String newName, double newCgpa, int newId){
        super();
        this.name = newName;   
        this.cgpa = newCgpa;
        this.id = newId; 
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name; 
    }

    public double getCGPA(){
        return cgpa; 
    }

    //@Override 
    public int compare(Student stu1, Student stu2){
        int cgpaComp = - (Double.compare(stu1.getCGPA(), stu2.getCGPA()));
        int nameComp = stu1.getName().compareTo(stu2.getName());
        int idComp = Integer.compare(stu1.getID(), stu2.getID());

        if(cgpaComp == 0){
            if(nameComp == 0){
                return ((idComp == 0)? cgpaComp:idComp);
            }else{
                return nameComp;
            }
        }else{
            return cgpaComp;
        }
    }
}

class Priorities{
    public List<Student> getStudents(List<String> events){
        //System.out.println("getStudents()");
        
        PriorityQueue<Student> sq = new PriorityQueue<Student>(Comparator.comparing(Student::getCGPA).reversed().thenComparing(Student::getName).thenComparing(Student::getID));

        for(String e: events){
            String[] s = new String[4];
            s = e.split("\\s");
            if(s.length > 1){   
                sq.add(new Student(s[1], Double.valueOf(s[2]), Integer.valueOf(s[3])));
            }else{
                sq.poll();
            }
        }

        if(sq.size()>1){
            System.out.println(sq.poll().getName());
        }

       // System.out.println(students);
        return new ArrayList<Student>(sq);
		
/*
		List<Student> students = new ArrayList<>();
		// use Scanner to extra student's infor
		// use PriorityQueue sq to filter the students with higher priorities 
        PriorityQueue<Student> sq = new PriorityQueue<Student>(Comparator.comparing(Student::getCGPA).reversed().thenComparing(Student::getName).thenComparing(Student::getID));

        for(String e: events){
            Scanner sc = new Scanner(e);
            String s = sc.next();
            
            if(s.equals("ENTER")){
                Student stu = new Student(sc.next(), sc.nextDouble(), sc.nextInt());
                sq.add(stu);
            }else if(s.equals("SERVED")){
                Student first = sq.poll();
                
            }
            sc.close();
            //System.out.println(sq);
        }
		
		// restore the rest students from sq to the return student List
        Student first = sq.poll();

        if(first == null){
            return students;
        }else{
            while(first != null){
                students.add(first);
                first = sq.poll();
            }
        }
        
		// System.out.println(students);
        return students;
		*/
    }  
}




public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}