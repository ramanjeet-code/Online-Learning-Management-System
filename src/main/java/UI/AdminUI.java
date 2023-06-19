package UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Entity.Course;
import Entity.Enrollment;
import Entity.Grade;
import Entity.Student;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;
import Service.CourseService;
import Service.CourseServiceImpl;
import Service.EnrollmentService;
import Service.EnrollmentServiceImpl;
import Service.GradeService;
import Service.GradeServiceImpl;
import Service.StudentService;
import Service.StudentServiceImpl;

public class AdminUI {

	public AdminUI() {
		// TODO Auto-generated constructor stub
	}
public static void adminMenu(Scanner sc) throws SomeThingWentWrongException, NoRecordFoundException {
	adminLogin(sc);
	int ch=0;
	do {
		System.out.println("1. Manage Course");
		System.out.println("2.Student Performance\r\n"
				+ "3.Course Reports\r\n4.Enrollment Management"
				+ "0.Log Out from Admin Section");
		
		ch=sc.nextInt();
	switch(ch) {
	case 1:
	     courseMenu(sc);
	     break;
	case 2: 	   TrackStudentPerformance(sc);
				break;
	case 3:	 RepoartsMenu(sc);
				break;
	case 4:
	    enrollmentMenu(sc);
	    break;		
	case 0: System.out.println("Thanks Admin for visit");
	  break;
	  default :
		  System.out.println("INvalid Keyword");
		 
	}
	}while(ch!=0);
	
}

