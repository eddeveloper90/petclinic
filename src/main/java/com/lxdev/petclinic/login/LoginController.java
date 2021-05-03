/**
 * @author eddeveloper <ed.developer90@gmail.com>
 * Date :  2021-05-02
 * Time : 10:17 PM
 */
package com.lxdev.petclinic.login;

import com.lxdev.petclinic.login.requests.LoginReq;
import com.lxdev.petclinic.login.requests.RegisterReq;
import com.lxdev.petclinic.response.DefaultResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login/index";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "login/register";
    }

    @PostMapping("/security/login")
    public ResponseEntity<?> login(@RequestBody LoginReq model,
                                   HttpServletResponse response) {
        if (model == null) {
            return ResponseEntity.badRequest().body("your payload is null");
        }

        if (model.getUsername() == null || model.getUsername().length() < 1) {
            return ResponseEntity.badRequest().body("username is not ok");
        }

        if (model.getPass() == null || model.getPass().length() < 1) {
            return ResponseEntity.badRequest().body("pass is not ok");
        }

        DefaultResponse resp = loginService.login(model.getUsername(), model.getPass());
        // means if token is created
        // set cookie
        if (resp.getCode() == 200) {
            Cookie tokenCookie = new Cookie("_t", resp.getToken());
            tokenCookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
            tokenCookie.setSecure(true);

            response.addCookie(tokenCookie);
            return ResponseEntity.ok().body(resp.toString());
        } else {
            return ResponseEntity.ok().body(resp.toString());
        }
    }

    @PostMapping("/security/register")
    public ResponseEntity<?> register(@RequestBody RegisterReq model,
                                      HttpServletResponse response) {
        if (model == null) {
            return ResponseEntity.badRequest().body("your payload is null");
        }

        if (model.getUsername() == null || model.getUsername().length() < 1) {
            return ResponseEntity.badRequest().body("username is not ok");
        }

        if (model.getPass() == null || model.getPass().length() < 1) {
            return ResponseEntity.badRequest().body("pass is not ok");
        }

        DefaultResponse resp = loginService.register(model.getUsername(), model.getPass());
        // means if token is created
        // set cookie
        if (resp.getCode() == 200) {
            Cookie tokenCookie = new Cookie("_t", resp.getToken());
            tokenCookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
            tokenCookie.setSecure(true);

            response.addCookie(tokenCookie);
            return ResponseEntity.ok().body(resp.toString());
        } else {
            return ResponseEntity.ok().body(resp.toString());
        }
    }
}
