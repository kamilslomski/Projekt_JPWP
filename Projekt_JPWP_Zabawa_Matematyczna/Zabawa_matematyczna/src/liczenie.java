import java.util.concurrent.ThreadLocalRandom;

public class liczenie {

    //inicjalizacja zmiennych potrzebnych do losowania
    static int min;
    static int max;
    static int fe,fn,fh,se,sn,sh;

    //losowanie pierwszej oraz drugiej liczby oraz tworzenie stringa przechowującego działanie dla poziomu łatwego
    public static String easy() {
       String number;
       max=10;
       min=1;
       fe = ThreadLocalRandom.current().nextInt(min, max + 1);
       se = ThreadLocalRandom.current().nextInt(min, max + 1);
       number=String.valueOf(fe)+"*"+String.valueOf(se)+"=";
       return number;
    }

    //obliczenie wyniku dla wylosowanych liczb poziomu łatwego
    public static int result_e(){
        int result=fe*se;
        return result;
    }

    //losowanie pierwszej oraz drugiej liczby oraz tworzenie stringa przechowującego działanie dla poziomu normalnego
    public static String normal() {
        String number;
        max=31;
        min=1;
        fn = ThreadLocalRandom.current().nextInt(min, max + 1);
        sn = ThreadLocalRandom.current().nextInt(min, max + 1);
        number=String.valueOf(fn)+"*"+String.valueOf(sn)+"=";
        return number;
    }

    //obliczenie wyniku dla wylosowanych liczb poziomu normalnego
    public static int result_n(){
        int result=fn*sn;
        return result;
    }

    //losowanie pierwszej oraz drugiej liczby oraz tworzenie stringa przechowującego działanie dla poziomu trudnego
    public static String hard() {
        String number;
        max=100;
        min=1;
        fh = ThreadLocalRandom.current().nextInt(min, max + 1);
        sh = ThreadLocalRandom.current().nextInt(min, max + 1);
        number=String.valueOf(fh)+"*"+String.valueOf(sh)+"=";
        return number;
    }

    //obliczenie wyniku dla wylosowanych liczb poziomu trudnego
    public static int result_h(){
        int result=fh*sh;
        return result;
    }

    //losowanie pierwszej oraz drugiej liczby oraz tworzenie stringa przechowującego działanie pierwszej fałszywej liczby dla poziomu łatwego
    public static String falseResult_e1(){
        max=10;
        min=1;
        int fe = ThreadLocalRandom.current().nextInt(min, max + 1);
        int se = ThreadLocalRandom.current().nextInt(min, max + 1);
        int result=fe*se;
        String number = String.valueOf(result);
        return number;
    }

    //losowanie pierwszej oraz drugiej liczby oraz tworzenie stringa przechowującego działanie pierwszej fałszywej liczby dla poziomu normalnego
    public static String falseResult_n1(){
        max=31;
        min=1;
        int fe = ThreadLocalRandom.current().nextInt(min, max + 1);
        int se = ThreadLocalRandom.current().nextInt(min, max + 1);
        int result=fe*se;
        String number = String.valueOf(result);
        return number;
    }

    //losowanie pierwszej oraz drugiej liczby oraz tworzenie stringa przechowującego działanie pierwszej fałszywej liczby dla poziomu trudnego
    public static String falseResult_h1(){
        max=100;
        min=1;
        int fe = ThreadLocalRandom.current().nextInt(min, max + 1);
        int se = ThreadLocalRandom.current().nextInt(min, max + 1);
        int result=fe*se;
        String number = String.valueOf(result);
        return number;
    }

    //losowanie pierwszej oraz drugiej liczby oraz tworzenie stringa przechowującego działanie drugiej fałszywej liczby dla poziomu łatwego
    public static String falseResult_e2(){
        max=10;
        min=1;
        int fe = ThreadLocalRandom.current().nextInt(min, max + 1);
        int se = ThreadLocalRandom.current().nextInt(min, max + 1);
        int result=fe*se;
        String number = String.valueOf(result);
        return number;
    }

    //losowanie pierwszej oraz drugiej liczby oraz tworzenie stringa przechowującego działanie drugiej fałszywej liczby dla poziomu normalnego
    public static String falseResult_n2(){
        max=31;
        min=1;
        int fe = ThreadLocalRandom.current().nextInt(min, max + 1);
        int se = ThreadLocalRandom.current().nextInt(min, max + 1);
        int result=fe*se;
        String number = String.valueOf(result);
        return number;
    }

    //losowanie pierwszej oraz drugiej liczby oraz tworzenie stringa przechowującego działanie drugiej fałszywej liczby dla poziomu trudnego
    public static String falseResult_h2(){
        max=100;
        min=1;
        int fe = ThreadLocalRandom.current().nextInt(min, max + 1);
        int se = ThreadLocalRandom.current().nextInt(min, max + 1);
        int result=fe*se;
        String number = String.valueOf(result);
        return number;
    }
}

