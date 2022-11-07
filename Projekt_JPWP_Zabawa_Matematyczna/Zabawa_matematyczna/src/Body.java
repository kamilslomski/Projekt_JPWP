import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Body implements ActionListener {

    int firstNum,secondNum,task,userPick, dif;
    int correct_guesses=0;
    int time=0;
    Random liczba = new Random();
    public Body(){

    }
    public void difficultyLevel(){

        if (userPick == 1) {dif=11;}
        else if (userPick == 2) {dif=32;}
        else if (userPick == 3) {dif=101;}

    }
    public void drawNumber(){

        firstNum=liczba.nextInt(dif);
        secondNum=liczba.nextInt(dif);

    }
    public void Question(){

    }
    public void nextQuestion(){

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
     public void Answer(){
        int ans1,ans2,ans3,ans4;
        ans1=firstNum*secondNum;
        ans2=liczba.nextInt(dif)* liczba.nextInt(dif);
        ans3=liczba.nextInt(dif)* liczba.nextInt(dif);
        ans4=liczba.nextInt(dif)* liczba.nextInt(dif);
     }

     public void results(){

     }
}
