import java.sql.*;
import java.util.Scanner;

public class main
{
   public static void main(String[] args)
   {
   
      Scanner kbd = new Scanner(System.in);
      try
      {
         System.out.print("Enter the name: ");
         String name = kbd.nextLine();
         
         System.out.print("Enter an int for ID: ");
         int id = kbd.nextInt();
         
         String url = "jdbc:mysql://cs.neiu.edu:3306/dtoshkov?serverTimezone=UTC&";
         url += "user=dtoshkov&password=707634dto@@X";

         System.out.println("connect successful");
         Connection conn = DriverManager.getConnection(url);
         
         Statement stmt = conn.createStatement();
         
         String update = "INSERT INTO Student2 VALUES(" + id + ", '" + name + "')";
         
         System.out.print("Enter the name: ");
         String name = kbd.nextLine();
         
         System.out.print("Enter an int for ID: ");
         int id = kbd.nextInt();
         
         String url = "jdbc:mysql://cs.neiu.edu:3306/dtoshkov?serverTimezone=UTC&";
         url += "user=dtoshkov&password=707634dto@@X";

         System.out.println("connect successful");
         Connection conn = DriverManager.getConnection(url);
         
         Statement stmt = conn.createStatement();
         
         String update = "INSERT INTO Student2 VALUES(" + id + ", '" + name + "')";
         
         stmt.executeUpdate(update);
         

      }
      catch(SQLException ex)
      {
         ex.printStackTrace();
      }
   }
}
