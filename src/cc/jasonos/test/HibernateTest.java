package cc.jasonos.test;

import cc.jasonos.dao.UserDao;
import cc.jasonos.domain.User;
import cc.jasonos.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.security.auth.login.Configuration;

/**
 * Created by Jason on 2017/10/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {

    @Resource(name = "sessionFactory")
    private SessionFactory sf;

    @Test
    public void fun1() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        User u = new User();
        u.setUser_code("rose");
        u.setUser_name("肉丝");
        u.setUser_password("qweasd123");

        session.save(u);

        tx.commit();
        session.close();
    }

    @Resource(name = "userDao")
    private UserDao ud;

    @Test
    public void fun2() {
        User u = ud.getByUserCode("jason");
        System.out.println(u);
    }

    @Resource(name = "userService")
    private UserService us;

    @Test
    public void fun3() {

        User u = new User();
        u.setUser_code("dfed");
        u.setUser_name("dfd");
        u.setUser_password("qwe");

        us.saveUser(u);
    }

}
