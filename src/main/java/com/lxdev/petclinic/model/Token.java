/**
 * @author eddeveloper <ed.developer90@gmail.com>
 * Date :  2021-05-02
 * Time : 10:20 PM
 */
package com.lxdev.petclinic.model;

import javax.persistence.*;

@Entity
public class Token extends BaseEntity {
    @Column(unique = true)
    private String tokenStr;

    @JoinColumn
    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
