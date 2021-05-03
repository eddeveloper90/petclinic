/**
 * @author eddeveloper <ed.developer90@gmail.com>
 * Date :  2021-05-03
 * Time : 10:54 PM
 */
package com.lxdev.petclinic.login.requests;

public class RegisterReq {
    private String username;
    private String pass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
