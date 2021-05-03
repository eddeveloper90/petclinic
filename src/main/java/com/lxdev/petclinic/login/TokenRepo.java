/**
 * @author eddeveloper <ed.developer90@gmail.com>
 * Date :  2021-05-03
 * Time : 11:17 PM
 */
package com.lxdev.petclinic.login;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.lxdev.petclinic.model.Token;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepo extends CrudRepository<Token, Integer> {
    Token findTokenById(Integer id);

    Token findTokenByTokenStr(String tokenStr);

    @Query("select t from Token t " +
            "where t.user.id = :userId")
    List<Token> fetchUserTokens(@Param("userId") Integer userId) ;
}
