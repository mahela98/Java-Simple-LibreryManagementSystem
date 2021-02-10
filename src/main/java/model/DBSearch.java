package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static model.DBConnection.conn;

public class DBSearch {
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    public ResultSet searchLogin(String UserName,String Password) {
        try {
            stmt = DBConnection.getStatementConnection();
            pstmt = conn.prepareStatement("select * from users where email = ? AND password= ?");
            pstmt.setString(1, UserName);
            pstmt.setString(2, Password);

            System.out.println("sql query " + pstmt.toString());
            rs = pstmt.executeQuery();
//            System.out.println(rs);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in dbsearch");
        }
        return rs;
    }
}
