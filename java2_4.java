import sun.awt.geom.AreaOp;

import java.sql.*;

public class java2_4 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select tenkhachhang from customer";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            int rowCount = 0;
            while(rset.next()) {
                String tenkhachhang = rset.getString("tenkhachhang");
                System.out.println(tenkhachhang);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
            System.out.println("SELECT id ,makhachhang, email,madonhang FROM customer WHERE tenkhachhang = 'Dang Kim Thi'");

        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}



