
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Rysowanie extends Canvas {

    ArrayList<Point> punkty = new ArrayList();
    ArrayList<Color> kolory = new ArrayList();
    private Color kolor;

    public void ustawionykolor(Color kolor){
        this.kolor = kolor;
    }

    Rysowanie(){
        setSize(350,250);
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                punkty.add(e.getPoint());
                kolory.add(kolor);
                repaint();
            }
        });
    }

    public void paint(Graphics rysowanie){
        for(int i = 0; i<punkty.size(); i++){
            rysowanie.setColor(kolory.get(i));
            for(int j=1;j<20; j++) {
                rysowanie.drawRect(punkty.get(i).x - 10, punkty.get(i).y - 10, 20-j, 20-j);
            }
        }
    }

}










