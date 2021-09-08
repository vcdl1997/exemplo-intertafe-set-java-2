package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import entities.Course;
import entities.Instructor;
import entities.Student;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Instructor Name");
		String instructorName = scan.nextLine();
		
		
		Instructor instructor = new Instructor(instructorName, new ArrayList<Course>());
		char courseLetter = 'A';
		
		for(int i = 0; i < 3; i++) {
			Set<Student> students = new HashSet<>();
			
			System.out.println("Enter the name of the course " + courseLetter);
			String courseName = scan.nextLine();
			
			System.out.println("Enter the number of students per course");
			int studentsQuantity = scan.nextInt();
			
			for(int j=0; j<studentsQuantity; j++) {
				System.out.println("Enter the student code");
				Integer code = scan.nextInt();
				students.add(new Student(code));
			}
			
			instructor.addCourses(new Course(courseName, students));
			courseLetter++;
			scan.nextLine();
		}
		
		Set<Student> students = new HashSet<Student>();
		
		for(Course course : instructor.getCourses()) {
			students.addAll(course.getStudents());
		}
		
		System.out.println("Total students: " + students.size());
		
		scan.close();
	}

}
