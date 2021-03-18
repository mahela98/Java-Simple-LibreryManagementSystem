package control;

import view.HomePage;
import model.DBConnection;
import model.DBSearch;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.AdminHomePage;
import view.Login;

public class LoginController {

     

    public static int login(String username, String password) {
        int result = 1;
        int USERID;
        int adminOrNot=0;
        try {
            ResultSet rs = new DBSearch().searchLogin(username, password);
            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
                //                to pass userId
                USERID = rs.getInt("userId");
                adminOrNot= rs.getInt("adminOrNot");
                
                System.out.println("admin = " + adminOrNot);

                String userEmail = rs.getString("email");
                
                String fullName = rs.getString("fullName");
                String mobile = rs.getString("mobile");
                System.out.format("%s, %s, %s\n", userEmail, fullName, mobile);
                
                if (rowCount == 0 || rs == null) {
                    System.out.println("Null " + rowCount);
                    result = 1;

                } else if (rowCount > 0) {
                    System.out.println("User Name and Password matched" + rowCount);
                    if (adminOrNot==1) {
                        AdminHomePage adminHomePage = new AdminHomePage();
                        adminHomePage.setVisible(true);
                        adminHomePage.setUSERID_HomePage(USERID);
                        System.out.println("LOgin AS ADMIN");
                    }
                    else{
                        HomePage homePage = new HomePage();
                        homePage.setVisible(true);
                        homePage.setUSERID_HomePage(USERID);
                    }
                    result = 0;
                }
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.err.println("Got an exception! in login con ");
            System.err.println(e.getMessage());
            e.printStackTrace();
            result = 2;
        }
        return result;
    }

}
