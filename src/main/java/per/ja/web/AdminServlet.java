package per.ja.web;

import com.alibaba.fastjson.JSON;
import per.ja.pojo.Admin;
import per.ja.pojo.PageBean;
import per.ja.service.AdminService;
import per.ja.service.Impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/admin/*")
public class AdminServlet extends BaseServlet{
    AdminService service = new AdminServiceImpl();
    //分页条件查询
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取参数
        String _page_size = req.getParameter("page_size");
        String _current_page = req.getParameter("current_page");
        int current_page = Integer.parseInt(_current_page);
        int page_size = Integer.parseInt(_page_size);
        String adminData = req.getReader().readLine();
        Admin admin = JSON.parseObject(adminData, Admin.class);
        //执行方法
        PageBean<Admin> adminPageBean = service.selectByPageAndCondition(current_page, page_size, admin);
        String data = JSON.toJSONString(adminPageBean);
        //发送数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(data);
    }

    //管理员登录
    public void login(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取参数
        String adminData = req.getReader().readLine();
        Admin admin = JSON.parseObject(adminData, Admin.class);
        //执行方法
        Admin login = service.login(admin);
        if(login!=null){
            //登录成功
            HttpSession session = req.getSession();
            session.setAttribute("Admin",login);
            resp.getWriter().write("login success");
        }else{
            resp.getWriter().write("login fault");
        }
    }
}
