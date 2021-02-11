/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import model.DBConnection;
import model.DBSearch;
import view.HomePage;
import model.UserSignInModel;

/**
 *
 * @author EACMS
 */
public class UserSigninCON {

    public static int userSignin(String name, String UserName, String email, String mobile, String Password) {
        int result;
        int USERID = -3;
        try {
            result = UserSignInModel.canSignIn(name, UserName, email, mobile, Password);
            if (result == 0) {
                USERID = UserSignInModel.gettingUId(email, Password);
            } else {
                USERID = -3;
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.err.println("Got an exception! in login con ");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return USERID;
    }

}
