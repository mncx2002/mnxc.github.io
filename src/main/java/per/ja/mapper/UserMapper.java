package per.ja.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import per.ja.pojo.User;

import java.util.List;

public interface UserMapper {
    //获取所有用户信息
    List<User> selectAll();

    User selectById(int id);

    @Select("select * from user_info_table where UserPhone=#{telphone}")
    User selectByPhone(String telphone);

    User selectByUserPhoneAndUserPWD(@Param("userphone") String phone, @Param("password") String pwd);

    @Insert("insert into user_info_table values(null,#{UserAccount},#{UserPWD},#{NickName},#{IsActive},#{UserPhone},#{UserAge})")
    void addUser(User user);

    @Update("update user_info_table set UserAge=#{UserAge},NickName=#{NickName},IsActive=#{IsActive},UserPhone=#{UserPhone} where UserID=#{UserID}")
    void updateUser(User user);

    void deleteByIds(@Param("ids") int[] ids);

    //分页查询
    @Select("select * from user_info_table limit #{begin},#{page_size}")
    List<User> selectCurrentPageData(@Param("begin") int begin,@Param("page_size") int page_size);
    //查询总记录数目
    @Select("select COUNT(*) from user_info_table")
    int selectTotalCount();

    //分页条件查询
    List<User> selectCurrentPageDataAndCondition(@Param("begin") int begin, @Param("page_size") int page_size, @Param("user") User user);
    //查询总记录数目
    int selectTotalCountAndCondition(@Param("user") User user);
}
