package per.ja.web;

import com.alibaba.fastjson.JSON;
import per.ja.pojo.Message;
import per.ja.pojo.PageBean;
import per.ja.service.Impl.MessageServiceImpl;
import per.ja.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/message/*")
public class MessageServlet extends BaseServlet{
    MessageService service = new MessageServiceImpl();

    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取参数
        String _page_size = req.getParameter("page_size");
        String _current_page = req.getParameter("current_page");
        int current_page = Integer.parseInt(_current_page);
        int page_size = Integer.parseInt(_page_size);
        String msgData = req.getReader().readLine();
        Message msg = JSON.parseObject(msgData, Message.class);
        //执行方法
        //System.out.println(column);
        PageBean<Message> columnPageBean = service.selectByPageAndCondition(current_page, page_size, msg);
        String data = JSON.toJSONString(columnPageBean);
        //发送数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(data);
    }

}
