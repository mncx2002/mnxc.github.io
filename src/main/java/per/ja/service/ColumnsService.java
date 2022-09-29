package per.ja.service;

import per.ja.pojo.Column;
import per.ja.pojo.Option;
import per.ja.pojo.PageBean;

import java.util.List;

public interface ColumnsService {
    PageBean<Column> selectByPageAndCondition(int current_page,int page_size,Column column);

    boolean update(Column column);

    //添加类型

    boolean add(Column parent ,Column newChild);

    //删除类型
    boolean delete(Column column);

    //获取级联数据
    List<Option> getCascade();

    //获取类型By  ids
    List<Column> selectByIds(List<Integer> ids);

    List<Integer> getTotancyIDs(List<Integer> ids);
}
