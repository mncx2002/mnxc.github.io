package per.ja.mapper;

import org.apache.ibatis.annotations.Param;
import per.ja.pojo.Lunch;

import java.util.List;

public interface LunchMapper {
    //分页查询
    List<Lunch> selectByPageAndCondition(@Param("begin")int begin,@Param("size")int size,@Param("lunch")Lunch lunch);
    //分页查询总数
    Integer selectTotalCountByPageAndCondition(@Param("lunch")Lunch lunch);
}
