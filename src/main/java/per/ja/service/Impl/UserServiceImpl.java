package per.ja.service.Impl;

import org.apache.ibatis.session.SqlSession;
import per.ja.mapper.UserMapper;
import per.ja.pojo.PageBean;
import per.ja.pojo.User;
import per.ja.service.UserService;
import per.ja.util.MybatisUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    //获取所有用户信息
    public List<User> selectAll(){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        List<User> users = sqlsession.getMapper(UserMapper.class).selectAll();
        sqlsession.close();
        return users;
    }
    public boolean add(User user){
        //添加是否成功
        SqlSession sqlsession = MybatisUtil.getSqlsession();

        //判断电话是否已被使用
        if(selectByPhone(user)!=null){
            //电话已注册
            return false;
        }
        //添加用户
        sqlsession.getMapper(UserMapper.class).addUser(user);
        //提交事务
        sqlsession.commit();
        //关闭资源
        sqlsession.close();

        return true;
    }

    public User selectByPhone(User u){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        if(u.getUserPhone()==null)return null;
        User user = sqlsession.getMapper(UserMapper.class).selectByPhone(u.getUserPhone());
        sqlsession.close();
        return user;
    }
    public User selectById(int id){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        User user = sqlsession.getMapper(UserMapper.class).selectById(id);
        sqlsession.close();
        return user;
    }
    public void updateById(User user){
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        //添加用户
        sqlsession.getMapper(UserMapper.class).updateUser(user);
        //提交事务
        sqlsession.commit();
        //关闭资源
        sqlsession.close();
    }

    //批量删除
    @Override
    public void deleteByIds(int[] ids) {
        //判断ids数组是否为空：为空就不删除
        if(ids.length==0)return;
        SqlSession sqlsession = MybatisUtil.getSqlsession();

        sqlsession.getMapper(UserMapper.class).deleteByIds(ids);

        sqlsession.commit();

        sqlsession.close();
    }

    @Override
    public PageBean<User> selectByPage(int currentPage, int size) {
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int totalCount =mapper.selectTotalCount();
        List<User> users = mapper.selectCurrentPageData((currentPage - 1) * size, size);
        //释放资源
        sqlsession.close();
        return new PageBean<User>(totalCount,users);
    }

    @Override
    public PageBean<User> selectByPageAndCondition(int currentPage, int size, User user) {
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        int totalCount =mapper.selectTotalCountAndCondition(user);
        List<User> users = mapper.selectCurrentPageDataAndCondition((currentPage - 1) * size, size,user);
        //释放资源
        sqlsession.close();
        return new PageBean<User>(totalCount,users);
    }
}
