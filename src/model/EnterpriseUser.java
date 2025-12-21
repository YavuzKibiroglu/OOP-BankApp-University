package model;

import java.time.LocalDate;

public class EnterpriseUser extends User {

    private String enterpriseName;
    private LocalDate enterpriseEstablishment;
    private String enterpriseHQ;
    private String corporateCode; // YENİ: Kurum Kodu Alanı

    // Constructor güncellendi: corporateCode parametresi eklendi
    public EnterpriseUser(String userId, String enterpriseName, String password, LocalDate enterpriseEstablishment, String enterpriseHQ, String corporateCode) {
        super(userId, password);
        this.enterpriseName = enterpriseName;
        this.enterpriseEstablishment = enterpriseEstablishment;
        this.enterpriseHQ = enterpriseHQ;
        this.corporateCode = corporateCode;
    }

    public String getEnterpriseName() { return enterpriseName; }
    public LocalDate getEnterpriseEstablishment() { return enterpriseEstablishment; }
    public String getEnterpriseHQ() { return enterpriseHQ; }
    @Override
    public java.time.LocalDate getBirthDate() {
        // Şirketlerin doğum günü olmaz, kuruluş tarihi olur.
        // İstersen burada null döndürebilirsin ya da kuruluş tarihini verebilirsin.
        return this.enterpriseEstablishment;
    }

    // YENİ: Getter Metodu
    @Override
    public String getUserId() { return corporateCode; }


    @Override
    public String getInformation() {
        // Bilgi çıktısına Kurum Kodu eklendi
        return String.format("Kurumsal Müşteri: %s (Kod: %s) - Merkez: %s",
                enterpriseName, corporateCode, enterpriseHQ);
    }
}
