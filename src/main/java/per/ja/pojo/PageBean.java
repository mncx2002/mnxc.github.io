package per.ja.pojo;

import java.util.List;

public class PageBean<T> {
    //总数
    private int totalCnt;
    //当前页数据
    List<T> data;
    //管理员姓名
    String adminName;

    public PageBean(int totalCnt, List<T> data, String adminName) {
        this.totalCnt = totalCnt;
        this.data = data;
        this.adminName = adminName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //用户姓名
    String userName;
    public PageBean(int totalCnt, List<T> data) {
        this.totalCnt = totalCnt;
        this.data = data;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
