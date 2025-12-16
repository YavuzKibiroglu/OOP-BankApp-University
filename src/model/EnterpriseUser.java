package model;
import java.time.LocalDate;

public class EnterpriseUser extends User{

    private String enterpriseName;
    private  LocalDate enterpriseEstablishment;
    private  String enterpriseHQ;

    public EnterpriseUser(String userId, String enterpriseName, LocalDate enterpriseEstablishment, String enterpriseHQ) {
        super(userId);
        this.enterpriseName = enterpriseName;
        this.enterpriseEstablishment = enterpriseEstablishment;
        this.enterpriseHQ = enterpriseHQ;
    }

    @Override
    public String getInformation() {
        return "";
    }
}
