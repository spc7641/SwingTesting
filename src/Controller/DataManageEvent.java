package Controller;


import View.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 * Event Responsible for opening the data manager window
 */
public class DataManageEvent implements ActionListener {

  private JFrame dataFrame;

  private String[] columnNames = { "Number", "Letter" };

  private Object[][] data = {};
  @Override
  public void actionPerformed( ActionEvent e ) {
    dataFrame = new JFrame("Data Manager");

    DefaultTableModel model = new DefaultTableModel( data, columnNames ){
      @Override
      public boolean isCellEditable( int row, int col ){
        return false;
      }
    };

    JTable table = new JTable(model);

    table.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped( KeyEvent e ) {

      }

      @Override
      public void keyPressed( KeyEvent e ) {


      }

      @Override
      public void keyReleased( KeyEvent e ) {
        if( e.getKeyCode() >= 65 && e.getKeyCode() <= 90 ) {
          model.addRow( new Object[]{ -1 * ( 64 - e.getKeyCode() ), Character.toString( e.getKeyChar() ) } );
        }
      }
    });

    JScrollPane layout = new JScrollPane(table);

    JButton saveButton = new JButton( "Save" );
    JButton newButton = new JButton( "Create New" );

    Box sideBar = new Box( BoxLayout.Y_AXIS );
    sideBar.add(newButton);
    sideBar.add(saveButton);

    Box windowLayout = new Box( BoxLayout.X_AXIS );
    windowLayout.add( layout );
    windowLayout.add( sideBar );

    dataFrame.add( windowLayout );
    dataFrame.pack();
    dataFrame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
    dataFrame.setVisible( true );
    Main.setFocus();
  }

}
