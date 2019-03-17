import java.sql.*;
import java.util.*;

public class Main extends CRUD {
	
	public static void clearScreen() {  
		for(int i = 0; i < 80*300; i++) // Default Height of cmd is 300 and Default width is 80
		    System.out.println("\b"); // Prints a backspace
	} 

	public static void main(String[] args) {
		 
		 Connection connect = null;
		 Statement statement = null;
		 ResultSet rs = null;
		 int answer = 90;
		 
		 Scanner in = new Scanner(System.in);
		 
		 try {
			 //Connection on server PHPMyAdmin
			 connect = DriverManager.getConnection("jdbc:mariadb://192.168.64.2/School", "MaxDB", "localhostdb");
			 statement = connect.createStatement();
			
		 
		    //Menu in terminal. Choose the operation
			
			 do {
				
				 System.out.println("1 - Create \n"
				 +"2 - Retrive/Read \n" 
				 +"3 - Update \n"
				 +"4 - Delete \n"
				 +"5 - LEFT JOIN \n"
				 +"6 - RIGHT JOIN \n"
				 +"7 - Exclude LEFT JOIN \n"
				 +"8 - Exclude RIGHT JOIN \n"
				 +"9 - FULL OUTER JOIN \n"
				 +"10 - Exclude FULL OUTER JOIN \n"
				 +"11 - Inner Join \n"
				 +"12 - Max Marks\n"
				 +"0 - Exit");
				
				 
				 System.out.print("Choose the operation : ");
				   
				 // Защита от дурака 
				 do {
					   
			      answer = in.nextInt();
			      
			       if (answer < 0 || answer > 12) System.out.println(answer + " Не входит в список функций! "
			       		+ "Повторите ввод: ");
			     
				   }while(answer < 0 || answer > 12 );
				 // Выбор функций
				 switch (answer) {
				 
				 case 1: 
				 {
					 clearScreen();
					 InsertCreate(connect);
				     System.out.println("Запись успешно добавлена!"); 
				 };
					 break;
				 
				 case 2: 
				 {
					 clearScreen();
					 Read(connect); 
					 System.out.println("Данные успешно выведены!");
					 
				 };
				     break;
				 case 3: 
				 {
					 clearScreen();
					 Update(connect);
					 System.out.println("Данные успешно изменены!");
				 };
				     break;
				 
				 case 4: 
				 {
					 clearScreen();
					 Delete(connect);
					 System.out.println("Данные успешно удалены!");
				 };
					 break;
				 
				 case 5: {
					 clearScreen();
					LEFTJOIN(connect);
				 }; break;
				 
				 case 6: {
					 clearScreen();
					RIGHTJOIN(connect);
					 
				 }; break;
				 
				 case 7: {
					 clearScreen();
					 LEFTJOINNull(connect);
					 
				 }; break;
				 
				 case 8: {
					 clearScreen();
					 RIGHTJOINNull(connect);
					 
				 }; break;
				 
				 case 9: {
					 clearScreen();
					 FullOuterJOIN(connect);
					 
				 }; break;
				 
				 case 10: {
					 clearScreen();
					 FullOuterJOINnull(connect);
					 
				 }; break;
				 
				 case 11: {
					 clearScreen();
					 InnerJOIN(connect);
					 
				 }; break;
				 
				 case 12:{
					 clearScreen();
					 MaxMark(connect);
					 
				 }
				 
				 }
				 
				 
			 } while (answer != 0);
			 
			 
		 }catch(SQLException e) {
			  e.printStackTrace();

		 } finally {     //Close objects
	            try {
	                if (rs != null)
	                    rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            try {
	                if (statement != null)
	                    statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            try {
	                if (connect != null)
	                    connect.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		 
 
	}

}
