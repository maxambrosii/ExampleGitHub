import java.sql.*;
import java.util.*;

public class CRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void InsertCreate(Connection connect) {
		try {
		Statement statement = connect.createStatement();
		
		
		
		 String strInfo = "";
		 
		 Scanner in = new Scanner(System.in);
		 Scanner inStr = new Scanner(System.in);
		 
		 String Create = "INSERT INTO `Teacher`(`Familia_Teacher`,`Name_Teacher`,`Otcestvo_Teacher`) VALUES "
			 		+ "("; 
		 
		 System.out.println("Ввод информации в таблицу Учитель...");
		 
		 System.out.print("Введите Фамилию учителя : ");
		 strInfo = inStr.nextLine();
		 Create = Create + "'" + strInfo + "'" + ",";
		 
		 System.out.print("Введите Имя учителя : ");
		 strInfo = inStr.nextLine();
		 Create = Create + "'" + strInfo + "'" + ",";
		 
		 System.out.print("Введите Отчество учителя : ");
		 strInfo = inStr.nextLine();
		 Create = Create + "'" + strInfo + "'" + ");";
		
		 statement.executeQuery(Create);
		 
		} catch(SQLException e) {
			e.printStackTrace();
			
		};
	}
	
	public static void MaxMark(Connection connect) {
		try {
			Statement statement =connect.createStatement();
			ResultSet rs = null;
			rs = statement.executeQuery("SELECT Ucenik.Familia_uc,Ucenik.Name_Uc,Ucenik.Otcestvo_uc,Jurnal.DataS,Jurnal.Ocenka_Pas \n" + 
					"From Ucenik \n" + 
					"INNER JOIN Jurnal \n" + 
					"ON Ucenik.Cod_uc=Jurnal.Cod_uc WHERE Jurnal.Ocenka_Pas <11 AND Jurnal.Ocenka_Pas > (\n" + 
					"SELECT AVG(Jurnal.Ocenka_Pas) FROM Jurnal WHERE Jurnal.Ocenka_Pas < 11 )");
			while(rs.next()) {
				System.out.format("%10s", rs.getString("Familia_uc") + " ");
				System.out.format("%10s", rs.getString("Name_uc") + " ");
				System.out.format("%10s", rs.getString("Otcestvo_uc") + " ");
				System.out.format("%10s", rs.getString("DataS") + " ");
				System.out.format("%10s", rs.getInt("Ocenka_Pas") + "\n");
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void Read(Connection connect) {
		 try {
		Statement statement = connect.createStatement();
		ResultSet rs = null;
		rs = statement.executeQuery("SELECT * FROM Teacher");
		 
		 //Read from the table
		 while(rs.next()) {
			 
			 System.out.format("%10s", rs.getInt("Cod_Teacher") + " ");
			 System.out.format("%10s", rs.getString("Familia_Teacher") + " ");
			 System.out.format("%10s", rs.getString("Name_Teacher") + " ");
			 System.out.format("%10s", rs.getString("Otcestvo_Teacher") + "\n");
		 }
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
	}
	
	public static void Update(Connection connect) {
		try {
			
			Statement statement = connect.createStatement();
			ResultSet rs = null;
			
			String Update = "UPDATE Teacher SET Name_Teacher = 'Francuz' WHERE Cod_Teacher = 30;";
			
			 
			 statement.executeQuery(Update);
			 
		} catch(SQLException e) {
			 e.printStackTrace();
		 }
	}
	//JOINS==============
	public static void LEFTJOIN(Connection connect) {
		
		ResultSet rs = null;
		try {
	    Statement statement = connect.createStatement();
		rs = statement.executeQuery("Select * From \n" + 
		 		"Class\n" + 
		 		"LEFT JOIN \n" + 
		 		"Ucenik on (Class.Cod_cl=Ucenik.Cod_cl);");
		
		while(rs.next()) {
			 System.out.format("%5s", rs.getInt("N_Cl") + " ");
			 System.out.format("%5s", rs.getString("Razdel") + " ");
			 System.out.format("%15s", rs.getString("Familia_uc") + " ");
			 System.out.format("%15s", rs.getString("Name_Uc") + " ");
			 System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
			 System.out.format("%15s", rs.getString("Data_r") + " ");
			 System.out.format("%15s", rs.getString("IDNP") + "\n");
		 }
		}catch(SQLException e) {
			 e.printStackTrace();
		 }
		}
	
public static void RIGHTJOIN(Connection connect) {
		
		ResultSet rs = null;
		try {
	    Statement statement = connect.createStatement();
		rs = statement.executeQuery("Select * From \n" + 
				"Class\n" + 
				"RIGHT JOIN \n" + 
				"Ucenik on (Class.Cod_cl=Ucenik.Cod_cl);");
		
		while(rs.next()) {
			 System.out.format("%5s", rs.getInt("N_Cl") + " ");
			 System.out.format("%5s", rs.getString("Razdel") + " ");
			 System.out.format("%15s", rs.getString("Familia_uc") + " ");
			 System.out.format("%15s", rs.getString("Name_Uc") + " ");
			 System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
			 System.out.format("%15s", rs.getString("Data_r") + " ");
			 System.out.format("%15s", rs.getString("IDNP") + "\n");
		 }
		}catch(SQLException e) {
			 e.printStackTrace();
		 }
		}
	
public static void LEFTJOINNull(Connection connect) {
	
	ResultSet rs = null;
	try {
    Statement statement = connect.createStatement();
	rs = statement.executeQuery("Select * From \n" + 
			"Class\n" + 
			"LEFT JOIN \n" + 
			"Ucenik on (Class.Cod_cl=Ucenik.Cod_cl) \n" + 
			"WHERE Ucenik.Cod_cl IS NULL;");
	
	while(rs.next()) {
		 System.out.format("%5s", rs.getInt("N_Cl") + " ");
		 System.out.format("%5s", rs.getString("Razdel") + " ");
		 System.out.format("%15s", rs.getString("Familia_uc") + " ");
		 System.out.format("%15s", rs.getString("Name_Uc") + " ");
		 System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
		 System.out.format("%15s", rs.getString("Data_r") + " ");
		 System.out.format("%15s", rs.getString("IDNP") + "\n");
	 }
	}catch(SQLException e) {
		 e.printStackTrace();
	 }
	}


public static void RIGHTJOINNull(Connection connect) {
	
	ResultSet rs = null;
	try {
    Statement statement = connect.createStatement();
	rs = statement.executeQuery("Select * From \n" + 
			"Class\n" + 
			"RIGHT JOIN \n" + 
			"Ucenik on (Class.Cod_cl=Ucenik.Cod_cl) \n" + 
			"WHERE Ucenik.Cod_cl IS NULL;");
	
	while(rs.next()) {
		 System.out.format("%5s", rs.getInt("N_Cl") + " ");
		 System.out.format("%5s", rs.getString("Razdel") + " ");
		 System.out.format("%15s", rs.getString("Familia_uc") + " ");
		 System.out.format("%15s", rs.getString("Name_Uc") + " ");
		 System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
		 System.out.format("%15s", rs.getString("Data_r") + " ");
		 System.out.format("%15s", rs.getString("IDNP") + "\n");
	 }
	}catch(SQLException e) {
		 e.printStackTrace();
	 }
	}
	

public static void FullOuterJOIN(Connection connect) {
	
	ResultSet rs = null;
	try {
    Statement statement = connect.createStatement();
	rs = statement.executeQuery("Select * From \n" + 
			"Class\n" + 
			"LEFT JOIN \n" + 
			"Ucenik on (Class.Cod_cl=Ucenik.Cod_cl)\n" + 
			"UNION\n" + 
			"Select * From \n" + 
			"Class\n" + 
			"RIGHT JOIN \n" + 
			"Ucenik on (Class.Cod_cl=Ucenik.Cod_cl);");
	
	while(rs.next()) {
		 System.out.format("%5s", rs.getInt("N_Cl") + " ");
		 System.out.format("%5s", rs.getString("Razdel") + " ");
		 System.out.format("%15s", rs.getString("Familia_uc") + " ");
		 System.out.format("%15s", rs.getString("Name_Uc") + " ");
		 System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
		 System.out.format("%15s", rs.getString("Data_r") + " ");
		 System.out.format("%15s", rs.getString("IDNP") + "\n");
	 }
	}catch(SQLException e) {
		 e.printStackTrace();
	 }
	}

public static void FullOuterJOINnull(Connection connect) {
	
	ResultSet rs = null;
	try {
    Statement statement = connect.createStatement();
	rs = statement.executeQuery("Select * From \n" + 
			"Class\n" + 
			"LEFT JOIN \n" + 
			"Ucenik on (Class.Cod_cl=Ucenik.Cod_cl) \n" + 
			"WHERE Ucenik.Cod_cl IS NULL\n" + 
			"UNION\n" + 
			"Select * From \n" + 
			"Class\n" + 
			"RIGHT JOIN \n" + 
			"Ucenik on (Class.Cod_cl=Ucenik.Cod_cl) \n" + 
			"WHERE Ucenik.Cod_cl IS NULL;");
	
	while(rs.next()) {
		 System.out.format("%5s", rs.getInt("N_Cl") + " ");
		 System.out.format("%5s", rs.getString("Razdel") + " ");
		 System.out.format("%15s", rs.getString("Familia_uc") + " ");
		 System.out.format("%15s", rs.getString("Name_Uc") + " ");
		 System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
		 System.out.format("%15s", rs.getString("Data_r") + " ");
		 System.out.format("%15s", rs.getString("IDNP") + "\n");
	 }
	}catch(SQLException e) {
		 e.printStackTrace();
	 }
	}


public static void InnerJOIN(Connection connect) {
	
	ResultSet rs = null;
	try {
    Statement statement = connect.createStatement();
	rs = statement.executeQuery("Select * From Class\n" + 
			"INNER JOIN \n" + 
			"Ucenik ON (Class.Cod_cl=Ucenik.Cod_cl) \n" + 
			"");
	
	while(rs.next()) {
		 System.out.format("%5s", rs.getInt("N_Cl") + " ");
		 System.out.format("%5s", rs.getString("Razdel") + " ");
		 System.out.format("%15s", rs.getString("Familia_uc") + " ");
		 System.out.format("%15s", rs.getString("Name_Uc") + " ");
		 System.out.format("%15s", rs.getString("Otcestvo_uc") + " ");
		 System.out.format("%15s", rs.getString("Data_r") + " ");
		 System.out.format("%15s", rs.getString("IDNP") + "\n");
	 }
	}catch(SQLException e) {
		 e.printStackTrace();
	 }
	}

	//=====================================
	
	public static void Delete(Connection connect) {
		try {
			
			Statement statement = connect.createStatement();
			ResultSet rs = null;
			String Delete = "Delete from `Teacher` where `Cod_Teacher` = 30; ";
			statement.executeQuery(Delete);
	
		}catch(SQLException e) {
			 e.printStackTrace();
		 }
	}

}
