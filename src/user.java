// updating the user table with terminal based user interaction 
// dimitar toshkov rights reserved 2025 

import java.sql.*;
import java.util.Scanner;

public class user
{
   public static void main(String[] args)
   {
   
      Scanner kbd = new Scanner(System.in);
      try
      {
         System.out.print("Enter an int for your User ID: ");
         int userId = kbd.nextInt();
         
         System.out.print("Enter your First Name ");
         String firstName = kbd.nextLine();

         
         System.out.print("Enter your Last Name ");
         String lastName = kbd.nextLine();

         
         System.out.print("Enter your Street Name ");
         String streetName = kbd.nextLine();
         
         System.out.print("Enter your Zip code ");
         String zip = kbd.nextLine();

                  
         System.out.print("Enter your Phone number ");
         int phone = kbd.nextInt();

                  
         System.out.print("Enter your email address ");
         String email = kbd.nextLine();

                  
         System.out.print("Enter your passport number, driver id number, or ID number");
         String idDocument = kbd.nextLine();

         
         
         
         String url = "jdbc:mysql://cs.neiu.edu:3306/dtoshkov?serverTimezone=UTC&";
         url += "user=dtoshkov&password=707634dto@@X";

         
         Connection conn = DriverManager.getConnection(url);
         
         Statement stmt = conn.createStatement();
         
         String update = "INSERT INTO User_Details VALUES(" + userId + ", " + firstName + ", " + lastName + ", " + streetName + ", " + zip + ", " + phone + ", " +  email + ", " + idDocument + "')";
         
         
         stmt.executeUpdate(update);
         

      }
      catch(SQLException ex)
      {
         ex.printStackTrace();
      }
   }
}
