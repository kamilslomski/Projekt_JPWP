import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Body extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(15, this);
    int x, vx, y, vy = 0, score=-1;
    JLabel firstFalse = new JLabel("");
    JLabel secondFalse = new JLabel("");
    JLabel correct = new JLabel("");
    int randomX = 100, randomY = 100, randomXfalse1 = 100, randomYfalse1 = 100,randomXfalse2 = 100, randomYfalse2 = 100;
    Image img = Toolkit.getDefaultToolkit().createImage("bohater.png");
    Image img2 = Toolkit.getDefaultToolkit().createImage("background.png");
    Body()
    {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.add(firstFalse);
        this.add(secondFalse);
        this.add(correct);
    }

//    public void paint(Graphics g)
//    {
//        g.drawImage(img2, 0, 0, null);
//    }
    public void paintComponent(Graphics d)
    {
        super.paintComponent(d);
        d.drawImage(img, x, y,null);
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (correctResult(x, y, randomX, randomY)) {
            System.out.println("good intersection");
            JOptionPane.showMessageDialog(null, "Brawo, to jest poprawny wynik!", "Wygrana", JOptionPane.INFORMATION_MESSAGE);
            someoneScored();

            System.exit(0);
        }
        if (falseResult1(x, y, randomXfalse1, randomYfalse1)) {
            System.out.println("bad intersection");
            JOptionPane.showMessageDialog(null, "Niestety, to jest niepoprawny wynik!", "Niestety", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if (falseResult2(x, y, randomXfalse2, randomYfalse2)) {
            System.out.println("bad intersection");
            JOptionPane.showMessageDialog(null, "Niestety, to jest niepoprawny wynik!", "Niestety", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }


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
        if(y<0)
        {
            y=0;
            vy=0;
        }
        if(y>462)
        {
            y=462;
            vy=0;
        }

        x = x+vx;
        y = y+vy;
        repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
    public int someoneScored(){
        score++;
        return score;
    }
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

    @Override
    public void keyReleased(KeyEvent e)
    {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT) { vx=0; }
        if(c == KeyEvent.VK_RIGHT) { vx=0; }
        if(c == KeyEvent.VK_UP) { vy=0; }
        if(c == KeyEvent.VK_DOWN) { vy=0; }
    }

    public boolean falseResult1 (int x, int  y, int randomXfalse1, int randomYfalse1){
        Rectangle label = new Rectangle(randomXfalse1, randomYfalse1, 50, 50);

        Rectangle result = SwingUtilities.computeIntersection(x, y, 20, 20, label);

        return (result.getWidth() > 0 && result.getHeight() > 0);
    }

    public boolean falseResult2 (int x, int  y, int randomXfalse2, int randomYfalse2){
        Rectangle label = new Rectangle(randomXfalse2, randomYfalse2, 50, 50);

        Rectangle result = SwingUtilities.computeIntersection(x, y, 20, 20, label);

        return (result.getWidth() > 0 && result.getHeight() > 0);
    }

    public boolean correctResult (int x, int  y, int randomX, int randomY){
        Rectangle label = new Rectangle(randomX, randomY, 50, 50);

        Rectangle result = SwingUtilities.computeIntersection(x, y, 20, 20, label);

        return (result.getWidth() > 0 && result.getHeight() > 0);
    }

    public int randomX(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(1100)+50;
        randomX = x;
        return x;
    }

    public int randomY(){
        int y;
        Random rand = new Random();
        y = rand.nextInt(500)+50;
        randomY = y;
        return y;
    }

    public int randomXfalse1(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(1100)+50;
        randomXfalse1 = x;
        return x;
    }

    public int randomYfalse1(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(500)+50;
        randomYfalse1 = x;
        return x;
    }
    public int randomXfalse2(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(1100)+50;
        randomXfalse2 = x;
        return x;
    }

    public int randomYfalse2(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(500)+50;
        randomYfalse2 = x;
        return x;
    }

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
