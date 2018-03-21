package Controller;

import View.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;

/**
 * Created by Shawn on 3/21/2018.
 */
public class DataManageEvent implements ActionListener {

  private JFrame dataFrame;

  private JTable table;

  private String[] columnNames = {"Number","Letter"};

  private Object[][] data = {{1,"a"},{2,"b"},{3,"c"},{4,"d"}};
  @Override
  public void actionPerformed(ActionEvent e) {
    dataFrame = new JFrame("Data Manager");

    JTable table = new JTable(new AbstractTableModel() {
      @Override
      public String getColumnName(int col){
        return columnNames[col];
      }
      @Override
      public int getRowCount() {
        return data.length;
      }

      @Override
      public int getColumnCount() {
        return columnNames.length;
      }

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
      }

      @Override
      public boolean isCellEditable(int row, int col){
        return false;
      }
    });

    JScrollPane layout = new JScrollPane(table);

    dataFrame.add(layout);
    dataFrame.pack();
    dataFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    dataFrame.setVisible(true);
    Main.setFocus();
  }
}
