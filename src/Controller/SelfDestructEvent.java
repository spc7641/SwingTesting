package Controller;

import View.Main;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class SelfDestructEvent implements ActionListener {

  private int count = 5;

  /**
   * The event that handles the countdown, and then the closing of the application.
   * @param e
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    JFrame destroy = new JFrame("AHHH!");
    JLabel label = new JLabel(Integer.toString(count) + "!?!?!?!");
    label.setFont(new Font(Font.DIALOG,Font.BOLD,50));


    //Timer which handles the count down
    Timer timer = new Timer(1000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(count == 0){
          //Destroy
          label.setText("BOOM!");
          count--;
        }
        else if(count == -1){
          //Once the boom message is shown, close the application
          Main.frame.dispose();
          destroy.dispose();
          ((Timer)(e.getSource())).stop();
        }
        else{
          //Still counting
          count--;
          label.setText(Integer.toString(count) + "!?!?!?!");
        }
      }
    }
    );

    destroy.add(label);
    destroy.pack();
    destroy.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    destroy.setLocationRelativeTo(null);
    destroy.setVisible(true);
    timer.start();

  }
}
