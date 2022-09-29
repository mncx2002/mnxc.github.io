package per.ja.service;

import per.ja.pojo.PageBean;
import per.ja.pojo.User;

import java.util.List;

public interface UserService {
    //查询所有用户
    List<User> selectAll();
    //添加用户
    boolean add(User user);
    //查询用户BYPhone
    User selectByPhone(User u);
    //查询用户BYId
    User selectById(int id);
    //更新用户信息BYId
    void updateById(User user);

    //批量删除
    void deleteByIds(int[] ids);

    PageBean<User> selectByPage(int currentPage,int size);

    PageBean<User> selectByPageAndCondition(int currentPage,int size,User user);
}
