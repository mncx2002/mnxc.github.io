package per.ja.pojo;

public class Admin {
    //管理员
    Integer AdminID;
    String AdminAccount;
    String AdminPhone;
    String AdminPWD;
    String AdminName;

    public Admin(String adminPhone, String adminPWD, String adminName) {
        AdminPhone = adminPhone;
        AdminPWD = adminPWD;
        AdminName = adminName;
    }

    public Admin() {
    }

    public Integer getAdminID() {
        return AdminID;
    }

    public void setAdminID(Integer adminID) {
        AdminID = adminID;
    }

    public String getAdminAccount() {
        return AdminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        AdminAccount = adminAccount;
    }

    public String getAdminPhone() {
        return AdminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        AdminPhone = adminPhone;
    }

    public String getAdminPWD() {
        return AdminPWD;
    }

    public void setAdminPWD(String adminPWD) {
        AdminPWD = adminPWD;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "AdminID=" + AdminID +
                ", AdminAccount='" + AdminAccount + '\'' +
                ", AdminPhone='" + AdminPhone + '\'' +
                ", AdminPWD='" + AdminPWD + '\'' +
                ", AdminName='" + AdminName + '\'' +
                '}';
    }
}
