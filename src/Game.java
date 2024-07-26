
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
  public static int WIDTH = 480, HEIGHT = 480;
  
  public Game() {
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
  }

  public static void tick() {
  }

  public void render() {
    BufferStrategy bs = this.getBufferStrategy();

    if(bs == null) {
      this.createBufferStrategy(3);
      return;
    }

    Graphics g = bs.getDrawGraphics();

    g.setColor(Color.black);
    g.fillRect(0, 0, WIDTH, HEIGHT);

    g.setColor(Color.red);
    g.fillRect(0, 0, 50, 50);
    
    bs.show();
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
      tick();
      render();
      try {
        Thread.sleep(1000/60);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      }
    }

}

