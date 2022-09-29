package per.ja.service.Impl;

import org.apache.ibatis.session.SqlSession;
import per.ja.mapper.LunchMapper;
import per.ja.pojo.Lunch;
import per.ja.pojo.PageBean;
import per.ja.service.LunchService;
import per.ja.util.MybatisUtil;

import java.util.List;

public class LunchServiceImpl implements LunchService {
    @Override
    public PageBean<Lunch> selectByPageAndCondition(int current_page, int page_size, Lunch lunch) {
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        LunchMapper mapper = sqlsession.getMapper(LunchMapper.class);
        List<Lunch> lunches = mapper.selectByPageAndCondition((current_page - 1) * page_size, page_size, lunch);
        Integer totalCnt = mapper.selectTotalCountByPageAndCondition(lunch);

        sqlsession.close();
        return new PageBean<>(totalCnt,lunches);
    }
}
