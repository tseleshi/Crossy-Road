import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.ArrayList;

//The Display is the region in the window where drawing occurs.
public class Display extends JComponent implements KeyListener, MouseListener  //need for mouse input
{
  //main method for testing
  public static void main(String[] args)
  {
    Display display = new Display();
    display.run();
  }
  
  //private int imageX;  //position of left edge of image
  //private int imageY;  //position of top edge of image
  private int screen; // 1 = start screen; 2 = game select screen; 3 = crossy road; 4 = fbwg; 5 = block
  private Image startscreen;
  private Image startbutton;
  private CrossyRoad crossy;
  private Image fakegames;
  private Image crossyGame;
  private Image FbWgGame;
  private Image blockGame;
  private JFrame frame;
  private String name;
  private Queue<KeyEvent> keys;
   
  public Display()
  {
   // imageX = 524;
   // imageY = 50;
    
    keys = new ConcurrentLinkedQueue<KeyEvent>();
    
    screen = 1;
    name = "";
    
       
    //load title screen
    String fileName = "startscreen.jpeg";
    URL url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    startscreen = new ImageIcon(url).getImage();
    
    //load start button
    fileName = "startbutton.jpeg";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    startbutton = new ImageIcon(url).getImage();
    
    
    // load fake games screen
    fileName = "fakegames.jpeg";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    fakegames = new ImageIcon(url).getImage();
    
    fileName = "crossyGAME.jpeg";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    crossyGame = new ImageIcon(url).getImage();
    
    fileName = "fbwgGAME.jpeg";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    FbWgGame = new ImageIcon(url).getImage();

    fileName = "blockGAME.png";
    url = getClass().getResource(fileName);
    if (url == null)
      throw new RuntimeException("Unable to load:  " + fileName);
    blockGame = new ImageIcon(url).getImage();


       
    frame = new JFrame();  //create window
    frame.setTitle("VIRF (knockoff friv)");  //set title of window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //closing window will exit program
    setPreferredSize(new Dimension(1445, 800));  //set size of drawing region
    
    setFocusable(true);
    addKeyListener(this);
    //need for mouse input
    addMouseListener(this);  //will notify Display when the mouse is pressed
    
    frame.getContentPane().add(this);  //add drawing region to window
    frame.pack();  //adjust window size to fit drawing region
    frame.setVisible(true);  //show window
    requestFocusInWindow();
  }
  
  //called automatically when Java needs to draw the Display
  public void paintComponent(Graphics g)
  {
    int width = getWidth();  //get width of drawing region
    int height = getHeight();  //get height of drawing region
    //g.setColor(Color.YELLOW);  //set pen color to purple
    g.fillRect(1440, 820, width, height);  //fill with purple rectangle
    if (screen == 1) // start screen
    {
      g.drawImage(startscreen, 0, 0, null); // background
    }
    else if (screen == 2) // game select screen
    {
      g.drawImage(fakegames, 0, 0, null); // background
      g.drawImage(crossyGame, 150, 250, null); // crossy road
      g.drawImage(FbWgGame, 570, 250, null); // fbwg
      g.drawImage(blockGame, 990, 250, null); // block game
    }
  
    else if (screen == 3)
    {
      //new CrossyRoad();
    }
    
    else if (screen == 4) // fireboy and watergirl - panya
    {
        //new FireBWaterG();
    }
    
    else if (screen == 5) // block game - sejal
    {
     //  new block(this);
    }
   
  }
  
  //need for mouse input
  public void mousePressed(MouseEvent e)
  {
    // int x = e.getX();
    // int y = e.getY();
    // System.out.println("Pressed mouse button at:  " + x + ", " + y);
    if (screen == 1)
    {
      if ((e.getX() >= 512 && e.getX() <= 912) && (e.getY() >= 400 && e.getY() <= 800)) // play button pressed
      {
        screen = 2;
        repaint();
      }
    }
    else if (screen == 2)
    {
      if ((e.getX() >= 150 && e.getX() <= 450) && (e.getY() >= 250 && e.getY() <= 650))  
      {
      //crossy road clicked
       CrossyRoad c = new CrossyRoad();
       c.play();
      }
      else if ((e.getX() >= 570 && e.getX() <= 870) && (e.getY() >= 250 && e.getY() <= 650)) 
      {
      //fbwg clicked
       FireBWaterG g = new FireBWaterG();
       g.play();  
      } 
      else if ((e.getX() >= 990 && e.getX() <= 1290) && (e.getY() >= 250 && e.getY() <= 650))
      {
      // block game clicked
       new Main();
      }
    }
  }
  
  private static Map<String, Image> images = new HashMap<String, Image>();
  
  public static Image getImage(String name)
  {
    try
    {
      Image image = images.get(name);
      if (image == null)
      {
        URL url = Display.class.getResource(name);
        if (url == null)
          throw new RuntimeException("unable to load image:  " + name);
        image = ImageIO.read(url);
      }
      return image;
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public void endGame()
  {    
    screen = 2;
    repaint();
    
    setPreferredSize(new Dimension(1445, 800));  //set size of drawing region
    setFocusable(true);
    addKeyListener(Display.this);
    addMouseListener(Display.this);
    frame.getContentPane().add(this);  //add drawing region to window
    frame.pack();  //adjust window size to fit drawing regionframe = new JFrame();
    requestFocusInWindow();
    
    run();
  }
      
  public void mouseReleased(MouseEvent e) { }
  public void mouseClicked(MouseEvent e) { }
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }
  
  public void keyPressed(KeyEvent e)
  {
    //System.out.println("display key = " + e.getKeyCode());
    keys.add(e);
  }
  
  public void keyReleased(KeyEvent e)
  {
    keys.add(e);
  }
  
  public void keyTyped(KeyEvent e)
  {
    //ignored
  }
  
  //need for automation (graphical changes not prompted by the keyboard or mouse)
  public void run()
  {
    //System.out.println("run called once");
    while (screen < 3)
    {
      try{Thread.sleep(100);}catch(Exception e){}
    }
    
    try{Thread.sleep(500);}catch(Exception e){} //wait 500 cs
    setPreferredSize(new Dimension(500, 500));  //set size of drawing region
    setFocusable(true);
    addKeyListener(Display.this);
    addMouseListener(Display.this);
    frame.getContentPane().add(this);  //add drawing region to window
    frame.pack();  //adjust window size to fit drawing regionframe = new JFrame();
    requestFocusInWindow();
    
    System.out.println("entering big loop");
    while (true)
    {   
      try { Thread.sleep(10); } catch(Exception e) { }
      
      while (!keys.isEmpty())
      {
        KeyEvent event = keys.poll();
          throw new RuntimeException("Unexpected event type:  " + event.getID());
      }
    }
  }
}
 