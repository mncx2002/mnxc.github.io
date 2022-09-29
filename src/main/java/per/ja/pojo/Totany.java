package per.ja.pojo;

//植物类
public class Totany {
    Integer TotanyInfoID;
    String TotanyName;
    String AnotherName;
    String LuchTime;
    String TotancyContent;
    Integer AdminID;

    public Totany(String totanyName, String anotherName, String luchTime, String totancyContent, Integer adminID) {
        TotanyName = totanyName;
        AnotherName = anotherName;
        LuchTime = luchTime;
        TotancyContent = totancyContent;
        AdminID = adminID;
    }

    public Totany() {
    }

    public Integer getTotanyInfoID() {
        return TotanyInfoID;
    }

    public void setTotanyInfoID(Integer totanyInfoID) {
        TotanyInfoID = totanyInfoID;
    }

    public String getTotanyName() {
        return TotanyName;
    }

    public void setTotanyName(String totanyName) {
        TotanyName = totanyName;
    }

    public String getAnotherName() {
        return AnotherName;
    }

    public void setAnotherName(String anotherName) {
        AnotherName = anotherName;
    }

    public String getLuchTime() {
        return LuchTime;
    }

    public void setLuchTime(String luchTime) {
        LuchTime = luchTime;
    }

    public String getTotancyContent() {
        return TotancyContent;
    }

    public void setTotancyContent(String totancyContent) {
        TotancyContent = totancyContent;
    }

    public Integer getAdminID() {
        return AdminID;
    }

    public void setAdminID(Integer adminID) {
        AdminID = adminID;
    }

    @Override
    public String toString() {
        return "Totany{" +
                "TotanyInfoID=" + TotanyInfoID +
                ", TotanyName='" + TotanyName + '\'' +
                ", AnotherName='" + AnotherName + '\'' +
                ", LuchTime='" + LuchTime + '\'' +
                ", TotancyContent='" + TotancyContent + '\'' +
                ", AdminID=" + AdminID +
                '}';
    }
}
