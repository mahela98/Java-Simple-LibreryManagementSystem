/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author EACMS
 */
public class Users {

    private int userId, adminOrNot;
    private String email, fullName, userName, mobile, password;

    public Users(int userId, String email, String fullName, String userName, String mobile, String password, int adminOrNot) {
        this.userId = userId;
        this.email = email;
        this.fullName = fullName;
        this.userName = userName;
        this.mobile = mobile;
        this.password = password;
        this.adminOrNot = adminOrNot;

    }

    public int getAdminOrNot() {
        return adminOrNot;
    }

    public void setAdminOrNot(int adminOrNot) {
        this.adminOrNot = adminOrNot;
    }

   

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
