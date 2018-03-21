package Controller;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 * Created by Shawn on 3/21/2018.
 */
public class SelectEvent implements FocusListener {

  @Override
  public void focusGained(FocusEvent e) {
    ((JTextField)e.getSource()).selectAll();
  }

  @Override
  public void focusLost(FocusEvent e) {

  }
}
