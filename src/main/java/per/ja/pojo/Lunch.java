package per.ja.pojo;

public class Lunch {
    Integer LunchID;
    String LunchType;
    String LunchTIme;
    String LunchCont;
    String LunchLabel;
    Integer UserID;
    Integer isVisible;

    public Lunch(String lunchType, String lunchTIme, String lunchCont, String lunchLabel, Integer userID, Integer isVisible) {
        LunchType = lunchType;
        LunchTIme = lunchTIme;
        LunchCont = lunchCont;
        LunchLabel = lunchLabel;
        UserID = userID;
        this.isVisible = isVisible;
    }

    public Lunch() {
    }

    public Lunch(Integer lunchID) {
        LunchID = lunchID;
    }

    public Integer getLunchID() {
        return LunchID;
    }

    public void setLunchID(Integer lunchID) {
        LunchID = lunchID;
    }

    public String getLunchType() {
        return LunchType;
    }

    public void setLunchType(String lunchType) {
        LunchType = lunchType;
    }

    public String getLunchTIme() {
        return LunchTIme;
    }

    public void setLunchTIme(String lunchTIme) {
        LunchTIme = lunchTIme;
    }

    public String getLunchCont() {
        return LunchCont;
    }

    public void setLunchCont(String lunchCont) {
        LunchCont = lunchCont;
    }

    public String getLunchLabel() {
        return LunchLabel;
    }

    public void setLunchLabel(String lunchLabel) {
        LunchLabel = lunchLabel;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Integer isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public String toString() {
        return "Lunch{" +
                "LunchID=" + LunchID +
                ", LunchType='" + LunchType + '\'' +
                ", LunchTIme='" + LunchTIme + '\'' +
                ", LunchCont='" + LunchCont + '\'' +
                ", LunchLabel='" + LunchLabel + '\'' +
                ", UserID=" + UserID +
                ", isVisible=" + isVisible +
                '}';
    }
}
