package model;

import java.time.LocalDate;

public class IndividualUser extends User {

    private String name;
    private String surname;
    private String tcKimlik;
    private LocalDate birthDate;
    private String city;
    private String phoneNumber;

    // Constructor [cite: 41]
    public IndividualUser(String userId, String name, String surname, String password, String tcKimlik, LocalDate birthDate, String city, String phoneNumber) {
        super(userId, password); // Parent (User) sınıfına ID ve Şifreyi yolla
        this.name = name;
        this.surname = surname;
        this.tcKimlik = tcKimlik;
        this.birthDate = birthDate;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    // Getter Metotları [cite: 38]
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getCity() { return city; }
    public String getPhoneNumber() { return phoneNumber; }

    public String getTcNo() {
        return this.tcKimlik; // Hata verirse burayı değişken adınla (örn: this.TC_Kimlik) düzelt.
    }

    @Override
    public String getInformation() {
        return String.format("Bireysel Müşteri: %s %s (TC: %s) - %s",
                name, surname, tcKimlik, city);
    }
}
