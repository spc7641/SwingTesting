package Controller;

import View.Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Shawn on 3/20/2018.
 */
public class KeyResizeEvent implements KeyListener {

  @Override
  public void keyTyped(KeyEvent e) {
    //No action
  }

  /**
   * On an arrow key press, the main window will resize in that direction.
   * @param e
   */
  @Override
  public void keyPressed(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_UP){
      Main.setFrameSize(Main.getWidth(), Main.getHeight()-10);
    }
    else if(e.getKeyCode() == KeyEvent.VK_DOWN){
      Main.setFrameSize(Main.getWidth(), Main.getHeight()+10);
    }
    else if(e.getKeyCode() == KeyEvent.VK_LEFT){
      Main.setFrameSize(Main.getWidth()-10, Main.getHeight());
    }
    else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
      Main.setFrameSize(Main.getWidth()+10, Main.getHeight());
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    //No action
  }
}

