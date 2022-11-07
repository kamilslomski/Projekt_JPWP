import javax.swing.*;
import java.awt.*;

public class Window extends  JFrame {
    JPanel top;
    JPanel panel;
    JPanel przyciski;
    JPanel bottom;
    JPanel answer;
    JPanel time;

     Window(String nazwa) {
        super(nazwa);

        setSize(1280, 1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        top = new JPanel();
        top.setLayout(new BorderLayout());
        top.setPreferredSize(new Dimension(1280, 200));
        top.setBackground(Color.LIGHT_GRAY);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);

        bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        bottom.setPreferredSize(new Dimension(1280, 80));

        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        JButton buttonA = new JButton();
        JButton buttonB = new JButton();
        JButton buttonC = new JButton();
        JButton buttonD = new JButton();

        JButton exit = new JButton("EXIT");
        JButton easy = new JButton("EASY");
        JButton normal = new JButton("NORMAL");
        JButton hard = new JButton("HARD");

        JLabel answer_labelA = new JLabel();
        JLabel answer_labelB = new JLabel();
        JLabel answer_labelC = new JLabel();
        JLabel answer_labelD = new JLabel();
        JLabel time_label = new JLabel("10");
        JLabel result = new JLabel("3");
        JLabel question = new JLabel("8*4=...");

        przyciski = new JPanel();
        przyciski.setLayout(new GridLayout(1, 4));
        przyciski.add(easy);
        przyciski.add(normal);
        przyciski.add(hard);
        przyciski.add(exit);

        time = new JPanel();
        time.setLayout(new GridLayout(1, 3));
        time.add(time_label, FlowLayout.LEFT);
        time.add(question, FlowLayout.CENTER);
        time.add(result, FlowLayout.RIGHT);


        answer = new JPanel();
        answer.setLayout(new GridLayout(2, 2));
        answer.add(answer_labelA);
        answer.add(answer_labelB);
        answer.add(answer_labelC);
        answer.add(answer_labelD);

        top.add(time, BorderLayout.CENTER);

        bottom.add(przyciski, BorderLayout.CENTER);

        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        Body body = new Body();

    }
}
