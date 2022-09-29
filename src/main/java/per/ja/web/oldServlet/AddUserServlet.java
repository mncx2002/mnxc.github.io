package per.ja.web.oldServlet;

import com.alibaba.fastjson.JSON;
import per.ja.pojo.User;
import per.ja.service.Impl.UserServiceImpl;
import per.ja.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        BufferedReader bf = req.getReader();
        String userdata = bf.readLine();
        User user = JSON.parseObject(userdata, User.class);
        if(user.getUserPhone()==null||user.getNickName()==null){
            resp.getWriter().write("缺少必要数据，无法添加用户");
            return;
        }else if("".equals(user.getUserPhone().trim())||"".equals(user.getUserPWD().trim())){
            resp.getWriter().write("缺少必要数据，无法添加用户");
            return;
        }
        boolean add_flag = service.add(user);
        System.out.println(user);
        if(add_flag){
            //添加成功
            resp.getWriter().write("add_user_success");
        }else{
            //添加失败
            resp.getWriter().write("电话号码已被占用");
        }

        //预防post中文乱码
//        req.setCharacterEncoding("utf-8");
//        //1.接受表单数据
//
//        String nickname = req.getParameter("nickname");
//        String userPhone = req.getParameter("userPhone");
//        String userAge = req.getParameter("userAge");
//        String password = req.getParameter("password");
//        String isActive = req.getParameter("isActive");
//
//        //2.封装用户对象
//        User user = new User(password, nickname, Integer.parseInt(isActive), userPhone, userAge);
//
//        //3.添加用户
//        service.add(user);
//
//        //4.转发到查询所有用户的Servlet
//        req.getRequestDispatcher("/selectAllUserServlet").forward(req,resp);

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
