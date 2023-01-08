import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Date;

public class Body extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(15, this);
    int x=15, vx=0, y=0, vy = 0;
    public int score=0, level, iteration = 0;
    JLabel firstFalse = new JLabel("");
    JLabel secondFalse = new JLabel("");
    JLabel correct = new JLabel("");
    int randomX = 100, randomY = 100, randomXfalse1 = 100, randomYfalse1 = 100,randomXfalse2 = 100, randomYfalse2 = 100;
    Image img = Toolkit.getDefaultToolkit().createImage("bohater.png");
    Image img2 = Toolkit.getDefaultToolkit().createImage("background.png");
    String question = "";
    JLabel scoreLabel = new JLabel("Wynik: 0");
    JLabel questionLabel = new JLabel();


    //Ustawienia głównego panelu w którym rozgrywana jest gra
    Body()
    {
        questionLabel.setText(question);
        setLayout(new GridBagLayout());
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        add(firstFalse);
        add(secondFalse);
        add(correct);
        setLayout(null);
        scoreLabel.setBounds(400,-17,50,50);
        add(scoreLabel);
        questionLabel.setBounds(800,-17,200,50);
        questionLabel.setText("Działanie do wykonania");
        add(questionLabel);

    }

    //fukncja odpowiedzialna za rysowanie postaci oraz tła
    public void paintComponent(Graphics d)
    {
        super.paintComponent(d);
        d.drawImage(img2, 0, 0, null);
        d.drawImage(img, x, y,null);
    }

    //Sprawdzanie pozycji bohatera oraz kolizji z wylosowanymi liczbami
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (correctResult(x, y, randomX, randomY)) {
            System.out.println("good intersection");
            //JOptionPane.showMessageDialog(null, "Brawo, to jest poprawny wynik!", "Wygrana", JOptionPane.INFORMATION_MESSAGE);
            score++;
            iteration++;
            again();
        }
        if (falseResult1(x, y, randomXfalse1, randomYfalse1)) {
            System.out.println("bad intersection");
            iteration++;
            again();
        }
        if (falseResult2(x, y, randomXfalse2, randomYfalse2)) {
            System.out.println("bad intersection");
            iteration++;
            again();
        }

        //ograniczenie pola rozgrywki
        if(x<0)
        {
            x=0;
            vx=0;
        }
        if(x>1245)
        {
            x=1245;
            vx=0;
        }
        if(y<15)
        {
            y=15;
            vy=0;
        }
        if(y>650)
        {
            y=650;
            vy=0;
        }
        x = x+vx;
        y = y+vy;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    //zmienne odpowiedzialne za zapis wyników do pliku .txt
    FileWriter fWritter = null;
    BufferedWriter bWritter = null;
    PrintWriter print = null;
    Date date = new Date();

    //funckja odpowiedzialna za ponowne losowanie i rysowanie liczb
    public void again(){
        scoreLabel.setText("Wynik " + score);
            if (iteration >= 5) {
                try
                {
                    fWritter = new FileWriter("Wynki.txt", true);
                    bWritter = new BufferedWriter(fWritter);
                    print = new PrintWriter(bWritter);

                    print.println("Koniec gry, otrzymano: " + score + " punktów. Data podejścia: " + date);
                    print.flush();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Koniec gry, otrzymano " + score + " punktów", "Koniec", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            else if (level == 1) {
                questionLabel.setText(liczenie.easy());
                losowanie(liczenie.result_e(), liczenie.falseResult_e1(), liczenie.falseResult_e2());
            } else if (level == 2) {
                questionLabel.setText(liczenie.normal());
                losowanie(liczenie.result_n(), liczenie.falseResult_n1(), liczenie.falseResult_n2());
            } else if (level == 3) {
                questionLabel.setText(liczenie.hard());
                losowanie(liczenie.result_h(), liczenie.falseResult_h1(), liczenie.falseResult_h2());
            } else {
                JOptionPane.showMessageDialog(null, "Niestety, coś nie działa!", "Niestety", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
    }

    //Poruszanie się postacią po ekranie (1)
    @Override
    public void keyPressed(KeyEvent e)
    {
        int a = e.getKeyCode();
        if(a == KeyEvent.VK_LEFT)
        {vx=-5; vy=0;}
        if(a == KeyEvent.VK_RIGHT)
        { vx=5; vy=0; }
        if(a == KeyEvent.VK_UP)
        { vy=-5; vx=0; }
        if(a == KeyEvent.VK_DOWN)
        { vy=5; vx=0; }
    }

    //Poruszanie się postacią po ekranie (2)
    @Override
    public void keyReleased(KeyEvent e)
    {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT) { vx=0; }
        if(c == KeyEvent.VK_RIGHT) { vx=0; }
        if(c == KeyEvent.VK_UP) { vy=0; }
        if(c == KeyEvent.VK_DOWN) { vy=0; }
    }

    //sprawdzanie kolizji z niepoprawnym wynikiem (1)
    public boolean falseResult1 (int x, int  y, int randomXfalse1, int randomYfalse1){
        Rectangle label = new Rectangle(randomXfalse1, randomYfalse1, 50, 50);

        Rectangle result = SwingUtilities.computeIntersection(x, y, 20, 20, label);

        return (result.getWidth() > 0 && result.getHeight() > 0);
    }

    //sprawdzanie kolizji z niepoprawnym wynikiem (2)
    public boolean falseResult2 (int x, int  y, int randomXfalse2, int randomYfalse2){
        Rectangle label = new Rectangle(randomXfalse2, randomYfalse2, 50, 50);

        Rectangle result = SwingUtilities.computeIntersection(x, y, 20, 20, label);

        return (result.getWidth() > 0 && result.getHeight() > 0);
    }

    //sprawdzanie kolizji z poprawnym wynikiem
    public boolean correctResult (int x, int  y, int randomX, int randomY){
        Rectangle label = new Rectangle(randomX, randomY, 50, 50);

        Rectangle result = SwingUtilities.computeIntersection(x, y, 20, 20, label);

        return (result.getWidth() > 0 && result.getHeight() > 0);
    }

    //losowanie współrzędnej X poprawnego wyniku
    public int randomX(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(1100)+50;
        randomX = x;
        return x;
    }

    //losowanie współrzędnej Y poprawnego wyniku
    public int randomY(){
        int y;
        Random rand = new Random();
        y = rand.nextInt(500)+50;
        randomY = y;
        return y;
    }

    //losowanie współrzędnej X niepoprawnego wyniku
    public int randomXfalse1(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(1100)+50;
        randomXfalse1 = x;
        return x;
    }

    //losowanie współrzędnej Y niepoprawnego wyniku
    public int randomYfalse1(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(500)+50;
        randomYfalse1 = x;
        return x;
    }

    //losowanie współrzędnej X niepoprawnego wyniku
    public int randomXfalse2(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(1100)+50;
        randomXfalse2 = x;
        return x;
    }

    //losowanie współrzędnej Y niepoprawnego wyniku
    public int randomYfalse2(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(500)+50;
        randomYfalse2 = x;
        return x;
    }

    //ustalanie parametrów (czcionki, rozmiaru, wielkości, wartości, współrzędnych) wylosowanych wyników
    public void losowanie(int temp, String temp2,String temp3){
        firstFalse.setText(temp2);
        firstFalse.setLocation(this.randomXfalse1(),randomYfalse1());
        firstFalse.setSize(50,50);
        firstFalse.setFont(new Font("Arial", Font.ITALIC, 20));

        secondFalse.setText(temp3);
        secondFalse.setLocation(this.randomXfalse2(),randomYfalse2());
        secondFalse.setSize(50,50);
        secondFalse.setFont(new Font("Arial", Font.ITALIC, 20));

        correct.setText(String.valueOf(temp));
        correct.setLocation(this.randomX(),randomY());
        correct.setSize(50,50);
        correct.setFont(new Font("Arial", Font.ITALIC, 20));
    }
}
