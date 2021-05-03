/**
 * @author eddeveloper <ed.developer90@gmail.com>
 * Date :  2021-05-02
 * Time : 10:18 PM
 */
package com.lxdev.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
    @Column(unique = true)
    private String username;

    @Column
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
