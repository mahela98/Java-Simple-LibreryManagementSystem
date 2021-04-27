/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.AllUserListGettingMODEL;
import model.DBConnection;
import view.Users;

/**
 *
 * @author EACMS
 */
public class AddAllUsersToListCON {

    public static ArrayList<Users> allUserList = new ArrayList<>();

    public static ArrayList<Users> allUserList() {
        ArrayList<Users> allUserList = new ArrayList<>();
        allUserList.clear();
        try {
            ResultSet rs = null;
            rs = new AllUserListGettingMODEL().allUsers();
            System.out.println("list in control" + rs);
            Users user;
            while (rs.next()) {
                user = new Users(rs.getInt("userId"), rs.getString("email"), rs.getString("fullName"), rs.getString("userName"), rs.getString("mobile"), rs.getString("password"),rs.getInt("adminOrNot"));
                allUserList.add(user);
            }

            DBConnection.closeCon();
        } catch (Exception e) {
            System.err.println("Got an exception in addallbookstolist ");
            System.err.println(e.getMessage());
        }
        return allUserList;
    }

}
