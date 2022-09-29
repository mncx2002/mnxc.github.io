package per.ja.service.Impl;

import org.apache.ibatis.session.SqlSession;
import per.ja.mapper.MessageMapper;
import per.ja.pojo.Message;
import per.ja.pojo.PageBean;
import per.ja.service.MessageService;
import per.ja.util.MybatisUtil;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    @Override
    public PageBean<Message> selectByPageAndCondition(int current_page, int page_size, Message msg) {
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        MessageMapper mapper = sqlsession.getMapper(MessageMapper.class);
        List<Message> messages = mapper.selectByPageAndCondition((current_page - 1) * page_size, page_size, msg);
        Integer totalCnt = mapper.selectTotalCountByPageAndCondition(msg);

        //释放资源
        sqlsession.close();
        return new PageBean<>(totalCnt,messages);
    }
}
