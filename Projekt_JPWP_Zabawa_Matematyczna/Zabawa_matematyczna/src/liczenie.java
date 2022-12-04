import java.util.concurrent.ThreadLocalRandom;

public class liczenie {


    static int min;
    static int max;

    public static int first_e(){
        max=10;
        min=1;
        int first = ThreadLocalRandom.current().nextInt(min, max + 1);
        return first;
    }

    public static int second_e(){
        max=10;
        min=1;
        int second = ThreadLocalRandom.current().nextInt(min, max + 1);
        return second;
    }

    public static String easy() {
       String number;
       int fe = first_e();
       int se = second_e();
       number=String.valueOf(fe)+"*"+String.valueOf(se)+"=";
       return number;
    }

    public static int result_e(){
        int fe = first_e();
        int se = second_e();
        int result=fe*se;
        return result;
    }

    public static int first_n(){
        max=31;
        min=1;
        int first = ThreadLocalRandom.current().nextInt(min, max + 1);
        return first;
    }

    public static int second_n(){
        max=31;
        min=1;
        int second = ThreadLocalRandom.current().nextInt(min, max + 1);
        return second;
    }

    public static String normal() {
        String number;
        int fe = first_n();
        int se = second_n();
        number=String.valueOf(fe)+"*"+String.valueOf(se)+"=";
        return number;
    }

    public static int result_n(){
        int fe = first_n();
        int se = second_n();
        int result=fe*se;
        return result;
    }

    public static int first_h(){
        max=100;
        min=1;
        int first = ThreadLocalRandom.current().nextInt(min, max + 1);
        return first;
    }

    public static int second_h(){
        max=100;
        min=1;
        int second = ThreadLocalRandom.current().nextInt(min, max + 1);
        return second;
    }

    public static String hard() {
        String number;
        int fe = first_h();
        int se = second_h();
        number=String.valueOf(fe)+"*"+String.valueOf(se)+"=";
        return number;
    }

    public static int result_h(){
        int fe = first_h();
        int se = second_h();
        int result=fe*se;
        return result;
    }

    public static String falseResult_e1(){
        max=10;
        min=1;
        int fe = ThreadLocalRandom.current().nextInt(min, max + 1);
        int se = ThreadLocalRandom.current().nextInt(min, max + 1);
        int result=fe*se;
        String number = String.valueOf(result);
        return number;
    }

    public static String falseResult_n1(){
        max=31;
        min=1;
        int fe = ThreadLocalRandom.current().nextInt(min, max + 1);
        int se = ThreadLocalRandom.current().nextInt(min, max + 1);
        int result=fe*se;
        String number = String.valueOf(result);
        return number;
    }

    public static String falseResult_h1(){
        max=100;
        min=1;
        int fe = ThreadLocalRandom.current().nextInt(min, max + 1);
        int se = ThreadLocalRandom.current().nextInt(min, max + 1);
        int result=fe*se;
        String number = String.valueOf(result);
        return number;
    }

    public static String falseResult_e2(){
        max=10;
        min=1;
        int fe = ThreadLocalRandom.current().nextInt(min, max + 1);
        int se = ThreadLocalRandom.current().nextInt(min, max + 1);
        int result=fe*se;
        String number = String.valueOf(result);
        return number;
    }

    public static String falseResult_n2(){
        max=31;
        min=1;
        int fe = ThreadLocalRandom.current().nextInt(min, max + 1);
        int se = ThreadLocalRandom.current().nextInt(min, max + 1);
        int result=fe*se;
        String number = String.valueOf(result);
        return number;
    }

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

