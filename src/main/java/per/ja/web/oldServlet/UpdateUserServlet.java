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

//@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post解决中文乱码
        req.setCharacterEncoding("utf-8");

        //1.接收数据
        String UserID = req.getParameter("id");
        String NickName = req.getParameter("nickname");
        String UserPhone = req.getParameter("userPhone");
        String UserAge = req.getParameter("userAge");
        String isActive = req.getParameter("isActive");
        String userAccount = req.getParameter("userAccount");
        //2.封装对象
        User user = new User(Integer.parseInt(UserID), userAccount, null, NickName, Integer.parseInt(isActive), UserPhone, UserAge);

        //3.调用server方法
        service.updateById(user);

        //4.转发到selectAllUserServlet
        req.getRequestDispatcher("/selectAllUserServlet").forward(req,resp);

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
