import javax.swing.*;
import java.awt.*;

public class Window extends  JFrame {
    JPanel gora;
    JPanel panel;
    JPanel przyciski;

     Window(String nazwa) {
        super(nazwa);

        setSize(1280, 1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gora = new JPanel();
        gora.setLayout(new BorderLayout());
        gora.setPreferredSize(new Dimension(1280, 224));
        gora.setBackground(Color.LIGHT_GRAY);

        panel = new JPanel();
        panel.setBackground(Color.BLACK);

        przyciski = new JPanel();
        przyciski.setLayout(new GridLayout(1, 2));

        JTextField textField = new JTextField();
        JTextArea textArea = new JTextArea();
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        JButton buttonA = new JButton();
        JButton buttonB = new JButton();
        JButton buttonC = new JButton();
        JButton buttonD = new JButton();

        JButton exit = new JButton();
        JButton easy = new JButton();
        JButton normal = new JButton();
        JButton hard = new JButton();

        JLabel answer_labelA = new JLabel();
        JLabel answer_labelB = new JLabel();
        JLabel answer_labelC = new JLabel();
        JLabel answer_labelD = new JLabel();
        JLabel time_label = new JLabel();
        JLabel result = new JLabel();



    }
}
