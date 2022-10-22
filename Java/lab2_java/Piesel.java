package lab2;

import java.util.Random;

public class Piesel extends ZwierzakiDomowe{
    private double cena;

    Random random = new Random();

    public Piesel(String nazwa, int lata){
        super(nazwa,lata);
        cena = (random.nextDouble()*2000);
    }
    @Override
    public void jedzenie() {
        System.out.println("Mhmmmm, ale dobra karma dla pieskow");
    }

    @Override
    public void ruch() {
        System.out.println("Patrz kij! Aport!");
    }

    @Override
    public void sen() {
        System.out.println("Do budy!");
    }

    @Override
    public void pupilek() {
        System.out.println("Moim pupilem jest Piesel!");
    }

    public void getCena() {
        System.out.format("%.2f%n", cena);
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
