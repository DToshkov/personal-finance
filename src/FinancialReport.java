import java.sql.*;
import java.util.Scanner;

public class FinancialReport
{
   public static void main(String[] args)
   {
      Scanner kbd = new Scanner(System.in);

      try
      {
         System.out.print("Enter the User ID to generate the financial report: ");
         int userId = kbd.nextInt();

         String url = "jdbc:mysql://cs.neiu.edu:3306/dtoshkov?serverTimezone=UTC&";
         url += "user=dtoshkov&password=707634dto@@X";

         Connection conn = DriverManager.getConnection(url);

         // Get account information
         String accountQuery = "SELECT account_id, account_sum, account_type, account_bank FROM Account WHERE customer_id = ?";
         PreparedStatement acctStmt = conn.prepareStatement(accountQuery);
         acctStmt.setInt(1, userId);
         ResultSet acctRs = acctStmt.executeQuery();

         System.out.println("\n--- CUSTOMER FINANCIAL REPORT ---");
         System.out.println("Accounts:");
         float totalAccountBalance = 0;
         while (acctRs.next()) {
            int accountId = acctRs.getInt("account_id");
            float sum = acctRs.getFloat("account_sum");
            String type = acctRs.getString("account_type");
            String bank = acctRs.getString("account_bank");

            totalAccountBalance += sum;
            System.out.printf("  - [%d] %s at %s: $%.2f\n", accountId, type, bank, sum);
         }

         // Get total income
         String incomeQuery = "SELECT SUM(amount) AS total_income FROM Income WHERE user_id = ?";
         PreparedStatement incomeStmt = conn.prepareStatement(incomeQuery);
         incomeStmt.setInt(1, userId);
         ResultSet incomeRs = incomeStmt.executeQuery();
         float totalIncome = 0;
         if (incomeRs.next()) {
            totalIncome = incomeRs.getFloat("total_income");
         }

         // Get total expenses
         String expenseQuery = "SELECT SUM(amount) AS total_expenses FROM Expenses WHERE user_id = ?";
         PreparedStatement expenseStmt = conn.prepareStatement(expenseQuery);
         expenseStmt.setInt(1, userId);
         ResultSet expenseRs = expenseStmt.executeQuery();
         float totalExpenses = 0;
         if (expenseRs.next()) {
            totalExpenses = expenseRs.getFloat("total_expenses");
         }

         // Get total investments (optional)
         String investQuery = "SELECT SUM(amount) AS total_invest FROM Investment WHERE user_id = ?";
         PreparedStatement investStmt = conn.prepareStatement(investQuery);
         investStmt.setInt(1, userId);
         ResultSet investRs = investStmt.executeQuery();
         float totalInvestment = 0;
         if (investRs.next()) {
            totalInvestment = investRs.getFloat("total_invest");
         }

         float netBalance = totalIncome - totalExpenses;

         System.out.println("\nSummary:");
         System.out.printf("  Total Income:      $%.2f\n", totalIncome);
         System.out.printf("  Total Expenses:    $%.2f\n", totalExpenses);
         System.out.printf("  Net Balance:       $%.2f\n", netBalance);
         System.out.printf("  Total Account Bal: $%.2f\n", totalAccountBalance);
         System.out.printf("  Total Investment:  $%.2f\n", totalInvestment);

         System.out.println("\n---------------------------------");

         conn.close();
      }
      catch (SQLException ex)
      {
         ex.printStackTrace();
      }
   }
}
