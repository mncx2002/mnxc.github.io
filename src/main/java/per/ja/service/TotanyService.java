package per.ja.service;

import per.ja.pojo.PageBean;
import per.ja.pojo.Totany;

import java.util.List;

public interface TotanyService {
    PageBean<Totany> selectByPageAndCondition(int current_page,int page_size,Totany totany);

    PageBean<Totany> selectByCascadeAndPage(int current_page, int page_size, List<Integer> ids);
}
