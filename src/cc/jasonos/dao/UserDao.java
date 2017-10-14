package cc.jasonos.dao;

import cc.jasonos.domain.User;

/**
 * Created by Jason on 2017/10/13.
 */
public interface UserDao {

    //根据登录名称查询user对象
    User getByUserCode(String usercode);

    //保存用户
    void save(User u);
}
