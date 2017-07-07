import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student{
   private int token;
   private String fname;
   private double cgpa;
   public Student(int id, String fname, double cgpa) {
      super();
      this.token = id;
      this.fname = fname;
      this.cgpa = cgpa;
   }
   public int getToken() {
      return token;
   }
   public String getFname() {
      return fname;
   }
   public double getCgpa() {
      return cgpa;
   }
}

public class Solution {

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     PriorityQueue<Student> pq = new PriorityQueue<Student>((s1, s2) -> (s1.cgpa != s2.cgpa)? (Double.compare(s2.cgpa, s1.cgpa)):(!s1.name.equals(s2.name) ? s1.name.compareTo(s2.name) : Integer.compare(s1.token, s2.token)));

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String command = sc.next();
			if (command.equals("ENTER")) {
				String name = sc.next();
				double cgpa = sc.nextDouble();
				int token = sc.nextInt();

				pq.offer(new Student(token, name, cgpa));
			} else if (command.equals("SERVED")) {
				pq.poll();
			}
		}

		if (pq.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			while (!pq.isEmpty()) {
				System.out.println(pq.poll().name);
			}
		}

		sc.close();
    }
}
