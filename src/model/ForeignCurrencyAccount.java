package model;

import Managers.CurrencyManager;
import Managers.DataBaseManager;
import java.sql.SQLException;

public class ForeignCurrencyAccount extends Account {

    private String currencyType;

    public ForeignCurrencyAccount(String userId, String accountId, float moneyInAccount, String currencyType) {
        super(userId, accountId, moneyInAccount);
        this.currencyType = currencyType;
    }

    @Override
    public String getInformation() {
        double currentRate = CurrencyManager.getBuyRate(currencyType);
        double tlEquivalent = this.moneyInAccount * currentRate;
        return String.format("%s Hesabı | Bakiye: %.2f | TL: %.2f", currencyType, moneyInAccount, tlEquivalent);
    }

    //ZORUNLU INTERFACE METODU
    @Override
    public void transferToCurrent(float moneyAmount) throws SQLException {
        this.moneyInAccount -= moneyAmount;
        DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);
    }

    @Override
    public void transferToCurrent() throws SQLException {

    }

    // 1. DÖVİZ AL (TL Hesabından Para Çeker -> Döviz Hesabına Ekler)
    public boolean buyCurrency(CheckingAccount tlAccount, double amountToBuy) {
        // amountToBuy: Alınacak döviz miktarı (Örn: 100 Dolar)
        if (amountToBuy <= 0) return false;

        //Gereken TL Tutarını Hesapla
        double rate = Managers.CurrencyManager.getSellRate(this.currencyType);
        double tlRequired = amountToBuy * rate;

        try {
            //TL Hesabından Parayı Çekmeyi Dene
            tlAccount.withdraw(tlRequired);

            //TL Hesabını Veritabanına Kaydet
            boolean tlSaved = Managers.DataBaseManager.saveAccount(tlAccount);
            if (!tlSaved) {
                tlAccount.deposit(tlRequired);
                return false;
            }

            //Döviz Hesabına Ekle
            this.moneyInAccount += amountToBuy;

            //Döviz Hesabını Veritabanına Kaydet
            boolean forexUpdated = Managers.DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);

            if (forexUpdated) {
                return true; // İşlem Başarılı
            } else {
                this.moneyInAccount -= amountToBuy;
                tlAccount.deposit(tlRequired);
                Managers.DataBaseManager.saveAccount(tlAccount);
                return false;
            }

        } catch (Exceptions.YetersizBakiyeException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //DÖVİZ SAT (Döviz Hesabından Çeker -> TL Hesabına Ekler)
    public boolean sellCurrency(CheckingAccount tlAccount, double forexAmountToSell) {
        if (forexAmountToSell <= 0) return false;


        if (this.moneyInAccount < forexAmountToSell) return false; // Yetersiz Döviz

        double rate = Managers.CurrencyManager.getBuyRate(this.currencyType); // Banka Alış Kuru
        double tlGained = forexAmountToSell * rate;

        this.moneyInAccount -= forexAmountToSell;

        //Döviz Hesabını Güncelle
        boolean forexUpdated = Managers.DataBaseManager.updateBalance(this.accountId, this.moneyInAccount);

        if (forexUpdated) {
            //TL Hesabına Ekle
            tlAccount.addMoneyToAccount((float)tlGained);
            return true;
        } else {
            this.moneyInAccount += forexAmountToSell;
            return false;
        }
    }

    @Override
    public boolean withdraw(double amount) throws Exceptions.YetersizBakiyeException {
        if (this.moneyInAccount < amount) {
            throw new Exceptions.YetersizBakiyeException("Döviz Bakiyesi Yetersiz", this.moneyInAccount, amount);
        }
        this.moneyInAccount -= amount;
        return true;
    }
}