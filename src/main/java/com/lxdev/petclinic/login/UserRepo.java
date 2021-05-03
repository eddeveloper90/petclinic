/**
 * @author eddeveloper <ed.developer90@gmail.com>
 * Date :  2021-05-02
 * Time : 10:17 PM
 */
package com.lxdev.petclinic.login;

import org.springframework.data.repository.CrudRepository;
import com.lxdev.petclinic.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findUserById(Integer id);

    User findUserByUsername(String username);
}
