import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Window extends JFrame implements ActionListener {

   //utworzenie zmiennych, etykiet, paneli, przycisków

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
   Timer timer;
   int second, minute,temp;
   String ddSecond, ddMinute;
   public int level=1;
   DecimalFormat dFormat = new DecimalFormat("00");

   Window(String nazwa) {
        super(nazwa);

        //parametry JFrame'a
        setSize(1280, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ustawienia związane z górnym panelem (czasem, wynikiem oraz działaniem do wykonania)
        timeLabel = new JLabel();

        timeLabel.setText("00:00");
        timeLabel.setVisible(true);
        timeLabel.setBounds(800,60,50,20);

        setResizable(false);

        top = new JPanel();
        top.setPreferredSize(new Dimension(1280, 25));
        top.setLayout(new GridLayout(1, 3));
        top.setOpaque(true);
        top.setBackground(Color.WHITE);

        JPanel topL = new JPanel();
        JPanel topS = new JPanel();
        JPanel topP = new JPanel();

        topL.setLayout(new GridBagLayout());
        topP.setLayout(new GridBagLayout());

        topL.add(timeLabel);

        top.add(topL, BorderLayout.CENTER);

        //ustawienia związane z częścią gdzie jest rozgrywana gra
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(body);

        //ustawienia związane z menu graficznym w dolnej części ekrany
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

        buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 4));
        buttons.add(easy);
        buttons.add(normal);
        buttons.add(hard);
        buttons.add(exit);

        answer = new JPanel();
        answer.setLayout(new GridLayout(2, 2));
        answer.add(answer_labelA);
        answer.add(answer_labelB);
        answer.add(answer_labelC);
        answer.add(answer_labelD);

        bottom.add(buttons,BorderLayout.CENTER);

        //dodanie paneli do JFrame'a
        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    //ustawienia dotyczące timera
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

   //sprawdzenie który poziom trudności został wybrany oraz wykonania odpowiednich zadań z tym związanych
   @Override
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == easy)
      {
          normalTimer();
          timer.restart();
          body.setLayout(null);
          body.question = liczenie.easy();
          body.questionLabel.setText(body.question);
          body.level = 1;
          body.iteration=0;
          body.scoreLabel.setText("Wynik: 0");
          body.score = 0;
          body.losowanie(liczenie.result_e(),liczenie.falseResult_e1(),liczenie.falseResult_e2());
      }
      if(ae.getSource() == normal)
      {
          normalTimer();
          timer.restart();
          body.setLayout(null);
          body.question = liczenie.normal();
          body.questionLabel.setText(body.question);
          body.level = 2;
          body.iteration=0;
          body.scoreLabel.setText("Wynik: 0");
          body.score = 0;
          body.losowanie(liczenie.result_n(), liczenie.falseResult_n1(),liczenie.falseResult_n2());
      }
      if(ae.getSource() == hard)
      {
          normalTimer();
          timer.restart();
          body.setLayout(null);
          body.question = liczenie.hard();
          body.questionLabel.setText(body.question);
          body.level = 3;
          body.iteration=0;
          body.scoreLabel.setText("Wynik: 0");
          body.score = 0;
          body.losowanie(liczenie.result_h(), liczenie.falseResult_h1(),liczenie.falseResult_h2());
      }
      if(ae.getSource() == exit)
      {
         System.exit(0);
      }
   }
}
