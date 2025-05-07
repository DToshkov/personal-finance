package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Income {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        try {
            System.out.print("Enter an int for your Income ID: ");
            int incomeId = kbd.nextInt();

            System.out.print("Enter your User ID: ");
            int userId = kbd.nextInt();
            kbd.nextLine(); // Consume leftover newline

            System.out.print("Enter the source of the income: ");
            String category = kbd.nextLine();

            System.out.print("Enter the date of payment (YYYY-MM-DD): ");
            String date = kbd.nextLine();

            System.out.print("Enter the amount: ");
            float amount = kbd.nextFloat();

            System.out.print("Enter the account you want to deposit into: ");
            int acct = kbd.nextInt();

            String url = "jdbc:mysql://cs.neiu.edu:3306/dtoshkov?serverTimezone=UTC&user=dtoshkov&password=707634dto@@X";

            Connection conn = DriverManager.getConnection(url);

            String sql = "INSERT INTO Income (income_id, user_id, category, payment_date, amount, account_id) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, incomeId);
            pstmt.setInt(2, userId);
            pstmt.setString(3, category);
            pstmt.setString(4, date);
            pstmt.setFloat(5, amount);
            pstmt.setInt(6, acct);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Income record inserted successfully.");
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

