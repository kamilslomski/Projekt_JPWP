
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class plotno extends Canvas {

    private Color kolor;
    ArrayList<Point> points = new ArrayList();
    ArrayList<Color> colors = new ArrayList();

    public void ustaw_kolor(Color kolor){
        this.kolor = kolor;
    }

    public plotno() {

        setPreferredSize(new Dimension(350, 250));
        setBackground(Color.gray);
        points.add(new Point(0, 0));
        colors.add(Color.yellow);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent klaw) {
                int kod = klaw.getKeyCode();

                switch (kod) {
                    case KeyEvent.VK_UP -> {
                        Point pointU = new Point(points.get(points.size() - 1));
                        pointU.y -= 10;
                        points.add(pointU);
                        colors.add(kolor);
                    }
                    case KeyEvent.VK_DOWN -> {
                        Point pointD = new Point(points.get(points.size() - 1));
                        pointD.y += 10;
                        points.add(pointD);
                        colors.add(kolor);
                    }
                    case KeyEvent.VK_LEFT -> {
                        Point pointL = new Point(points.get(points.size() - 1));
                        pointL.x -= 10;
                        points.add(pointL);
                        colors.add(kolor);
                    }
                    case KeyEvent.VK_RIGHT -> {
                        Point pointR = new Point(points.get(points.size() - 1));
                        pointR.x += 10;
                        points.add(pointR);
                        colors.add(kolor);
                    }
                }
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics grafika){
        if(points.size() > 1) {
            for(int i=0; i < points.size()-1; i++) {
                grafika.setColor(colors.get(i));
                grafika.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y);
            }
        }
    }

}
