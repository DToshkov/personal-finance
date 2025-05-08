import java.sql.*;
import java.util.Scanner;

public class Investment
{
   public static void main(String[] args)
   {
      Scanner kbd = new Scanner(System.in);

      try
      {
         System.out.print("Enter an int for your Investment ID: ");
         int investId = kbd.nextInt();

         System.out.print("Enter your User ID: ");
         int userId = kbd.nextInt();
         kbd.nextLine(); // Consume leftover newline

         System.out.print("Enter the type of investment: ");
         String type = kbd.nextLine();

         System.out.print("Enter the date of payment (YYYY-MM-DD): ");
         String date = kbd.nextLine();

         System.out.print("Enter the amount: ");
         float amount = kbd.nextFloat();

         System.out.print("Enter the account you want to deposit into: ");
         int acct = kbd.nextInt();

         String url = "jdbc:mysql://cs.neiu.edu:3306/dtoshkov?serverTimezone=UTC&";
         url += "user=dtoshkov&password=707634dto@@X";

         Connection conn = DriverManager.getConnection(url);

         String update = "INSERT INTO Investment VALUES(?, ?, ?, ?, ?, ?)";

         PreparedStatement pstmt = conn.prepareStatement(update);
         pstmt.setInt(1, investId);
         pstmt.setInt(2, userId);
         pstmt.setString(3, type);
         pstmt.setString(4, date);
         pstmt.setFloat(5, amount);
         pstmt.setInt(6, acct);

         pstmt.executeUpdate();

         System.out.println("Investment record inserted successfully.");
      }
      catch(SQLException ex)
      {
         ex.printStackTrace();
      }
   }
}
