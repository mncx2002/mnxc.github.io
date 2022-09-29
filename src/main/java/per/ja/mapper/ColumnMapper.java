package per.ja.mapper;

import org.apache.ibatis.annotations.*;
import per.ja.pojo.Admin;
import per.ja.pojo.Column;

import java.util.List;

public interface ColumnMapper {

    //类型分页条件查询
    List<Column> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("column") Column column);
    //分页条件查询总行数
    Integer selectTotalCountByPageAndCondition( @Param("column") Column column);

    //更新类型名
    @Update("update column_table set TypeName=#{column.TypeName} where ColumnID=#{column.ColumnID}")
    void updateColumnTypeName(@Param("column")Column column);

    //删除类型
    @Delete("delete from column_table where ColumnID = #{ColumnID}")
    boolean deleteColumn(Column column);
    //添加类型
    @Insert("insert into column_table values(null,#{TypeName},#{PTypeID}) ")
    boolean addColumn(Column column);
    //查找子类型
    List<Column> selectChildType(@Param("column") Column column);
    //查找父类型
    @Select("select * from column_table where ColumnID=#{PTypeName}")
    Column selectParent(Column column);

    @Select("select * from column_table")
    List<Column> selectAll();

    List<Column> selectByIds(@Param("ids")List<Integer> ids);

    @Select("select * from column_table where ColumnID= #{ColumnID}")
    Column slectById(int id);

    List<Integer> selectTotancyIDs(@Param("columns") List<Column> columns);

}
