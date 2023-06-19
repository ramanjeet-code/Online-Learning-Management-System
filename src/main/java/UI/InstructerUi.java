package UI;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Entity.Assignment;
import Entity.Course;
import Entity.Enrollment;
import Entity.Grade;
import Entity.Instructor;
import Entity.Lesson;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;
import Service.AssignementService;
import Service.AssignementServiceImpl;
import Service.CourseService;
import Service.CourseServiceImpl;
import Service.EnrollmentService;
import Service.EnrollmentServiceImpl;
import Service.GradeService;
import Service.GradeServiceImpl;
import Service.InstructerService;
import Service.InstructerServiceImpl;
import Service.LessionService;
import Service.LessionServiceImpl;

public class InstructerUi {

	public InstructerUi() {
		// TODO Auto-generated constructor stub
	}

	public static void InstructerMenu(Scanner sc) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
//		 Instructor instructor = registerInstructor(sc);
		int ch=0;
		do {
		System.out.println("1.Register for Instructer");
		System.out.println("2. Login for Instructer");
		System.out.println("3. Go To back");
		ch=sc.nextInt();
		sc.nextLine();
		switch(ch) {
		case 1:
			 Instructor instructor = registerInstructor(sc);
			 break;
		case 2:
			 InstructerLogin(sc);
			 break;
			 default:
				 System.out.println("Invalid Keyword");
				 break;
		}
		}while(ch!=3);
		
		 
	}

	private static void InstructerLogin(Scanner sc) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		 System.out.println("Enter instructor email:");
		    String email = sc.nextLine();

		    System.out.println("Enter instructor password:");
		    String password = sc.nextLine();
		    InstructerService istService=new InstructerServiceImpl();
		    istService.login(email, password);
		    System.out.println("Login SuccesFully");
		    InstructerSection(sc,email);
	}

	private static void InstructerSection(Scanner sc,String email) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		int ch=0;
		do {
		System.out.println("1. Grade Section");
		System.out.println("2.  Lessons section");
		System.out.println("3. Assignment Section");
		System.out.println("4. Go To back-->");
		ch=sc.nextInt();
		switch(ch) {
		case 1:
			   GradeMenu(sc);
			 break;
		case 2:
			 LessonMenu(sc);
			 break;
		case 3:
			AssignmentMenu(sc);
			break; 
		case 4:
			 System.out.println("Thanks For Visiting Instructer"+email);
			 default:
				 System.out.println("Invalid Keyword");
				 break;
		}
		}while(ch!=4);
	}

	private static void AssignmentMenu(Scanner sc) {
		int ch = 0;
	    AssignementService assignementService = new AssignementServiceImpl();

	    do {
	        System.out.println("1. Create Assignment");
	        System.out.println("2. Get Assignment by ID");
	        System.out.println("3. Get All Assignments");
	        System.out.println("4. Update Assignment");
	        System.out.println("5. Delete Assignment");
	        System.out.println("6. Go Back");

	        System.out.print("Enter your choice: ");
	        ch = sc.nextInt();
	        sc.nextLine(); // Consume newline character

	        switch (ch) {
	            case 1:
	                createAssignement(sc, assignementService);
	                break;
	            case 2:
	                getAssignementById(sc, assignementService);
	                break;
	            case 3:
	                getAllAssignements(assignementService);
	                break;
	            case 4:
	                updateAssignement(sc, assignementService);
	                break;
	            case 5:
	                deleteAssignement(sc, assignementService);
	                break;
	            case 6:
	                System.out.println("Returning to previous menu...");
	                break;
	            default:
	                System.out.println("Invalid choice! Please try again.");
	                break;
	        }
	    } while (ch != 6);
	}

	private static void deleteAssignement(Scanner sc, AssignementService assignementService) {
		System.out.println("Deleting an assignment...");

	    // Get input from user
	    System.out.print("Enter assignment ID: ");
	    Long assignmentId = sc.nextLong();
	    sc.nextLine(); // Consume newline character

	    // Delete the assignment
	    try {
	        assignementService.deleteAssignement(assignmentId);
	        System.out.println("Assignment deleted successfully.");
	    } catch (SomeThingWentWrongException e) {
	        System.out.println("Something went wrong. Failed to delete assignment.");
	    }
		
	}

	private static void updateAssignement(Scanner sc, AssignementService assignementService) {
		  System.out.println("Updating an assignment...");

		    // Get input from user
		    System.out.print("Enter assignment ID: ");
		    Long assignmentId = sc.nextLong();
		    sc.nextLine(); // Consume newline character

		    // Retrieve the assignment by ID
		    try {
		        Assignment assignment = assignementService.getAssignementById(assignmentId);
		        if (assignment == null) {
		            System.out.println("Assignment not found.");
		            return;
		        }

		        // Prompt the user for updated details

		        System.out.print("Enter to update assignment : deadLine date");
		        String deadlineStr = sc.nextLine();
			    LocalDate deadline = LocalDate.parse(deadlineStr);
		        // Update the assignment
		     assignment.setDeadline(deadline);

		        // Save the updated assignment
		        assignementService.updateAssignement(assignment);

		        System.out.println("Assignment updated successfully.");
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Something went wrong. Failed to update assignment.");
		    }
		
	}

	private static void getAllAssignements(AssignementService assignementService) {
		 System.out.println("Fetching all assignments...");

		    try {
		        List<Assignment> assignments = assignementService.getAllAssignements();
		        System.out.println("Assignments:");
		        for (Assignment assignment : assignments) {
		            System.out.println(assignment);
		        }
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Something went wrong. Failed to fetch assignments.");
		    }
		
	}

	public static void getAssignementById(Scanner sc, AssignementService assignementService) {
		  System.out.println("Fetching assignment by ID...");

		    // Get input from user
		    System.out.print("Enter assignment ID: ");
		    Long assignmentId = sc.nextLong();
		    sc.nextLine(); // Consume newline character

		    try {
		        Assignment assignment = assignementService.getAssignementById(assignmentId);
		        if (assignment != null) {
		            System.out.println("Assignment details:");
		            System.out.println(assignment);
		        } else {
		            System.out.println("Assignment not found.");
		        }
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Something went wrong. Failed to fetch assignment.");
		    }
		
	}

	private static void createAssignement(Scanner sc, AssignementService assignementService) {
		 System.out.println("Creating a new assignment...");

		    // Get input from user
		    System.out.print("Enter course ID: ");
		    Long courseId = sc.nextLong();
		    sc.nextLine(); // Consume newline character

		    System.out.print("Enter assignment title: ");
		    String title = sc.nextLine();

		    System.out.print("Enter start date (YYYY-MM-DD): ");
		    String startDateStr = sc.nextLine();
		    LocalDate startDate = LocalDate.parse(startDateStr);

		    System.out.print("Enter deadline (YYYY-MM-DD): ");
		    String deadlineStr = sc.nextLine();
		    LocalDate deadline = LocalDate.parse(deadlineStr);
		    CourseService cst=new  CourseServiceImpl();
		    // Create the assignment
		    try {
		        Course course = cst.getCourseById(courseId); // Assuming a method to fetch course by ID exists
		        Assignment assignment = new Assignment(course, title, startDate, deadline);
		        assignementService.createAssignement(assignment);
		        System.out.println("Assignment created successfully.");
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Something went wrong. Assignment creation failed.");
		    }
		
	}

	private static void LessonMenu(Scanner sc) throws SomeThingWentWrongException {
		LessionService lessonService = new LessionServiceImpl(); // Instantiate the LessionService

	    boolean exit = false;
	    while (!exit) {
	        System.out.println("Lesson Menu");
	        System.out.println("1. Create Lesson");
	        System.out.println("2. Update Lesson");
	        System.out.println("3. Delete Lesson");
	        System.out.println("4. Get Lesson by ID");
	        System.out.println("5. Get All Lessons");
	        System.out.println("6. Get Lessons by Course");
	        System.out.println("7. Get Lesson Count");
	        System.out.println("0. Exit");

	        System.out.print("Enter your choice: ");
	        int choice = sc.nextInt();
	        sc.nextLine(); // Consume newline character

	        switch (choice) {
	            case 1:
	                createLesson(sc, lessonService);
	                break;
	            case 2:
	                updateLesson(sc, lessonService);
	                break;
	            case 3:
	                deleteLesson(sc, lessonService);
	                break;
	            case 4:
	                getLessonById(sc, lessonService);
	                break;
	            case 5:
	                getAllLessons(lessonService);
	                break;
	            case 6:
	                getLessonsByCourse(sc, lessonService);
	                break;
	            case 7:
	                getLessonCount(lessonService);
	                break;
	            case 0:
	                exit = true;
	                System.out.println("Exiting Lesson Menu. Goodbye!");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    }
		
	}

	private static void getLessonCount(LessionService lessonService) {
		System.out.println("Getting lesson count...");

	    try {
	        // Call the service to get the lesson count
	        int count = lessonService.getLessonCount();
	        System.out.println("Lesson count: " + count);
	    } catch (SomeThingWentWrongException e) {
	        System.out.println("Something went wrong: " + e.getMessage());
	    }
		
	}

	public static void getLessonsByCourse(Scanner sc, LessionService lessonService) throws SomeThingWentWrongException {
		System.out.println("Getting lessons by course...");

	    // Get input from user
	    System.out.print("Enter course ID: ");
	    Long courseId = sc.nextLong();
	    sc.nextLine(); // Consume newline character
	    CourseService cst=new CourseServiceImpl(); 
	    // Retrieve the course object based on courseId
	    Course course = cst.getCourseById(courseId);
	    if (course == null) {
	        System.out.println("Course not found!");
	        return;
	    }

	    try {
	        // Call the service to get lessons by course
	        List<Lesson> lessons = lessonService.getLessonsByCourse(courseId);
	        if (!lessons.isEmpty()) {
	            for (Lesson lesson : lessons) {
	                System.out.println(lesson);
	            }
	        } else {
	            System.out.println("No lessons found for the course!");
	        }
	    } catch (SomeThingWentWrongException e) {
	        System.out.println("Something went wrong: " + e.getMessage());
	    }
	}

	private static void getAllLessons(LessionService lessonService) {
		 System.out.println("Getting all lessons...");

		    try {
		        // Call the service to get all lessons
		        List<Lesson> lessons = lessonService.getAllLessons();
		        for (Lesson lesson : lessons) {
		            System.out.println(lesson);
		        }
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Something went wrong: " + e.getMessage());
		    }
		
	}

	private static void getLessonById(Scanner sc, LessionService lessonService) {
		  System.out.println("Getting lesson by ID...");

		    // Get input from user
		    System.out.print("Enter lesson ID: ");
		    int lessonId = sc.nextInt();
		    sc.nextLine(); // Consume newline character

		    try {
		        // Call the service to get the lesson by ID
		        Lesson lesson = lessonService.getLessonById(lessonId);
		        if (lesson != null) {
		            System.out.println(lesson);
		        } else {
		            System.out.println("Lesson not found!");
		        }
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Something went wrong: " + e.getMessage());
		    }
		
	}

	private static void deleteLesson(Scanner sc, LessionService lessonService) {
		System.out.println("Deleting a lesson...");

	    // Get input from user
	    System.out.print("Enter lesson ID: ");
	    int lessonId = sc.nextInt();
	    sc.nextLine(); // Consume newline character

	    try {
	        // Call the service to delete the lesson
	        lessonService.deleteLesson(lessonId);
	        System.out.println("Lesson deleted successfully!");
	    } catch (SomeThingWentWrongException e) {
	        System.out.println("Something went wrong: " + e.getMessage());
	    }
	}

	private static void updateLesson(Scanner sc, LessionService lessonService) throws SomeThingWentWrongException {
		  System.out.println("Updating a lesson...");

		    // Get input from user
		    System.out.print("Enter lesson ID: ");
		    int lessonId = sc.nextInt();
		    sc.nextLine(); // Consume newline character

		    // Retrieve the lesson object based on lessonId
		    Lesson lesson = lessonService.getLessonById(lessonId);
		    if (lesson == null) {
		        System.out.println("Lesson not found!");
		        return;
		    }

		    System.out.print("Enter new lesson title: ");
		    String title = sc.nextLine();

		    System.out.print("Enter new lesson content: ");
		    String content = sc.nextLine();

		    // Update the lesson object
		    lesson.setTitle(title);
		    lesson.setContent(content);

		    try {
		        // Call the service to update the lesson
		        lessonService.updateLesson(lesson);
		        System.out.println("Lesson updated successfully!");
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Something went wrong: " + e.getMessage());
		    }		
	}

	private static void createLesson(Scanner sc, LessionService lessonService) throws SomeThingWentWrongException {
		System.out.println("Creating a lesson...");

	    // Get input from user
	    System.out.print("Enter course ID: ");
	    Long courseId = sc.nextLong();
	    sc.nextLine(); // Consume newline character
	    CourseService cst=new CourseServiceImpl(); 
	    // Retrieve the course object based on courseId
	    Course course = cst.getCourseById(courseId);
	    if (course == null) {
	        System.out.println("Course not found!");
	        return;
	    }

	    System.out.print("Enter lesson title: ");
	    String title = sc.nextLine();

	    System.out.print("Enter lesson content: ");
	    String content = sc.nextLine();

	    // Create the lesson object
	    Lesson lesson = new Lesson(course, title, content);

	    try {
	        // Call the service to create the lesson
	        lessonService.createLesson(lesson);
	        System.out.println("Lesson created successfully!");
	    } catch (SomeThingWentWrongException e) {
	        System.out.println("Something went wrong: " + e.getMessage());
	    }
		
	}

	private static void GradeMenu(Scanner sc) {
		boolean exit = false;
		 GradeService gradeService=new GradeServiceImpl();
	    while (!exit) {
	        System.out.println("Grade Menu:");
	        System.out.println("1. Add Grade");
	        System.out.println("2. Update Grade");
	        System.out.println("3. Delete Grade");
	        System.out.println("4. Get Grade by ID");
	        System.out.println("5. Get Grades by Student ID");
	        System.out.println("6. Get Grades by Course ID");
	        System.out.println("7. Get Average Grade for Course");
	        System.out.println("8. Exit");
	        System.out.print("Enter your choice: ");
	        int choice = sc.nextInt();
	        sc.nextLine(); // Consume newline character

	        switch (choice) {
	            case 1:
	                addGrade(sc, gradeService);
	                break;
	            case 2:
	                updateGrade(sc, gradeService);
	                break;
	            case 3:
	                deleteGrade(sc, gradeService);
	                break;
	            case 4:
	                getGradeById(sc, gradeService);
	                break;
	            case 5:
	                getGradesByStudent(sc, gradeService);
	                break;
	            case 6:
	                getGradesByCourse(sc, gradeService);
	                break;
	            case 7:
	                getAverageGradeForCourse(sc, gradeService);
	                break;
	            case 8:
	                exit = true;
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	                break;
	        }

	        System.out.println();
	    }
		
	}

	

	private static void getAverageGradeForCourse(Scanner sc, GradeService gradeService) {
		 System.out.println("Calculating the average grade for a course...");

		    // Get input from user
		    System.out.print("Enter course ID: ");
		    Long courseId = sc.nextLong();
		    sc.nextLine(); // Consume newline character

		    // Calculate the average grade for the course
		    try {
		        double averageGrade = gradeService.getAverageGradeForCourse(courseId);
		        System.out.println("Average grade for the course: " + averageGrade);
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Something went wrong. Failed to calculate the average grade.");
		    }
		
	}

	private static void getGradesByCourse(Scanner sc, GradeService gradeService) {
		// TODO Auto-generated method stub
		
	}

	public static void getGradesByStudent(Scanner sc, GradeService gradeService) {
		System.out.println("Getting grades by student...");

	    // Get input from user
	    System.out.print("Enter student ID: ");
	    Long studentId = sc.nextLong();
	    sc.nextLine(); // Consume newline character

	    try {
	        // Call the service to get grades by student
	        List<Grade> grades = gradeService.getGradesByStudent(studentId);
	        if (!grades.isEmpty()) {
	            for (Grade grade : grades) {
	                System.out.println(grade);
	            }
	        } else {
	            System.out.println("No grades found for the student!");
	        }
	    } catch (SomeThingWentWrongException e) {
	        System.out.println("Something went wrong: " + e.getMessage());
	    }
	}

	private static void getGradeById(Scanner sc, GradeService gradeService) {
		// TODO Auto-generated method stub
		
	}

	private static void deleteGrade(Scanner sc, GradeService gradeService) {
		System.out.println("Deleting a grade...");

	    // Get input from user
	    System.out.print("Enter grade ID: ");
	    Long gradeId = sc.nextLong();
	    sc.nextLine(); // Consume newline character

	    // Delete the grade
	    try {
	        gradeService.deleteGrade(gradeId);
	        System.out.println("Grade deleted successfully.");
	    } catch (SomeThingWentWrongException e) {
	        System.out.println("Something went wrong. Failed to delete grade.");
	    }
		
	}

	private static void updateGrade(Scanner sc, GradeService gradeService) {
		 System.out.println("Updating a grade...");

		    // Get input from user
		    System.out.print("Enter grade ID: ");
		    Long gradeId = sc.nextLong();
		    sc.nextLine(); // Consume newline character

		    // Get the existing grade
		    try {
		        Grade grade = gradeService.getGradeById(gradeId);

		        // Get updated input from user
		        System.out.print("Enter new score: ");
		        int score = sc.nextInt();
		        sc.nextLine(); // Consume newline character

		        // Update the grade
		        grade.setScore(score);
		        gradeService.updateGrade(grade);

		        System.out.println("Grade updated successfully.");
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Something went wrong. Failed to update grade.");
		    }
		
	}

	private static void addGrade(Scanner sc, GradeService gradeService) {
		  System.out.println("Adding a new grade...");

		    // Get input from user
		    System.out.print("Enter enrollment ID: ");
		    Long enrollmentId = sc.nextLong();
		    sc.nextLine(); // Consume newline character
		    EnrollmentService est=new EnrollmentServiceImpl();
		    // Retrieve the enrollment object
		    Enrollment enrollment;
		    try {
		        enrollment = est.getEnrollmentById(enrollmentId);
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Something went wrong. Failed to retrieve enrollment.");
		        return;
		    }

		    System.out.print("Enter score: ");
		    int score = sc.nextInt();
		    sc.nextLine(); // Consume newline character

		    // Create the grade
		    try {
		        Grade grade = new Grade(enrollment, score);
		        gradeService.addGrade(grade);
		        System.out.println("Grade added successfully.");
		    } catch (SomeThingWentWrongException e) {
		        System.out.println("Something went wrong. Grade addition failed.");
		    }
		
	}

	private static void CreateLesson(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	

	private static Instructor registerInstructor(Scanner sc) throws SomeThingWentWrongException {
		 System.out.println("Enter instructor name:");
		    String name = sc.nextLine();

		    System.out.println("Enter instructor email:");
		    String email = sc.nextLine();

		    System.out.println("Enter instructor password:");
		    String password = sc.nextLine();

		    // Create a new instance of the Instructor
		    Instructor instructor = new Instructor(name, email, password,null);
		    // Assign a course to the instructor
		    System.out.println("Enter course ID to assign to the instructor:");
		    Long courseId = sc.nextLong();
		    sc.nextLine(); // Consume the remaining newline character
		    CourseService cs=new CourseServiceImpl();
		    Course course = cs.getCourseById(courseId);
		    if (course != null) {
		        instructor.setCourse(course);
		        System.out.println("Course assigned to the instructor.");
		    } else {
		        System.out.println("Assgin Course not found. Please check the course ID.");
		    }
		    InstructerService istService=new InstructerServiceImpl();
		    istService.addInstructer(instructor);
		    System.out.println("Registration SuccesFully");
		    return instructor;
	}


}
