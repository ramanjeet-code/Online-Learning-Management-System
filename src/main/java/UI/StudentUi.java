package UI;

import java.util.Scanner;

import Entity.Instructor;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;
import Service.AssignementService;
import Service.AssignementServiceImpl;
import Service.GradeService;
import Service.GradeServiceImpl;
import Service.LessionService;
import Service.LessionServiceImpl;
import Service.StudentService;
import Service.StudentServiceImpl;

public class StudentUi {

	public StudentUi() {
		// TODO Auto-generated constructor stub
	}

	public static void studentMenu(Scanner sc) throws SomeThingWentWrongException, NoRecordFoundException {
		int ch=0;
		do {
		System.out.println("1.Register for student");
		System.out.println("2. Login for Student");
		System.out.println("0. Go To back");
		ch=sc.nextInt();
		switch(ch) {
		case 1:
			AdminUI.Addstudent(sc);
			 break;
		case 2:
			 StudentLogin(sc);
			 break;
		case 3:
			System.out.println("thanks for visiting");
			break;
			 default:
				 System.out.println("Invalid Keyword");
				 break;
		}
		}while(ch!=0);
		
		
	}

	


	private static void StudentLogin(Scanner sc) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub

	    System.out.println("Enter student email:");
	    String email = sc.next();

	    System.out.println("Enter student password:");
	    String password = sc.next();
	    StudentService sts=new StudentServiceImpl();
	    sts.login(email, password);
	    System.out.println("Login SuccesFullty");
	    StudentSection(sc);
	}

	private static void StudentSection(Scanner sc) throws SomeThingWentWrongException {
		LessionService lessonService = new LessionServiceImpl();
		  AssignementService assignementService = new AssignementServiceImpl();
		  GradeService gradeService=new GradeServiceImpl();

		int ch=0;
		do {
		System.out.println("1 View Lesson");
		System.out.println("2. View Assigements");
		System.out.println("3. Check Grade");
		System.out.println("0. go back->");
		ch=sc.nextInt();
		switch(ch) {
		case 1:
			InstructerUi.getLessonsByCourse(sc, lessonService);
			 break;
		case 2:
			InstructerUi.getAssignementById(sc, assignementService);
			 break;
		case 3:
			InstructerUi.getGradesByStudent(sc, gradeService);
		case 0:
			System.out.println("thanks for visiting");
			break;
			 default:
				 System.out.println("Invalid Keyword");
				 break;
		}
		}while(ch!=0);
		
	}

}
