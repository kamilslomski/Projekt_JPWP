import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends  JFrame implements ActionListener {
   Body body = new Body();
   JPanel top;
    JPanel panel;
    JPanel przyciski;
    JPanel bottom;
    JPanel answer;
    JPanel time;
   JButton exit;
   JButton easy;
   JButton normal;
   JButton hard;
   JLabel timeLabel;
   JLabel result;
   JLabel question;

     Window(String nazwa) {
        super(nazwa);

        setSize(1280, 1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        top = new JPanel();
        //top.setFont(getFont().deriveFont(Font.BOLD, 20)); coś nie dziala - musze poczytać
        top.setPreferredSize(new Dimension(1280, 200));
        top.setLayout(new GridLayout(1, 3));
        top.setBackground(Color.LIGHT_GRAY);


        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(body);

        bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        bottom.setPreferredSize(new Dimension(1280, 80));

        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        exit = new JButton();
        easy = new JButton();
        normal = new JButton();
        hard = new JButton();

        exit.setFocusable(false);
        exit.addActionListener(this);
        exit.setText("EXIT");

        easy.setFocusable(false);
        easy.addActionListener(this);
        easy.setText("EASY");

        normal.setFocusable(false);
        normal.addActionListener(this);
        normal.setText("NORMAL");

        hard.setFocusable(false);
        hard.addActionListener( this);
        hard.setText("HARD");


        JLabel answer_labelA = new JLabel();
        JLabel answer_labelB = new JLabel();
        JLabel answer_labelC = new JLabel();
        JLabel answer_labelD = new JLabel();
        timeLabel = new JLabel();
        result = new JLabel();
        question = new JLabel();

        question.setText("Działanie do wykonania");
        question.setBounds(600,150,50,50);

        result.setText("Wynik: 0");
        result.setBounds(50,50,50,50);

        timeLabel.setText("Czas: ");
        timeLabel.setBounds(800,60,50,50);

        przyciski = new JPanel();
        przyciski.setLayout(new GridLayout(1, 4));
        przyciski.add(easy);
        przyciski.add(normal);
        przyciski.add(hard);
        przyciski.add(exit);

      /*
        time = new JPanel();
        time.setLayout(new GridLayout(1, 3));
        time.add(timeLabel);
        time.add(question);
        time.add(result);

       */
        JPanel topL = new JPanel();
        JPanel topS = new JPanel();
        JPanel topP = new JPanel();

        topL.setLayout(new GridBagLayout());
        topP.setLayout(new GridBagLayout());
        topP.add(result);
        topL.add(timeLabel);
        topS.add(question);

        top.add(topL, BorderLayout.WEST);
        top.add(topS, BorderLayout.CENTER);
        top.add(topP, BorderLayout.EAST);


        answer = new JPanel();
        answer.setLayout(new GridLayout(2, 2));
        answer.add(answer_labelA);
        answer.add(answer_labelB);
        answer.add(answer_labelC);
        answer.add(answer_labelD);



        bottom.add(przyciski,BorderLayout.CENTER);


        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);



    }

   @Override
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == easy)
      {
         question.setText(liczenie.easy());
      }
      if(ae.getSource() == normal)
      {
         question.setText(liczenie.normal());
      }
      if(ae.getSource() == hard)
      {
         question.setText(liczenie.hard());
      }
      if(ae.getSource() == exit)
      {
         System.exit(0);
      }
   }
}