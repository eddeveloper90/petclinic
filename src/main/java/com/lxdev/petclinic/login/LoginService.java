/**
 * @author eddeveloper <ed.developer90@gmail.com>
 * Date :  2021-05-03
 * Time : 10:39 PM
 */
package com.lxdev.petclinic.login;

import com.lxdev.petclinic.config.Config;
import com.lxdev.petclinic.utils.TextUtils;
import com.lxdev.petclinic.model.Token;
import com.lxdev.petclinic.model.User;
import com.lxdev.petclinic.response.DefaultResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private UserRepo userRepo;
    private TokenRepo tokenRepo;

    public LoginService(UserRepo userRepo,
                        TokenRepo tokenRepo) {
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
    }

    public DefaultResponse login(String username,
                                 String pass) {
        DefaultResponse response = new DefaultResponse();
        User user = userRepo.findUserByUsername(username);
        if (user == null) {
            // error there is no user.
            response.setMsg(101, "user not found!");
            return response;
        }

        String hashPass = TextUtils.sha1(pass);
        if (hashPass.equals(user.getPassword())) {
            // login
            String token = getToken(user);
            response.setToken(token);
            response.getJson().put("token", token);
            return response;
        } else {
            response.setMsg(102, "username or password are not matched.");
            return response;
        }
    }

    public DefaultResponse register(String username,
                                    String pass) {
        DefaultResponse response = new DefaultResponse();
        User user = userRepo.findUserByUsername(username);
        if (user != null) {
            response.setMsg(104, "user existed.");
            return response;
        }

        String hashPass = TextUtils.sha1(pass);

        user = new User();
        user.setUsername(username);
        user.setPassword(hashPass);

        userRepo.save(user);

        // token
        String token = getToken(user);

        response.setToken(token);
        response.getJson().put("token", token);
        return response;
    }

    private String getToken(User user) {
        String tokenStr = TextUtils.randomToken(Config.TOKEN_LEN);
        Token token = new Token();
        token.setUser(user);
        token.setTokenStr(tokenStr);

        tokenRepo.save(token);
        return tokenStr;
    }
}
