
import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame {

    JPanel gora;
    JPanel panelplotna;
    JPanel przyciski;
    private Color kolor;

    Okno(String nazwa){
        super(nazwa);

        kolor = Color.yellow;
        setSize(400, 400);
        Dimension minSize = new Dimension(300, 300);
        setMinimumSize(minSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gora = new JPanel();
        gora.setLayout(new BorderLayout());
        gora.setPreferredSize(new Dimension(400, 100));
        gora.setBackground(Color.LIGHT_GRAY);

        panelplotna = new JPanel();
        panelplotna.setBackground(Color.BLACK);

        JLabel txt = new JLabel("Jakiego koloru linię chcesz rysować");
        txt.setHorizontalAlignment(SwingConstants.CENTER);

        JCheckBox jasnoniebieski = new JCheckBox("Jasno-niebieski");
        jasnoniebieski.setBackground(Color.cyan);
        JCheckBox zolty = new JCheckBox("Zolty", true);
        zolty.setBackground(Color.yellow);

        ButtonGroup grupaprzyciskow = new ButtonGroup();
        grupaprzyciskow.add(jasnoniebieski);
        grupaprzyciskow.add(zolty);

        przyciski = new JPanel();
        przyciski.setLayout(new GridLayout(2,1));
        przyciski.add(jasnoniebieski);
        przyciski.add(zolty);

        gora.add(txt, BorderLayout.NORTH);
        gora.add(przyciski, BorderLayout.CENTER);

        add(gora, BorderLayout.NORTH);
        add(panelplotna, BorderLayout.CENTER);

        plotno plotno = new plotno();
        plotno.ustaw_kolor(kolor);

        zolty.addItemListener(e -> {
            if(zolty.isSelected()){
                System.out.println("Zolty zaznaczony!");
                kolor = Color.yellow;
                plotno.ustaw_kolor(kolor);
                plotno.requestFocusInWindow();
            }
        });

        jasnoniebieski.addItemListener(e -> {
            if(jasnoniebieski.isSelected()){
                System.out.println("Jasno-niebieski zaznaczony!");
                kolor = Color.cyan;
                plotno.ustaw_kolor(kolor);
                plotno.requestFocusInWindow();
            }
        });

        panelplotna.add(plotno);

    }
}
