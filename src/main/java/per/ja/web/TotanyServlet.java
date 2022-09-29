package per.ja.web;

import com.alibaba.fastjson.JSON;
import org.apache.commons.text.StringEscapeUtils;
import per.ja.pojo.PageBean;
import per.ja.pojo.Totany;
import per.ja.service.ColumnsService;
import per.ja.service.Impl.ColumnsServiceImpl;
import per.ja.service.Impl.TotanyServiceImpl;
import per.ja.service.TotanyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/totany/*")
public class TotanyServlet extends BaseServlet{

    TotanyService service = new TotanyServiceImpl();
    ColumnsService columnsService = new ColumnsServiceImpl();

    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取参数
        String _page_size = req.getParameter("page_size");
        String _current_page = req.getParameter("current_page");
        int current_page = Integer.parseInt(_current_page);
        int page_size = Integer.parseInt(_page_size);
        String totanyData = req.getReader().readLine();
        Totany totany = JSON.parseObject(totanyData, Totany.class);
        //执行方法
        //System.out.println(totany);
        PageBean<Totany> totanyPageBean = service.selectByPageAndCondition(current_page, page_size, totany);
        String data = JSON.toJSONString(totanyPageBean);
        //发送数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(data);
    }

    public void selectByCascadeAndCondition(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取参数
        String _page_size = req.getParameter("page_size");
        String _current_page = req.getParameter("current_page");
        int current_page = Integer.parseInt(_current_page);
        int page_size = Integer.parseInt(_page_size);
        String totanyData = req.getReader().readLine();
        int[] ids = JSON.parseObject(totanyData, int[].class);
        int last = 0;
        for (int i = 0; i < ids.length; i++) {
                last=ids[i];
        }
        System.out.println(last);
        List<Integer> totancyIDs = columnsService.getTotancyIDs(new ArrayList<>(last));
        //执行方法
        //System.out.println(totany);
        PageBean<Totany> totanyPageBean = service.selectByCascadeAndPage(current_page, page_size, totancyIDs);
        String data = JSON.toJSONString(totanyPageBean);
        //发送数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(data);
    }
}

