package per.ja.service.Impl;

import org.apache.ibatis.session.SqlSession;
import per.ja.mapper.ColumnMapper;
import per.ja.mapper.TotanyMapper;
import per.ja.pojo.PageBean;
import per.ja.pojo.Totany;
import per.ja.service.TotanyService;
import per.ja.util.MybatisUtil;

import java.util.List;

public class TotanyServiceImpl implements TotanyService {

    //分页条件查询
    @Override
    public PageBean<Totany> selectByPageAndCondition(int current_page, int page_size, Totany totany) {

        SqlSession sqlsession = MybatisUtil.getSqlsession();
        TotanyMapper mapper = sqlsession.getMapper(TotanyMapper.class);


        List<Totany> totanies = mapper.selectByPageAndCondition((current_page - 1) * page_size, page_size, totany);
        Integer totalCnt = mapper.selectTotalCountByPageAndCondition(totany);
        //释放资源
        sqlsession.close();
        return new PageBean<>(totalCnt,totanies);

    }

    @Override
    public PageBean<Totany> selectByCascadeAndPage(int current_page, int page_size, List<Integer> ids) {
        //获取sqlSession
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        //获取mapper
        TotanyMapper mapper = sqlsession.getMapper(TotanyMapper.class);
        //执行方法
        System.out.println(ids);
        Integer totalCnt = mapper.selectTotalCntByCascadeAndPage(ids);
        List<Totany> totanies = mapper.selectByCascadeAndPage((current_page - 1) * page_size, page_size, ids);
        //释放资源
        sqlsession.close();
        //返回数据
        return new PageBean<>(totalCnt,totanies);
    }
}
