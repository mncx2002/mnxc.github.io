package per.ja.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 判断是否登录
     * @param req
     * @param resp
     * @param chain
     * @throws IOException
     * @throws ServletException
     */


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest _req = (HttpServletRequest) req;
        HttpServletResponse _resp = (HttpServletResponse) resp;
        HttpSession session = _req.getSession();
        Object admin = session.getAttribute("Admin");
        //未登录允许访问的url
        String[]urls = {"/adminLogon.html","/adminLogin.html","/element-ui/","/js/","/admin/login"};
        String url = _req.getRequestURL().toString();
        for(int i=0;i< urls.length;i++){
            if(url.contains(urls[i])){
                //放行
                chain.doFilter(req,resp);

                return;
            }
        }
        if(admin!=null){
            //管理员已登录，放行
            chain.doFilter(req,resp);
        }else{
            //未登录
            _resp.sendRedirect("adminLogin.html");
        }


    }

    @Override
    public void destroy() {

    }
}
