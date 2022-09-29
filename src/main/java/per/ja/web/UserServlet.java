package per.ja.web;

import com.alibaba.fastjson.JSON;
import per.ja.pojo.PageBean;
import per.ja.pojo.User;
import per.ja.service.Impl.UserServiceImpl;
import per.ja.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{
    private final UserService service = new UserServiceImpl();
    //查询所有用户
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = service.selectAll();
        String usersdata = JSON.toJSONString(users);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(usersdata);
    }

    //添加用户
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        }else {
            //添加失败
            resp.getWriter().write("电话号码已被占用");
        }
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post解决中文乱码
        req.setCharacterEncoding("utf-8");

        //1.接收数据
//        String UserID = req.getParameter("id");
//        String NickName = req.getParameter("nickname");
//        String UserPhone = req.getParameter("userPhone");
//        String UserAge = req.getParameter("userAge");
//        String isActive = req.getParameter("isActive");
//        String userAccount = req.getParameter("userAccount");
        String userdata = req.getReader().readLine();
        User user = JSON.parseObject(userdata, User.class);
        //2.封装对象
        //3.调用server方法
        service.updateById(user);

        //4.返回信息
        resp.getWriter().write("update user success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post解决中文乱码
        req.setCharacterEncoding("utf-8");
        String usersdata = req.getReader().readLine();
        int[] ids = JSON.parseObject(usersdata, int[].class);
        //2.封装对象
        //3.调用server方法
        service.deleteByIds(ids);
        resp.getWriter().write("delete_users_success");
    }
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post解决中文乱码
        req.setCharacterEncoding("utf-8");
        String pageData = req.getReader().readLine();
        int[] pageInfo = JSON.parseObject(pageData, int[].class);
        //pageInfo: [currentPage,size]
        //.\调用server方法
        PageBean<User> userPageBean = service.selectByPage(pageInfo[0], pageInfo[1]);
        //发送数据
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(userPageBean);
        resp.getWriter().write(jsonString);
    }
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String _current_page =URLDecompiler( req.getParameter("current_page"));
        String _page_size =URLDecompiler( req.getParameter("page_size"));
        String _user = req.getReader().readLine();
        User user = JSON.parseObject(_user, User.class);
        int current_page = Integer.parseInt(_current_page);
        int page_size = Integer.parseInt(_page_size);
        //pageInfo: [currentPage,size]
        //.\调用server方法
        PageBean<User> userPageBean = service.selectByPageAndCondition(current_page,page_size,user);
        //发送数据
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(userPageBean);
        resp.getWriter().write(jsonString);
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
