package per.ja.web.oldServlet;

import com.alibaba.fastjson.JSON;
import per.ja.pojo.User;
import per.ja.service.Impl.UserServiceImpl;
import per.ja.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllUserServlet")
public class selectAllUserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<User> users = userService.selectAll();
        String usersdata = JSON.toJSONString(users);


        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(usersdata);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
