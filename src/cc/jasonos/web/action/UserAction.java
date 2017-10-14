package cc.jasonos.web.action;

import cc.jasonos.domain.User;
import cc.jasonos.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by Jason on 2017/10/13.
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    private UserService us;

    public void setUs(UserService us) {
        this.us = us;
    }

    public String login() throws Exception {
        //1.调用Service执行登陆逻辑
        User u = us.getUserByCodePassword(user);
        //2.将返回的User对象放入session域中
        ActionContext.getContext().getSession().put("user",u);
        //3.重定向到项目首页
        return "toHome";
    }

    @Override
    public User getModel() {
        return user;
    }
}
