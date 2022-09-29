package per.ja.pojo;

public class User {
    Integer UserID;
    String UserAccount;
    String UserPWD;
    String NickName;
    Integer IsActive;
    String UserPhone;
    String UserAge;

    public User() {
    }

    public User(String userAccount, String userPWD, String nickName, Integer isActive, String userPhone, String userAge) {
        UserAccount = userAccount;
        UserPWD = userPWD;
        NickName = nickName;
        IsActive = isActive;
        UserPhone = userPhone;
        UserAge = userAge;
    }

    public User(String userPWD, String nickName, Integer isActive, String userPhone, String userAge) {
        UserPWD = userPWD;
        NickName = nickName;
        IsActive = isActive;
        UserPhone = userPhone;
        UserAge = userAge;
    }

    public User(Integer userID, String userAccount, String userPWD, String nickName, Integer isActive, String userPhone, String userAge) {
        UserID = userID;
        UserAccount = userAccount;
        UserPWD = userPWD;
        NickName = nickName;
        IsActive = isActive;
        UserPhone = userPhone;
        UserAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", UserAccount='" + UserAccount + '\'' +
                ", UserPWD='" + UserPWD + '\'' +
                ", NickName='" + NickName + '\'' +
                ", IsActive=" + IsActive +
                ", UserPhone='" + UserPhone + '\'' +
                ", UserAge='" + UserAge + '\'' +
                '}';
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String userAccount) {
        UserAccount = userAccount;
    }

    public String getUserPWD() {
        return UserPWD;
    }

    public void setUserPWD(String userPWD) {
        UserPWD = userPWD;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public Integer getIsActive() {
        return IsActive;
    }

    public void setIsActive(Integer isActive) {
        IsActive = isActive;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getUserAge() {
        return UserAge;
    }

    public void setUserAge(String userAge) {
        UserAge = userAge;
    }
}
