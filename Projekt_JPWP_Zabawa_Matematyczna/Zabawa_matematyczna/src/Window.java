import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Window extends  JFrame implements ActionListener {
   Body body = new Body();
   JPanel top;
    JPanel panel;
    JPanel buttons;
    JPanel bottom;
    JPanel answer;
   JButton exit;
   JButton easy;
   JButton normal;
   JButton hard;
   JLabel timeLabel;
   JLabel result;
   JLabel question;
   Timer timer;
   int second, minute,temp;
   String ddSecond, ddMinute;
   DecimalFormat dFormat = new DecimalFormat("00");
   Image img = Toolkit.getDefaultToolkit().createImage("background.png");

     Window(String nazwa) {
        super(nazwa);

        setSize(1280, 1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        top = new JPanel();
        top.setPreferredSize(new Dimension(1280, 80));
        top.setLayout(new GridLayout(1, 3));
        top.setBackground(Color.LIGHT_GRAY);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(body);

        bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        bottom.setPreferredSize(new Dimension(1280, 60));

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

        timeLabel.setText("00:00");
        timeLabel.setVisible(true);
        timeLabel.setBounds(800,60,50,50);

        question.setText("Działanie do wykonania");
        question.setBounds(600,150,50,50);

        result.setText("Wynik: " + body.someoneScored());
        result.setBounds(50,50,50,50);

        buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 4));
        buttons.add(easy);
        buttons.add(normal);
        buttons.add(hard);
        buttons.add(exit);

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

        bottom.add(buttons,BorderLayout.CENTER);

        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }
   public void normalTimer() {
      second =0;
      minute =0;
      if ( timer != null && timer.isRunning() ) return;
      timer = new Timer(1000, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            second++;
            ddSecond = dFormat.format(second);
            ddMinute = dFormat.format(minute);
            timeLabel.setText(ddMinute + ":" + ddSecond);

            if(second==60) {
               second=0;
               minute++;
               ddSecond = dFormat.format(second);
               ddMinute = dFormat.format(minute);
               timeLabel.setText(ddMinute + ":" + ddSecond);
            }
         }
      });
   }


   @Override
   public void actionPerformed(ActionEvent ae)
   {
      for(int i=1; i<5; i++){
      if(ae.getSource() == easy) {

         question.setText(liczenie.easy());
         normalTimer();
         timer.restart();
         body.setLayout(null);
         body.losowanie(liczenie.result_e(), liczenie.falseResult_e1(), liczenie.falseResult_e2());
      }
      }
      if(ae.getSource() == normal)
      {
         question.setText(liczenie.normal());
         normalTimer();
         timer.restart();
         body.losowanie(liczenie.result_n(), liczenie.falseResult_n1(),liczenie.falseResult_n2());
      }
      if(ae.getSource() == hard)
      {
         question.setText(liczenie.hard());
         normalTimer();
         timer.restart();
         body.losowanie(liczenie.result_h(), liczenie.falseResult_h1(),liczenie.falseResult_h2());
      }
      if(ae.getSource() == exit)
      {
         System.exit(0);
      }
   }
}
