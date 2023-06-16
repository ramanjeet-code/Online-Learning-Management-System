package UI;

import java.util.Scanner;

import Exception.SomeThingWentWrongException;

public class AdminUI {

	public AdminUI() {
		// TODO Auto-generated constructor stub
	}
public static void adminMenu(Scanner sc) throws SomeThingWentWrongException {
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
	private static void studentMenu(Scanner sc) {
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
	private static void seachandFilterstudent(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void deletestudent(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void Editstudent(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	private static void ViewAllstudents() {
		// TODO Auto-generated method stub
		
	}
	private static void Addstudent(Scanner sc) {
		// TODO Auto-generated method stub
		
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
