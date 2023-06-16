package UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Entity.Student;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;
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
	System.out.println("1.Manage Course");
	System.out.println("2.Manage Instructer");
	System.out.println("3.Manage students");
	System.out.println("4.Generate Reports");
	System.out.println("0.Exit");
	ch=sc.nextInt();
	switch(ch) {
	case 1:
	     courseMenu(sc);
	     break;
	case 2: InstructerMenu(sc);
				break;
	case 3:studentMenu(sc);
				break;
	case 4:
		 RepoartsMenu(sc);
		 break;
	case 0: System.out.println("Thanks Admin for visit");
	  break;
	  default :
		  System.out.println("INvalid Keyword");
		 
	}
	}while(ch!=0);
	
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
	private static void Addstudent(Scanner sc) throws SomeThingWentWrongException {
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
	private static void courseMenu(Scanner sc) {
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
	private static void AddCourse(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void ViewAllCourse() {
		// TODO Auto-generated method stub
		
	}
	private static void EditCourse(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void deleteCourse(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void seachandFilterCourse(Scanner sc) {
		// TODO Auto-generated method stub
		
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
