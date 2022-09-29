package per.ja.mapper;

import org.apache.ibatis.annotations.Param;
import per.ja.pojo.Message;

import java.util.List;

public interface MessageMapper {

    Integer selectTotalCountByPageAndCondition(@Param("message") Message msg);

    List<Message> selectByPageAndCondition(@Param("begin")int begin,@Param("size")int page_size,@Param("message") Message msg);
}
