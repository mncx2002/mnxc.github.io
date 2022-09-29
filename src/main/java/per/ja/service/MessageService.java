package per.ja.service;

import per.ja.pojo.Message;
import per.ja.pojo.PageBean;

public interface MessageService {

    //分页条件查询
    PageBean<Message> selectByPageAndCondition(int current_page,int page_size,Message msg);

}
