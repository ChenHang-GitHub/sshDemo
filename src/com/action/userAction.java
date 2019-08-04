package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;
import com.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component("userAction")
@Scope("prototype")
public class userAction extends ActionSupport {

    private  String queryText;

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    @Resource
    private UserService userService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    private  User user ;

    private List<User> users;

    public String addUser() throws Exception {
        userService.save(user);
        System.out.println("ACtionHere");
        return  SUCCESS;
    }

    public  String  queryUser() throws  Exception
    {
        users = userService.queryUser(queryText);
        return  SUCCESS;
    }

    public  String editUser() throws  Exception
    {

        Integer param = Integer.valueOf(ServletActionContext.getRequest().getParameter("param"));

        System.out.println(param);
        if(param==0)
        {
            Integer id = Integer.valueOf(ServletActionContext.getRequest().getParameter("id"));
            user = userService.getUser(id);
            return  "editUser";
        }else {
            System.out.println(user.toString());
            userService.modifyUser(user);
            return SUCCESS;
        }
    }

    public  String deleteUser() throws  Exception
    {
        Integer id = Integer.valueOf(ServletActionContext.getRequest().getParameter("id"));
        System.out.println("delete id ="+id);
        userService.deleteUser(id);
        return  SUCCESS;
    }

}
