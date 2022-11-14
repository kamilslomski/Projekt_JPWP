import java.util.concurrent.ThreadLocalRandom;

public class liczenie {


    static int min;
    static int max;
    int i=0;

    public static String easy() {
       String liczba;
       int wynik;
       max=10;
       min=1;

       int pierwsza = ThreadLocalRandom.current().nextInt(min, max + 1);
       int druga = ThreadLocalRandom.current().nextInt(min, max + 1);

       liczba=String.valueOf(pierwsza)+"*"+String.valueOf(druga)+"=";
       wynik=pierwsza*druga;
       return liczba;
    }
    public static String normal() {
        String liczba;
        int wynik;
        max=31;
        min=1;

        int pierwsza = ThreadLocalRandom.current().nextInt(min, max + 1);
        int druga = ThreadLocalRandom.current().nextInt(min, max + 1);

        liczba=String.valueOf(pierwsza)+"*"+String.valueOf(druga)+"=";
        wynik=pierwsza*druga;
        return liczba;
    }
    public static String hard() {
        String liczba;
        int wynik;
        max=100;
        min=1;

        int pierwsza = ThreadLocalRandom.current().nextInt(min, max + 1);
        int druga = ThreadLocalRandom.current().nextInt(min, max + 1);

        liczba=String.valueOf(pierwsza)+"*"+String.valueOf(druga)+"=";
        wynik=pierwsza*druga;

        return liczba;
    }


}

