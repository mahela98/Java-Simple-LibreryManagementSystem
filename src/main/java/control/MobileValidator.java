/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author EACMS
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileValidator {

    private String mobile;

    public boolean setMobile(String mobile) {
        this.mobile = mobile;
       
      return isValidIndianMobile(this.mobile);
    }

public boolean isValidIndianMobile(String mobile){
     System.out.println("mV loaded");
        String regex = "\\d{10}";
      //Matching the given phone number
      boolean result = mobile.matches(regex);
      if(result) {
         System.out.println("Given phone number is valid");
      } else{
          System.out.println("Given phone number is not valid");
      }
    return result;
}
}
