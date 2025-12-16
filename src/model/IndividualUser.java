package model;
import java.time.LocalDate;

public class IndividualUser extends User {

    private  String name;
    private  String surname;
    private  String password;
    private  String tc_Kimlik;
    private  LocalDate birthDate;
    private  String city;
    private  String phoneNumber;

    public IndividualUser(String userId,String name,String surname,String password,String tc_Kimlik,LocalDate birthDate,String city,String phoneNumber)
    {
        super(userId);
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.tc_Kimlik = tc_Kimlik;
        this.birthDate = birthDate;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getInformation() {
        return "";
    }
}
