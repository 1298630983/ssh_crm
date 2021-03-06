package cc.jasonos.service;

import cc.jasonos.dao.UserDao;
import cc.jasonos.domain.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jason on 2017/10/13.
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, readOnly = true, propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    private UserDao ud;

    @Override
    public User getUserByCodePassword(User u) {
        //1.根据登陆名称查询登陆用户
        User existU = ud.getByUserCode(u.getUser_code());
        //2.判断用户是否存在，不存在=》抛出异常，提示用户不存在
        if (existU == null) {
            throw new RuntimeException("用户名不存在！");
        }
        //3.判断用户密码是否正确，不存在=》抛出异常，提示密码错误
        if (!existU.getUser_password().equals(u.getUser_password())) {
            throw new RuntimeException("密码错误！");
        }
        //4.返回用户查询到的对象
        return existU;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, readOnly = false, propagation = Propagation.REQUIRED)
    public void saveUser(User u) {
        ud.save(u);
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }
}
