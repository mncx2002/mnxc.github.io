package per.ja.pojo;

public class Message {
    Integer MsgID;
    String MsgCont;
    String MsgTime;
    Integer FMsgID;
    Integer UserID ;
    Integer LunchID;
    String GrowthRecord;
    Integer isVisible;

    public Message(String msgCont, String msgTime, Integer FMsgID, Integer userID, Integer lunchID, String growthRecord) {
        MsgCont = msgCont;
        MsgTime = msgTime;
        this.FMsgID = FMsgID;
        UserID = userID;
        LunchID = lunchID;
        GrowthRecord = growthRecord;
    }

    public Message(Integer msgID, String msgCont, String msgTime, Integer FMsgID, Integer userID, Integer lunchID, String growthRecord, Integer isVisible) {
        MsgID = msgID;
        MsgCont = msgCont;
        MsgTime = msgTime;
        this.FMsgID = FMsgID;
        UserID = userID;
        LunchID = lunchID;
        GrowthRecord = growthRecord;
        this.isVisible = isVisible;
    }

    public Message() {
    }

    public Integer getMsgID() {
        return MsgID;
    }

    public void setMsgID(Integer msgID) {
        MsgID = msgID;
    }

    public String getMsgCont() {
        return MsgCont;
    }

    public void setMsgCont(String msgCont) {
        MsgCont = msgCont;
    }

    public String getMsgTime() {
        return MsgTime;
    }

    public void setMsgTime(String msgTime) {
        MsgTime = msgTime;
    }

    public Integer getFMsgID() {
        return FMsgID;
    }

    public void setFMsgID(Integer FMsgID) {
        this.FMsgID = FMsgID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getLunchID() {
        return LunchID;
    }

    public void setLunchID(Integer lunchID) {
        LunchID = lunchID;
    }

    public String getGrowthRecord() {
        return GrowthRecord;
    }

    public void setGrowthRecord(String growthRecord) {
        GrowthRecord = growthRecord;
    }

    public Integer getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Integer isVisible) {
        this.isVisible = isVisible;
    }
}
