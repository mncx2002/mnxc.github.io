package per.ja.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import per.ja.pojo.Admin;

import java.util.List;

public interface AdminMapper {
    //管理员分页条件查询
    List<Admin> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("admin") Admin admin);
    //分页条件查询总行数
    Integer selectTotalCountByPageAndCondition(@Param("admin") Admin admin);

    //管理员登录

    Admin login(Admin admin);
}
