package Controller;

import View.Main;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * Handler for the pop out resize windows submission.
 */
public class SubmitEvent implements ActionListener {


  @Override
  public void actionPerformed( ActionEvent e ) {
    int width = Main.getWidth();
    int height;
    try {
      width = ResizeEventHandler.getWidth();
    }
    catch ( NumberFormatException error ){
      openError( "Enter Valid Width." );
    }
    try{
      height = ResizeEventHandler.getHeight();
      Main.setFrameSize( width, height );
      ResizeEventHandler.close();
      Main.setFocus();
    }
    catch( NumberFormatException error ){
      openError( "Enter Valid Height" );
    }
  }

  /**
   * Generic method for Displaying a window that shows that an error has occurred.
   * @param error The text that is input to be displayed as the error
   */
  private static void openError( String error ){
    JFrame errorFrame = new JFrame( "Error" );

    JLabel label = new JLabel( error );
    label.setFont( new Font( Font.SANS_SERIF, 1, 50 ) );

    errorFrame.add( label );


    errorFrame.pack();
    errorFrame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
    errorFrame.setLocationRelativeTo( null );
    errorFrame.setVisible( true );
  }
}
