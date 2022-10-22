package lab2;

public class Glowna {
    public static void main(String[] args) {
        Pupile pupile = new Pupile();
        System.out.println("Dodajemy zwierze!");
        pupile.dodajPupila();
        System.out.println("Dodajemy zwierze!");
        pupile.dodajPupila();
        /*System.out.println("Dodajemy zwierze!");
        pupile.dodajPupila();
        System.out.println("Dodajemy zwierze!");
        pupile.dodajPupila(); */
        System.out.println("Nasze zwierzeta to: ");
        for (ZwierzakiDomowe a:pupile.lista) {
            a.opis();
        }
        for (ZwierzakiDomowe a:pupile.lista) {
            if(a instanceof Piesel){
                System.out.println(a.getNazwa());
                System.out.println("Cena wynosi: ");
                ((Piesel) a).getCena();
                a.jedzenie();
                a.ruch();
                a.sen();
            }else{
                System.out.println(a.getNazwa());
                ((Kotel) a).mruczenie();
            }
        }
    }
}
