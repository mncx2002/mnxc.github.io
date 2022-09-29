package per.ja.web.oldServlet;

import per.ja.pojo.User;
import per.ja.service.Impl.UserServiceImpl;
import per.ja.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

//@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    UserService service=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取参数id
        Integer id =Integer.parseInt(req.getParameter("id"));

        //2.获取指定用户
        User user = service.selectById(id);

        //3.封装user数据
        req.setAttribute("user",user);

        //4.转发到user_info_update.jsp
        req.getRequestDispatcher("/user_info_update.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    protected String URLDecompiler(String resource, String Encode) throws UnsupportedEncodingException {
        //1.先把String进行URL ISO-8859-1编码
        String encode = URLEncoder.encode(resource, "ISO-8859-1");

        //2.再用URL UTF-8/GBK 解码
        return URLDecoder.decode(encode, Encode);
    }

    protected String URLDecompiler(String resource) throws UnsupportedEncodingException {
        return URLDecompiler(resource, "UTF-8");
    }
}
