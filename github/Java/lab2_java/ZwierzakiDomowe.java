package lab2;

public abstract class ZwierzakiDomowe implements Zwierzaki{
    private String nazwa;
    private int lata;
    private static int ilosc_zwierzakow;

    public ZwierzakiDomowe(String nazwa, int lata) {
        this.nazwa = nazwa;
        this.lata = lata;
    }

    public abstract void pupilek();

    public void opis(){
        System.out.println("Nazywam sie: " + nazwa + ". Mam " + lata + " lat.");
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getLata() {
        return lata;
    }

    public void setLata(int lata) {
        this.lata = lata;
    }

    public static int getIlosc_zwierzakow() {
        return ilosc_zwierzakow;
    }

    public static void setIlosc_zwierzakow(int ilosc_zwierzakow) {
        ZwierzakiDomowe.ilosc_zwierzakow = ilosc_zwierzakow;
    }

}
