package cc.jasonos.service;

import cc.jasonos.domain.User;

/**
 * Created by Jason on 2017/10/13.
 */
public interface UserService {

    //登陆方法
    User getUserByCodePassword(User u);

    //注册用户
    void saveUser(User u);

}