	private static void enrollmentMenu(Scanner sc) {
	// TODO Auto-generated method stub
		int ch = 0;
	    do {
	        System.out.println("1. Enroll a student in a course");
	        System.out.println("2. Remove a student from a course");
	        System.out.println("3. getEnrollmentsByCourse");
	        System.out.println("4.getEnrollmentsByStudent");
	        System.out.println("5.getTotalEnrolledStudents in a Course");
	        System.out.println("0. Go back to the previous menu");

	        ch = sc.nextInt();

	        switch (ch) {
	            case 1:
	                enrollStudentInCourse(sc);
	                break;
	            case 2:
	                removeStudentFromCourse(sc);
	                break;
	            case 3:
	            	 getEnrollmentsByCourse(sc);
	            	 break;
	            case 4:
	            	getEnrollmentsByStudent(sc);
	            	break;
	            case 5:
	            	getTotalEnrolledStudents(sc);
	            	break;
	            case 0:
	                System.out.println("Returning to the previous menu...");
	                break;
	            default:
	                System.out.println("Invalid option");
	                break;
	        }
	    } while (ch != 0);
}
	private static void getTotalEnrolledStudents(Scanner sc) {
		System.out.print("Enter the course ID: ");
	    Long courseId = sc.nextLong();
	    sc.nextLine(); // Consume the newline character
	    
	    // Create an instance of EnrollmentService
	    EnrollmentService enrollmentService = new EnrollmentServiceImpl();

	    try {
	        // Get the total number of enrolled students for the specified course
	        int totalEnrolledStudents = enrollmentService.getTotalEnrolledStudents(courseId);
	        System.out.println("Total enrolled students for course " + courseId + ": " + totalEnrolledStudents);
	    } catch (SomeThingWentWrongException e) {
	        System.out.println("Course with ID " + courseId + " not found.");
	    }
		
	}
	private static void getEnrollmentsByStudent(Scanner sc) {
		   System.out.println("Enter student ID:");
		    Long studentId = sc.nextLong();

		    // Create an instance of EnrollmentService
		    EnrollmentService enrollmentService = new EnrollmentServiceImpl();

		    try {
		        // Get the enrollments for the given student
		        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(studentId);
		        if (enrollments.isEmpty()) {
		            System.out.println("No enrollments found for the student.");
		        } else {
		            System.out.println("Enrollments for the student:");
		            for (Enrollment enrollment : enrollments) {
		                System.out.println(enrollment);
		            }
		        }
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("An error occurred while getting enrollments: " + e.getMessage());
		    }
	}
	private static void getEnrollmentsByCourse(Scanner sc) {
		System.out.println("Enter course ID:");
	    Long courseId = sc.nextLong();

	    // Create an instance of EnrollmentService
	    EnrollmentService enrollmentService = new EnrollmentServiceImpl();

	    try {
	        // Get the enrollments for the given course
	        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByCourse(courseId);
	        if (enrollments.isEmpty()) {
	            System.out.println("No enrollments found for the course.");
	        } else {
	            System.out.println("Enrollments for the course:");
	            for (Enrollment enrollment : enrollments) {
	                System.out.println(enrollment);
	            }
	        }
	    } catch (SomeThingWentWrongException e) {
	        System.out.println("An error occurred while getting enrollments: " + e.getMessage());
	    }
		
	}
	private static void removeStudentFromCourse(Scanner sc) {
		// TODO Auto-generated method stub
		 System.out.println("Enter student ID:");
		    Long studentId = sc.nextLong();

		    System.out.println("Enter course ID:");
		    Long courseId = sc.nextLong();

		    // Create an instance of EnrollmentService
		    EnrollmentService enrollmentService = new EnrollmentServiceImpl();

		    try {
		        // Remove the student from the course
		        enrollmentService.dropStudent(studentId, courseId);
		        System.out.println("Student removed from the course successfully!");
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("An error occurred while removing the student from the course: " + e.getMessage());
		    }
	}
	private static void enrollStudentInCourse(Scanner sc) {
		// TODO Auto-generated method stub
		 System.out.println("Enter student ID:");
		    Long studentId = sc.nextLong();

		    System.out.println("Enter course ID:");
		    Long courseId = sc.nextLong();

		    // Create an instance of EnrollmentService
		    EnrollmentService enrollmentService = new EnrollmentServiceImpl();

		    try {
		        // Enroll the student in the course
		        enrollmentService.enrollStudent(studentId, courseId);
		        System.out.println("Student enrolled in the course successfully!");
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("An error occurred while enrolling the student: " + e.getMessage());
		    }
	}
	private static void    TrackStudentPerformance(Scanner sc) throws SomeThingWentWrongException {
	// TODO Auto-generated method stub
		int ch=0;
		do {
			System.out.println("1.Retrieves the performance data for a specific student  ");
			System.out.println("2. Retrieves the performance data for all students enrolled in a particular course.");
			System.out.println("3.average performance score for a specific course.");
			System.out.println("0.Exit from Student Tracking System");

			ch=sc.nextInt();
		switch(ch) {
		case 1:getStudentPerformanceById(sc);
			 break;
		case 2:
			getStudentPerformanceByCourse(sc);
			 break;
		case 3:
			getAveragePerformanceForCourse(sc);
			break;
			default :
				 System.out.println("INvalid Keyword");
		}
		}while(ch!=0);
}
	private static void getAveragePerformanceForCourse(Scanner sc) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		System.out.println("Enter Course ID :");
		 Long id=sc.nextLong();
		 GradeService grade=new GradeServiceImpl();
		 System.out.println(grade.getAverageGradeForCourse(id));
	}
	private static void getStudentPerformanceByCourse(Scanner sc) throws SomeThingWentWrongException  {
		// TODO Auto-generated method stub
		 System.out.println("Enter Course ID :");
		 Long id=sc.nextLong();
		 GradeService grade=new GradeServiceImpl();
		 List<Grade> list= grade.getGradesByCourse(id);
	}
	private static void getStudentPerformanceById(Scanner sc) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		 System.out.println("Enter student ID :");
		 Long id=sc.nextLong();
		 GradeService grade=new GradeServiceImpl();
		 List<Grade> list= grade.getGradesByStudent(id);
		 System.out.println(list);
	}
	private static void RepoartsMenu(Scanner sc) {
	// TODO Auto-generated method stub
		int ch=0;
		do {
			System.out.println("1.Course Enrollment Report: ");
			System.out.println("2.Student Performance Report: ");
			System.out.println("3.Instructor Performance Report");
			System.out.println("4.Financial Report: ");
			System.out.println("0.Exit from ReportMangement");
			ch=sc.nextInt();
			switch (ch) {
			case 1:
				    CourseEnrollmentReport(sc);
				   
				break;
			case 2:StudentPerformanceReport ();
			break;
			case 3:InstructorPerformanceReport(sc);
			break;
			case 4:FinancialReport(sc);
			break;
			case 5:seachandFilterInstructer(sc);
			break;
			case 0: System.out.println("Thanks Admin for visit");
			break;
			default:
				break;
			}
		}while(ch!=0);
}
	private static void CourseEnrollmentReport(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void StudentPerformanceReport() {
		// TODO Auto-generated method stub
		
	}
	private static void InstructorPerformanceReport(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void FinancialReport(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void studentMenu(Scanner sc) throws SomeThingWentWrongException, NoRecordFoundException {
	// TODO Auto-generated method stub
		int ch=0;
		do {
			System.out.println("1.Add student");
			System.out.println("2.Lising student");
			System.out.println("3.Edit student");
			System.out.println("4.delete student");
			System.out.println("5.Search and Filtering: student");
			System.out.println("0.Exit from studentMangement");
			ch=sc.nextInt();
			switch (ch) {
			case 1:
				    Addstudent(sc);
				   
				break;
			case 2:ViewAllstudents();
			break;
			case 3:Editstudent(sc);
			break;
			case 4:deletestudent(sc);
			break;
			case 5:seachandFilterstudent(sc);
			break;
			case 0: System.out.println("Thanks Admin for visit");
			break;
			default:
				break;
			}
		}while(ch!=0);
}
	private static void seachandFilterstudent(Scanner sc) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		 System.out.println("Enter student ID to search:");
		    Long studentId = Long.parseLong(sc.next());
		  StudentService sts=new StudentServiceImpl();
		    Student student = sts.getStudentById(studentId);
		    if(student!=null) {
		    	System.out.println(student.toString());
		    }
	}
	private static void deletestudent(Scanner sc) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		 System.out.println("Enter student ID to delete:");
		    Long studentId = Long.parseLong(sc.next());
		    StudentService sts=new StudentServiceImpl();
		    // Delete the student using the StudentService
		    sts.deleteStudent(studentId);

		    System.out.println("Student deleted successfully!");
	}
	private static void Editstudent(Scanner sc) throws NoRecordFoundException, SomeThingWentWrongException {
		System.out.println("Enter student ID to edit:");
	    Long studentId = Long.parseLong(sc.nextLine());
	    StudentService sts=new StudentServiceImpl();
	    // Retrieve the student from the database
	    Student student = sts.getStudentById(studentId);

	    if (student != null) {
	        System.out.println("Enter updated student name:");
	        String name = sc.next();

	        System.out.println("Enter updated student email:");
	        String email = sc.next();

	        System.out.println("Enter updated student password:");
	        String password = sc.next();

	        System.out.println("Enter updated student date of birth (yyyy-MM-dd):");
	        String dateOfBirthStr = sc.next();
	        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);

	        System.out.println("Enter updated student address:");
	        String address = sc.next();

	        System.out.println("Enter updated student contact number:");
	        String contactNumber = sc.next();

	        // Update the student object with the new values
	        student.setName(name);
	        student.setEmail(email);
	        student.setPassword(password);
	        student.setDateOfBirth(dateOfBirth);
	        student.setAddress(address);
	        student.setContactNumber(contactNumber);

	        // Save the updated student using the StudentService
	        sts.updateStudent(student);

	        System.out.println("Student updated successfully!");
	    } else {
	        System.out.println("Student not found!");
	    }
		
	}
	private static void ViewAllstudents() throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		StudentService sts=new StudentServiceImpl();
		  List<Student> students = sts.getAllStudents();

		    if (!students.isEmpty()) {
		        System.out.println("List of students:");
		        for (Student student : students) {
		            System.out.println(student);
		        }
		    } else {
		        System.out.println("No students found!");
		    }
	}
	public static void Addstudent(Scanner sc) throws SomeThingWentWrongException {
		System.out.println("Enter student name:");
	    String name = sc.next();

	    System.out.println("Enter student email:");
	    String email = sc.next();

	    System.out.println("Enter student password:");
	    String password = sc.next();

	    System.out.println("Enter student date of birth (yyyy-MM-dd):");
	    String dateOfBirthStr = sc.next();
	    LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);

	    System.out.println("Enter student address:");
	    String address = sc.next();

	    System.out.println("Enter student contact number:");
	    String contactNumber = sc.next();

	    // Create a new Student object
	    Student student = new Student(name, email, password, dateOfBirth, address, contactNumber, null, true);
	    StudentService sts=new StudentServiceImpl();
	    // Add the student using the StudentService
	    sts.addStudent(student);

	    System.out.println("Student added successfully!");
		
	}
	private static void InstructerMenu(Scanner sc) {
	// TODO Auto-generated method stub
		int ch=0;
		do {
			System.out.println("1.Add Instructer");
			System.out.println("2.Lising Instructer");
			System.out.println("3.Edit Instructer");
			System.out.println("4.delete Instructer");
			System.out.println("5.Search and Filtering: Instructer");
			System.out.println("0.Exit from InstructerMangement");
			ch=sc.nextInt();
			switch (ch) {
			case 1:
				    AddInstructer(sc);
				   
				break;
			case 2:ViewAllInstructer();
			break;
			case 3:EditInstructer(sc);
			break;
			case 4:deleteInstructer(sc);
			break;
			case 5:seachandFilterInstructer(sc);
			break;
			case 0: System.out.println("Thanks Admin for visit");
			break;
			default:
				break;
			}
		}while(ch!=0);
}
	private static void AddInstructer(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void ViewAllInstructer() {
		// TODO Auto-generated method stub
		
	}
	private static void EditInstructer(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void deleteInstructer(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void seachandFilterInstructer(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	public static void courseMenu(Scanner sc) throws SomeThingWentWrongException, NoRecordFoundException {
	// TODO Auto-generated method stub
		int ch=0;
		do {
			System.out.println("1.Add Course");
			System.out.println("2.Lising Course");
			System.out.println("3.Edit Course");
			System.out.println("4.delete Course");
			System.out.println("5.Search and Filtering: Course");
			System.out.println("0.Exit from CourseMangement");
			ch=sc.nextInt();
			sc.nextLine();
			switch (ch) {
			case 1:
				    AddCourse(sc);
				   
				break;
			case 2:ViewAllCourse();
			break;
			case 3:EditCourse(sc);
			break;
			case 4:deleteCourse(sc);
			break;
			case 5:seachandFilterCourse(sc);
			break;
			case 0: System.out.println("Thanks Admin for visit");
			break;
			default:
				break;
			}
		}while(ch!=0);
	
}
	private static void AddCourse(Scanner sc) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		System.out.println("Enter Course Title");
		String title=sc.nextLine();
		System.out.println("Enter Course Description");
		String desc=sc.nextLine();
		System.out.println("Enter Course Duration (Years)");
		int duration=sc.nextInt();
		Course course=new Course(title, desc, duration);
 CourseService cs=new CourseServiceImpl();
 		cs.addCourse(course);
    System.out.println("Sucefully Added");
		
	}
	private static void ViewAllCourse() throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		CourseService cs=new CourseServiceImpl();
		List<Course> list=cs.getAllCourses();
		System.out.println(list);
	}
	private static void EditCourse(Scanner sc) throws NoRecordFoundException, SomeThingWentWrongException {
		// TODO Auto-generated method stub
		System.out.println("Enter course Id to Update");
		 Long id=sc.nextLong();
		 sc.nextLine();
		 System.out.println("Enter Course Title to update");
		 String title=sc.nextLine();
		
		 
			System.out.println("Enter Course Duration (Years) to update");
			int duration=sc.nextInt();
		 CourseService cs=new CourseServiceImpl();
		 cs.updateCourse(id, title, duration);
		 System.out.println("Updated Suceffully");
	}
	private static void deleteCourse(Scanner sc) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		System.out.println("Enter course Id to delete");
		 Long id=sc.nextLong();
		 CourseService cs=new CourseServiceImpl();
		 cs.deleteCourse(id);
		 System.out.println("Deleted SuccesFully");
	}
	private static void seachandFilterCourse(Scanner sc) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		System.out.println("Enter course Id ");
		 Long id=sc.nextLong();
		 CourseService cs=new CourseServiceImpl();
		 Course course=cs.getCourseById(id);
		 System.out.println(course.toString());
	}
	// TODO Auto-generated method stub
	  static void adminLogin(Scanner sc) throws SomeThingWentWrongException {
			System.out.print("Enter username ");
			String username = sc.next();
			System.out.print("Enter password ");
			String password = sc.next();
			if(username.equals("admin") && password.equals("admin")) {
				//adminMenu(sc);
			}else {
				System.out.println("Invalid Username of Password");
				adminLogin(sc);
			}
}
}
