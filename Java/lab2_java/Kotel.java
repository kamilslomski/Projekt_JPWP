package lab2;

import java.util.Scanner;

public class Kotel extends ZwierzakiDomowe{
    private String mruk;

    Scanner scanner = new Scanner(System.in);

    public Kotel(String nazwa, int lata){
        super(nazwa,lata);
        System.out.println("Jak mrucze kot: ");
        mruk = scanner.next();
    }

    @Override
    public void jedzenie() {
        System.out.println("Sucha karma??? Przecież wiesz, że ja jem tylko mokrą");
    }

    @Override
    public void ruch() {
        System.out.println("Kici, kici");
    }

    @Override
    public void sen() {
        System.out.println("Jak spanie to tylko szafa albo łóżko");
    }

    @Override
    public void pupilek() {
        System.out.println("Moim pupilem jest kotel!");
    }

    public void mruczenie(){
        System.out.println("Kot mruczy: " + mruk);
    }
}
