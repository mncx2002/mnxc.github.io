package per.ja.util;

import per.ja.pojo.Admin;
import per.ja.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
    private SessionUtil(){}
    public static String getAdminName(HttpServletRequest req){
        HttpSession session = req.getSession();
        Admin admin = (Admin) session.getAttribute("Admin");
        if(admin==null)return null;
        return admin.getAdminName();
    }
    public static String getUserName(HttpServletRequest req){
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("User");
        if(user==null) return null;
        return user.getNickName();
    }
}
