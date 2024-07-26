
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
  public static int WIDTH = 480, HEIGHT = 480;
  
  public Game() {
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }
  public static void main(String[] args){
    Game game = new Game();
    JFrame frame = new JFrame("Mini Zelda");
    frame.add(game);
    frame.setTitle("Mini Zelda");
    frame.pack();
    
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setVisible(true);

    new Thread(game).start();
  }

  @Override
  public void run() {
    while (true) {
      System.out.println("Running");
    }
  }

}

