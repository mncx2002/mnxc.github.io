package per.ja.web;

import per.ja.util.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login/*")
public class LoginServlet extends BaseServlet{
    public void getAdminName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String adminName = SessionUtil.getAdminName(req);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(adminName);
    }
    public void getUserName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = SessionUtil.getUserName(req);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(userName);
    }
}
