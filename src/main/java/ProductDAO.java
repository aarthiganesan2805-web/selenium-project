

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;

public class ProductDAO {

    public static void insertProduct(
            String productName,
            String pageTitle,
            String productUrl,
            String cartStatus) {

        String sql = "INSERT INTO products "
                   + "(product_name, page_title, product_url, cart_status) "
                   + "VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, productName);
            ps.setString(2, pageTitle);
            ps.setString(3, productUrl);
            ps.setString(4, cartStatus);

            ps.executeUpdate();

            System.out.println("Product inserted into MySQL!");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}