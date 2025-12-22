package Exceptions;

public class YetersizBakiyeException extends Exception {

    private double mevcutBakiye;
    private double istenenTutar;

    public YetersizBakiyeException(String mesaj, double mevcutBakiye, double istenenTutar) {
        super(mesaj);
        this.mevcutBakiye = mevcutBakiye;
        this.istenenTutar = istenenTutar;
    }

    // Hata mesajını özelleştirmek için override etme
    @Override
    public String getMessage() {
        return super.getMessage() + " (Mevcut: " + mevcutBakiye + " TL, İstenen: " + istenenTutar + " TL)";
    }
}
