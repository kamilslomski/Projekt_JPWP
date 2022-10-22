package lab2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pupile {
    Scanner scanner = new Scanner(System.in);

    List<ZwierzakiDomowe> lista = new ArrayList<>();

    public void dodajPupila(){
        System.out.println("Podaj typ zwierzatka (Kotel, Piesel): ");
        String typ = scanner.next();
        if(typ.equalsIgnoreCase("Piesel")){
            System.out.println("Podaj nazwe: ");
            String n = scanner.next();
            System.out.println("Podaj wiek: ");
            int w = scanner.nextInt();
            Piesel piesel = new Piesel(n,w);
            lista.add(piesel);
            int wszystkie = Piesel.getIlosc_zwierzakow();
            wszystkie++;
            Piesel.setIlosc_zwierzakow(wszystkie);
        }else if(typ.equalsIgnoreCase("Kotel")) {
            System.out.println("Podaj nazwe: ");
            String n = scanner.next();
            System.out.println("Podaj wiek: ");
            int w = scanner.nextInt();
            Kotel kotel = new Kotel(n,w);
            lista.add(kotel);
            int wszystkie = Kotel.getIlosc_zwierzakow();
            wszystkie++;
            Kotel.setIlosc_zwierzakow(wszystkie);
        }else{
            System.out.println("Zły pupil (Wrrrrr) ");
        }
    }

}
