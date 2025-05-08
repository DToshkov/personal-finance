import java.sql.*;
import java.util.Scanner;

public class Expenses
{
   public static void main(String[] args)
   {
      Scanner kbd = new Scanner(System.in);

      try
      {
         System.out.print("Enter an int for your Expense ID: ");
         int expenseId = kbd.nextInt();

         System.out.print("Enter your User ID: ");
         int userId = kbd.nextInt();
         kbd.nextLine(); // consume newline

         System.out.print("Enter the source name: ");
         String sourceName = kbd.nextLine();

         System.out.print("Enter the expense category: ");
         String category = kbd.nextLine();

         System.out.print("Enter the date received (YYYY-MM-DD): ");
         String dateReceived = kbd.nextLine();

         System.out.print("Enter the amount: ");
         float amount = kbd.nextFloat();

         System.out.print("Enter the account deposit ID: ");
         int accountDepositId = kbd.nextInt();
         kbd.nextLine(); // consume newline

         System.out.print("Is this a recurring expense? (true/false): ");
         boolean recurring = kbd.nextBoolean();
         kbd.nextLine(); // consume newline

         System.out.print("Enter the associated account (can be blank): ");
         String associatedAccount = kbd.nextLine();

         System.out.print("Enter the vendor name: ");
         String vendor = kbd.nextLine();

         String url = "jdbc:mysql://cs.neiu.edu:3306/dtoshkov?serverTimezone=UTC&";
         url += "user=dtoshkov&password=707634dto@@X";

         Connection conn = DriverManager.getConnection(url);

         String update = "INSERT INTO Expenses VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

         PreparedStatement pstmt = conn.prepareStatement(update);
         pstmt.setInt(1, expenseId);
         pstmt.setInt(2, userId);
         pstmt.setString(3, sourceName);
         pstmt.setString(4, category);
         pstmt.setString(5, dateReceived);
         pstmt.setFloat(6, amount);
         pstmt.setInt(7, accountDepositId);
         pstmt.setBoolean(8, recurring);
         pstmt.setString(9, associatedAccount);
         pstmt.setString(10, vendor);

         pstmt.executeUpdate();

         System.out.println("Expense record inserted successfully.");
      }
      catch(SQLException ex)
      {
         ex.printStackTrace();
      }
   }
}
