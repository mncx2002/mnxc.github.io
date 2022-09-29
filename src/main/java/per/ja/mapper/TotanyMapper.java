package per.ja.mapper;

import org.apache.ibatis.annotations.Param;
import per.ja.pojo.Column;
import per.ja.pojo.Totany;

import java.util.List;

public interface TotanyMapper {

    //分页条件查询
    List<Totany> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("totany") Totany totany);
    //分页条件查询总数
    Integer selectTotalCountByPageAndCondition( @Param("totany") Totany totany);

    List<Totany> selectByCascadeAndPage(@Param("begin") int begin, @Param("size") int size, @Param("ids") List<Integer> ids);

    Integer selectTotalCntByCascadeAndPage( @Param("ids") List<Integer> ids);

}
