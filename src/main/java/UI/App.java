package UI;

import java.util.Scanner;

import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SomeThingWentWrongException, NoRecordFoundException
    {
    	Scanner sc = new Scanner(System.in);
    	int ch=0;
    	do {
    		System.out.println("1.Administrator\r\n"
    				+ "2.Instructor/Educator\r\n"
    				+ "3.Student/Learner");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		ch=sc.nextInt();
    		 switch (ch) {
    		   case 1:AdminUI.adminMenu(sc);
    		    break;
    		   case 2:InstructerUi.InstructerMenu(sc);
    		   break;
    		   case 3:StudentUi.studentMenu(sc); 
    		   break;
    		   case 0:
    				System.out.println("Thanks for using the services");
    				break;
    		

    		default:
    			break;
    		}
    	}while(ch!=0);
    }
}
