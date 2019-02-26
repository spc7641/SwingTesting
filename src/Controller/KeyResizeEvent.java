package Controller;

import View.Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Handles the arrow key presses in order to resize the main window.
 */
public class KeyResizeEvent implements KeyListener {

  private final ArrayList<Integer> keysPressed = new ArrayList<>();

  @Override
  public void keyTyped( KeyEvent e ) {
    //No action
  }

  /**
   * On an arrow key press, the main window will resize in that direction.
   * @param e
   */
  @Override
  public void keyPressed( KeyEvent e ) {
    if( !keysPressed.contains( e.getKeyCode() ) ) {
      keysPressed.add(e.getKeyCode());
    }
    if( keysPressed.contains( KeyEvent.VK_UP ) ){
      Main.setFrameSize( Main.getWidth(), Main.getHeight() - 10 );
    }
    if( keysPressed.contains( KeyEvent.VK_DOWN ) ){
      Main.setFrameSize( Main.getWidth(), Main.getHeight() + 10 );
    }
    if( keysPressed.contains( KeyEvent.VK_LEFT ) ){
      Main.setFrameSize( Main.getWidth() - 10, Main.getHeight() );
    }
    if( keysPressed.contains( KeyEvent.VK_RIGHT ) ){
      Main.setFrameSize( Main.getWidth() + 10, Main.getHeight() );
    }
  }

  /**
   * When a key is released, it needs to be removed from the list of keys pressed.
   * @param e
   */
  @Override
  public void keyReleased( KeyEvent e ) {
    keysPressed.remove( Integer.valueOf( e.getKeyCode() ) );
  }
}

