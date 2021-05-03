/**
 * @author eddeveloper <ed.developer90@gmail.com>
 * Date :  2021-05-03
 * Time : 10:56 PM
 */
package com.lxdev.petclinic.response;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lxdev.petclinic.utils.JsonCreator;


public class DefaultResponse {
    private ObjectNode json;
    private String token;
    private int code = 200;

    public DefaultResponse() {
        this.json = JsonCreator.objectMapper.createObjectNode();
        this.json.put("message", "OK");
        this.json.put("status", 200);
    }

    public void setMsg(int code, String msg) {
        this.code = code;
        this.json.put("message", msg);
        this.json.put("status", code);
    }

    public int getCode() {
        return this.code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ObjectNode getJson() {
        return this.json;
    }

    public String toString() {
        return this.json.toString();
    }
}
