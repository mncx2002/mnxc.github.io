package per.ja.web.oldServlet;

import com.alibaba.fastjson.JSON;
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

//@WebServlet("/selectUserByPhoneServlet")
public class SelectUserByPhoneServlet extends HttpServlet {

    UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userdata = req.getReader().readLine();
        User u = JSON.parseObject(userdata, User.class);
        User user = service.selectByPhone(u);
        resp.setCharacterEncoding("utf-8");
        if(user!=null){
            resp.getWriter().write("电话号码已使用");
        }else{
            resp.getWriter().write("");
        }
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
