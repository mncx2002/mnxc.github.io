package per.ja.service;

import per.ja.pojo.Lunch;
import per.ja.pojo.PageBean;

public interface LunchService {
    PageBean<Lunch> selectByPageAndCondition(int current_page,int page_size,Lunch lunch);
}
