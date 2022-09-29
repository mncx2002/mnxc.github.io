package per.ja.web;

import com.alibaba.fastjson.JSON;
import per.ja.pojo.Admin;
import per.ja.pojo.Column;
import per.ja.pojo.Option;
import per.ja.pojo.PageBean;
import per.ja.service.AdminService;
import per.ja.service.ColumnsService;
import per.ja.service.Impl.AdminServiceImpl;
import per.ja.service.Impl.ColumnsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/columns/*")
public class ColumnsServlet extends BaseServlet{
    ColumnsService service = new ColumnsServiceImpl();
    //分页条件查询
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取参数
        String _page_size = req.getParameter("page_size");
        String _current_page = req.getParameter("current_page");
        int current_page = Integer.parseInt(_current_page);
        int page_size = Integer.parseInt(_page_size);
        String columnData = req.getReader().readLine();
        Column column = JSON.parseObject(columnData, Column.class);
        //执行方法
        PageBean<Column> columnPageBean = service.selectByPageAndCondition(current_page, page_size, column);
        String data = JSON.toJSONString(columnPageBean);
        //发送数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(data);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取参数
        String columnData = req.getReader().readLine();
        Column column = JSON.parseObject(columnData, Column.class);
        //执行方法
        boolean updateFlag = service.update(column);
        //发送数据
        if(updateFlag)
            resp.getWriter().write("update success");
        else
            resp.getWriter().write("update fault");
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取参数
        String columnData = req.getReader().readLine();
        Column column = JSON.parseObject(columnData, Column.class);
        //执行方法
        boolean flag = service.delete(column);

        //发送数据
        if(flag)
            resp.getWriter().write("delete success");
        else
            resp.getWriter().write("delete fault");
    }
    public void getCascade(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //执行方法
        List<Option> cascade = service.getCascade();
        //发送数据
        resp.setContentType("text/json;charset=utf-8");
        String cascadeJson = JSON.toJSONString(cascade);
        resp.getWriter().write(cascadeJson);
    }
}
