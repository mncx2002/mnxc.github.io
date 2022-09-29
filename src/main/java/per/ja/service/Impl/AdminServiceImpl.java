package per.ja.service.Impl;

import org.apache.ibatis.session.SqlSession;
import per.ja.mapper.AdminMapper;
import per.ja.pojo.Admin;
import per.ja.pojo.PageBean;
import per.ja.service.AdminService;
import per.ja.util.MybatisUtil;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    //管理员分页条件查询
    @Override
    public PageBean<Admin> selectByPageAndCondition(int current_page, int page_size, Admin admin) {
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        AdminMapper mapper = sqlsession.getMapper(AdminMapper.class);
        List<Admin> admins = mapper.selectByPageAndCondition((current_page - 1) * page_size, page_size, admin);
        Integer totalCnt = mapper.selectTotalCountByPageAndCondition(admin);
        return new PageBean<>(totalCnt,admins);
    }

    @Override
    public Admin login(Admin admin) {
        if(admin ==null)return null;
        SqlSession sqlsession = MybatisUtil.getSqlsession();
        Admin login = sqlsession.getMapper(AdminMapper.class).login(admin);
        //释放资源
        sqlsession.close();
        return login;
    }
}
