package Controller;

import View.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/**
 * Created by Shawn on 3/21/2018.
 */
public class DataManageEvent implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    JFrame data = new JFrame("Data Manager");

    JTable table = new JTable(3,3);

    Box layout = new Box(BoxLayout.Y_AXIS);

    layout.add(table);

    data.add(layout);
    data.pack();
    data.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    data.setVisible(true);
    Main.setFocus();
  }
}
