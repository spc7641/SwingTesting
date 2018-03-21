package Controller;

import View.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Created by Shawn on 3/20/2018.
 */
public class ResizeEventHandler implements ActionListener {

  private static JFrame resizeFrame;

  private static String width;
  private static String height;

  /**
   * Create a new Window for the resizing, and all of the objects on it.
   * @param e
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    resizeFrame = new JFrame("Resize Window");
    resizeFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    resizeFrame.setSize(400,400);
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

    //Setup the Instructions
    JLabel intructions = new JLabel();

    intructions.setText("Enter a Width and Height, ranging from 1 to a reasonable number.");
    //Setup the text fields for inputting height and width
    JTextField widthTextField = new JTextField("Enter Width");
    JTextField heightTextField = new JTextField("Enter Height");


    //Setup the cancel and submit buttons
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.PAGE_AXIS));

    JButton cancel = new JButton("Cancel");
    JButton submit = new JButton("Submit");

    buttonPanel.add(submit);
    buttonPanel.add(cancel);

    cancel.addActionListener(cancelEvent -> resizeFrame.dispose());

    submit.addActionListener(new SubmitEvent());

    widthTextField.addFocusListener(new SelectEvent());
    heightTextField.addFocusListener(new SelectEvent());

    widthTextField.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
        width = widthTextField.getText() + Character.toString(e.getKeyChar());
      }

      @Override
      public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_ENTER){
          System.out.println("ggg");
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {

      }
    });

    heightTextField.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
        height = heightTextField.getText() + Character.toString(e.getKeyChar());
      }

      @Override
      public void keyPressed(KeyEvent e) {

      }

      @Override
      public void keyReleased(KeyEvent e) {

      }
    });

    panel.add(intructions);
    panel.add(widthTextField);
    panel.add(heightTextField);
    panel.add(buttonPanel);

    resizeFrame.add(panel);

    resizeFrame.setVisible(true);
    Main.setFocus();
  }

  protected static void close(){
    resizeFrame.dispose();
  }

  protected static int getWidth(){
    return Integer.parseInt(width);
  }

  protected static int getHeight(){
    return Integer.parseInt(height);
  }

}
