package per.ja.service;

import per.ja.pojo.Admin;
import per.ja.pojo.PageBean;

public interface AdminService {
    /**
     * 管理员信息分页条件查询
     * @param current_page
     * @param page_size
     * @param admin
     * @return
     */
    PageBean<Admin> selectByPageAndCondition(int current_page, int page_size, Admin admin);

    Admin login(Admin admin);
}
