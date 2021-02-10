/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import model.DisplayUserDetails;

/**
 *
 * @author EACMS
 */
public class DisplayUserDetailsCON {

    public static ResultSet userDetails(int USERID) {
        ResultSet rs = new DisplayUserDetails().userDetailsinProfile(USERID);
        return rs;
    }

}
