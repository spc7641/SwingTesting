package View;

import Controller.DataManageEvent;
import Controller.KeyResizeEvent;
import Controller.ResizeEventHandler;
import Controller.SelfDestructEvent;
import java.awt.Component;
import javax.swing.*;

public class Main {

  public static JFrame frame;

  public static void main(String args[]){
    initializeFrame();
  }

  /**
   * Create all of the elements that occupy the main frame
   */
  public static void initializeFrame(){
    frame = new JFrame("View.Main");

    JLabel label = new JLabel("Press the Arrow Keys to Resize, or Use the Resize buytton to Resize Precisely");

    //Create the button to open up the data manager
    JButton data = new JButton("Open Data Manager");

    //Setup the action that the data manager button will perform, when acted upon
    data.addActionListener(new DataManageEvent());

    //Create the 3 buttons related to Self Destructing
    JButton leftButton = new JButton("Disable Self Destruct Button");
    JButton middleButton = new JButton("Self Destruct");
    middleButton.setEnabled(false);
    JButton rightButton = new JButton("Enable Self Destruct Button");

    //Setup the actions each button will perform
    leftButton.addActionListener(e -> middleButton.setEnabled(false));

    rightButton.addActionListener(e -> middleButton.setEnabled(true));

    middleButton.addActionListener(new SelfDestructEvent());

    JButton resize = new JButton("Click to Resize");
    resize.addActionListener(new ResizeEventHandler());

    Box desktopPane = new Box(BoxLayout.Y_AXIS);
    JPanel InstructionPane = new JPanel();
    JPanel buttonPane = new JPanel();
    JPanel resizePane = new JPanel();
    JPanel dataPane = new JPanel();

    InstructionPane.add(label);

    buttonPane.add(leftButton, Component.LEFT_ALIGNMENT);
    buttonPane.add(middleButton,Component.CENTER_ALIGNMENT);
    buttonPane.add(rightButton, Component.RIGHT_ALIGNMENT);

    resizePane.add(resize);

    dataPane.add(data);

    desktopPane.add(InstructionPane);
    desktopPane.add(buttonPane);
    desktopPane.add(resizePane);
    desktopPane.add(dataPane);


    frame.add(desktopPane);

    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    frame.setFocusable(true);
    frame.addKeyListener(new KeyResizeEvent());
    frame.setVisible(true);
  }

  /**
   * Set the exact frame size for the main window
   * @param width
   * @param height
   */
  public static void setFrameSize(int width, int height){
    frame.setSize(width,height);
  }

  /**
   * @return The height of the main window
   */
  public static int getWidth(){
    return frame.getWidth();
  }

  /**
   * @return The Height of the main window
   */
  public static int getHeight(){
    return frame.getHeight();
  }

  /**
   * Sets the focus back to the main window.
   */
  public static void setFocus(){
    frame.setFocusable(true);
    frame.requestFocus();
  }
}
