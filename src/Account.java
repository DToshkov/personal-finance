import java.sql.*;
import java.util.Scanner;

public class Account
{
   public static void main(String[] args)
   {
      Scanner kbd = new Scanner(System.in);

      try
      {
         System.out.print("Enter an int for your Account ID: ");
         int accountId = kbd.nextInt();

         System.out.print("Enter your Customer ID: ");
         int customerId = kbd.nextInt();
         kbd.nextLine(); // Consume leftover newline

         System.out.print("Enter the opening date (YYYY-MM-DD): ");
         String openingDate = kbd.nextLine();

         System.out.print("Enter the account sum: ");
         float accountSum = kbd.nextFloat();

         System.out.print("Enter the account APR: ");
         float accountApr = kbd.nextFloat();
         kbd.nextLine(); // Consume leftover newline

         System.out.print("Enter the account type: ");
         String accountType = kbd.nextLine();

         System.out.print("Enter the account routing number: ");
         int accountRouting = kbd.nextInt();

         System.out.print("Enter the account number: ");
         int accountNumber = kbd.nextInt();
         kbd.nextLine(); // Consume leftover newline

         System.out.print("Enter the bank name: ");
         String accountBank = kbd.nextLine();

         String url = "jdbc:mysql://cs.neiu.edu:3306/dtoshkov?serverTimezone=UTC&";
         url += "user=dtoshkov&password=707634dto@@X";

         Connection conn = DriverManager.getConnection(url);

         String update = "INSERT INTO Account VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

         PreparedStatement pstmt = conn.prepareStatement(update);
         pstmt.setInt(1, accountId);
         pstmt.setInt(2, customerId);
         pstmt.setString(3, openingDate);
         pstmt.setFloat(4, accountSum);
         pstmt.setFloat(5, accountApr);
         pstmt.setString(6, accountType);
         pstmt.setInt(7, accountRouting);
         pstmt.setInt(8, accountNumber);
         pstmt.setString(9, accountBank);

         pstmt.executeUpdate();

         System.out.println("Account record inserted successfully.");
      }
      catch(SQLException ex)
      {
         ex.printStackTrace();
      }
   }
}
