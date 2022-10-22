
import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame {

    Okno(String nazwa) {

        super(nazwa);
        setSize(400, 400);
        setMinimumSize(new Dimension(300, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());

        JPanel gora = new JPanel();
        gora.setLayout(new BorderLayout());
        gora.setPreferredSize(new Dimension(400, 100));

        JLabel tekst = new JLabel("Jakiego koloru linie chcesz rysować?");
        tekst.setHorizontalAlignment(SwingConstants.CENTER);
        tekst.setPreferredSize(new Dimension(400, 50));
        gora.add(tekst, BorderLayout.NORTH);

        String[] wyborkolorow = {"Jasno-niebieski", "Zolty"};
        JComboBox wybor = new JComboBox(wyborkolorow);
        gora.add(wybor);

        add(gora, BorderLayout.NORTH);

        JPanel oknoplotna = new JPanel();
        oknoplotna.setBackground(Color.white);
        oknoplotna.setPreferredSize(new Dimension(300, 250));
        Rysowanie rysowanie = new Rysowanie();
        rysowanie.ustawionykolor(Color.cyan);
        oknoplotna.add(rysowanie);

        add(oknoplotna);

        wybor.addActionListener(e -> {
            if (wybor.getSelectedIndex() == 0) {
                System.out.println("Wybrales jasno-niebieski!");
               rysowanie.ustawionykolor(Color.cyan);
            } else {
                System.out.println("Wybrales Zolty!");
                rysowanie.ustawionykolor(Color.yellow);
            }
        });
    }
}