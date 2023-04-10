package db2;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest {

   public static void main(String[] args) throws Exception {

      // variables
      final String url = "jdbc:mysql:///table_name";
      final String user = "root";
      final String password = "root";

      // establish the connection
      Connection con = DriverManager.getConnection(url, user, password);

      // create JDBC statement object
      Statement st = con.createStatement();

      // prepare SQL query
      String query = "SELECT * FROM table_name.students;";

      // send and execute SQL query in Database software
      ResultSet rs = st.executeQuery(query);

      // process the ResultSet object
      boolean flag = false;
      while (rs.next()) {
         flag = true;
         System.out.println(rs.getString(1));
      }

      if (flag == true) {
         System.out.println("\nRecords retrieved and displayed");
      } else {
         System.out.println("Record not found");
      }

      // close JDBC objects
      rs.close();
      st.close();
      con.close();

   } 
}