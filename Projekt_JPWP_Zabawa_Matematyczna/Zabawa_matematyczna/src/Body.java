import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;

public class Body extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(15, this);
    int x, vx, y, vy = 0;
    int i=0;

    Body()
    {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);


    }

    public void paintComponent(Graphics d)
    {

        super.paintComponent(d);
        d.setColor(Color.RED);
        d.fillRect(x,y,20,20);
        while(i<5) {
            d.setColor(Color.BLUE);
            int x1 = ThreadLocalRandom.current().nextInt(10, 1150);
            int y1 = ThreadLocalRandom.current().nextInt(20, 800);
            for(int j=1;j<20; j++) d.drawRect(x1, y1, 20-j, 20-j);
            i++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
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

    @Override
    public void keyPressed(KeyEvent e)
    {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT)
        {vx=-5; vy=0;}
        if(c == KeyEvent.VK_RIGHT)
        { vx=5; vy=0; }
        if(c == KeyEvent.VK_UP)
        { vy=-5; vx=0; }
        if(c == KeyEvent.VK_DOWN)
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
}
