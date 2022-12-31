public class CrossyRoad
{
  
  private GridDisplay display;
  private String chicken;
  private Location chickenLoc;
  private Location car1Loc;
  private Location car2Loc;
  private Location car3Loc;
  private Location car4Loc;
  private Location car5Loc;
  private Location car6Loc;
  private Location car7Loc;
  private Location car8Loc;
  private Location car9Loc;
  private Location car10Loc;
  private Location car11Loc;
  
  
public CrossyRoad()
{
    display = new GridDisplay(10, 23);
    display.setTitle("Crossy Road");

    chickenLoc = new Location(5, 1);
    chicken = "chicken.png";
    
    car1Loc = new Location((int)(Math.random()*9), 4);
    car2Loc = new Location((int)(Math.random()*9), 5);
    car3Loc = new Location((int)(Math.random()*9), 7);
    car4Loc = new Location((int)(Math.random()*9), 8);
    car5Loc = new Location((int)(Math.random()*9), 9);
    car6Loc = new Location((int)(Math.random()*9), 12);
    car7Loc = new Location((int)(Math.random()*9), 13);
    car8Loc = new Location((int)(Math.random()*9), 14);
    car9Loc = new Location((int)(Math.random()*9), 15);
    car10Loc = new Location((int)(Math.random()*9), 17);
    car11Loc = new Location((int)(Math.random()*9), 18);
      
    //grass
    for(int r = 0; r < 10; r++)
    {
     for (int c = 0; c < 4; c++)
     display.setColor(new Location(r, c), new Color(50, 205, 50));
    }
    
    //road    
   for(int r = 0; r < 10; r++)
    {
     for (int c = 4; c < 6; c++)
     display.setColor(new Location(r, c), new Color(105, 105, 105));
    }
   //grass
   for(int r = 0; r < 10; r++)
    {
     for (int c = 6; c < 7; c++)
     display.setColor(new Location(r, c), new Color(50, 205, 50));
    }

   for(int r = 0; r < 10; r++)
    {
     for (int c = 7; c < 10; c++)
     display.setColor(new Location(r, c), new Color(105, 105, 105));
    }
    
    for(int r = 0; r < 10; r++)
    {
     for (int c = 10; c < 12; c++)
     display.setColor(new Location(r, c), new Color(50, 205, 50));
    }

   for(int r = 0; r < 10; r++)
    {
     for (int c = 12; c < 16; c++)
     display.setColor(new Location(r, c), new Color(105, 105, 105));
    }

   for(int r = 0; r < 10; r++)
    {
     for (int c = 16; c < 17; c++)
     display.setColor(new Location(r, c), new Color(50, 205, 50));
    }

   for(int r = 0; r < 10; r++)
    {
     for (int c = 17; c < 19; c++)
     display.setColor(new Location(r, c), new Color(105, 105, 105));
    }

   for(int r = 0; r < 10; r++)
    {
     for (int c = 19; c < 23; c++)
     display.setColor(new Location(r, c), new Color(50, 205, 50));
    }

    
    display.setImage(chickenLoc, "chicken.png");
    display.showMessageDialog("Use the arrow keys to help the chicken\ncross the road without getting hit.");
 }   

  public void play()
  {
    while (true)
    {
    if (chickenLoc.equals(car1Loc)||chickenLoc.equals(car2Loc)||chickenLoc.equals(car3Loc)||chickenLoc.equals(car4Loc)
      ||chickenLoc.equals(car5Loc)||chickenLoc.equals(car6Loc)||chickenLoc.equals(car7Loc)
      ||chickenLoc.equals(car8Loc)||chickenLoc.equals(car9Loc)||chickenLoc.equals(car10Loc)
      ||chickenLoc.equals(car11Loc))
      {
      display.setImage(chickenLoc, chicken);
      display.showMessageDialog("YOU DEAD\ntry again :(");
      chickenLoc = new Location(5, 1);
      display.setImage(chickenLoc, chicken);
      }
      display.pause(100);
      
      int key = display.checkLastKeyPressed();
      if (key != -1)
      {
        keyPressed(key);
      }
      
      if (chickenLoc.getCol() > 18)
      {
        display.showMessageDialog("YOU WIN!");
        display.setImage(chickenLoc, null);
        chickenLoc = new Location(5, 1);
        display.setImage(chickenLoc, chicken);
      }
      
      if (chickenLoc.equals(car1Loc)||chickenLoc.equals(car2Loc)||chickenLoc.equals(car3Loc)||chickenLoc.equals(car4Loc)
      ||chickenLoc.equals(car5Loc)||chickenLoc.equals(car6Loc)||chickenLoc.equals(car7Loc)
      ||chickenLoc.equals(car8Loc)||chickenLoc.equals(car9Loc)||chickenLoc.equals(car10Loc)
      ||chickenLoc.equals(car11Loc))
      {
      display.setImage(chickenLoc, chicken);
      display.showMessageDialog("YOU DEAD\ntry again :(");
      chickenLoc = new Location(5, 1);
      display.setImage(chickenLoc, chicken);
      }
      
      step();
      
      if (chickenLoc.equals(car1Loc)||chickenLoc.equals(car2Loc)||chickenLoc.equals(car3Loc)||chickenLoc.equals(car4Loc)
      ||chickenLoc.equals(car5Loc)||chickenLoc.equals(car6Loc)||chickenLoc.equals(car7Loc)
      ||chickenLoc.equals(car8Loc)||chickenLoc.equals(car9Loc)||chickenLoc.equals(car10Loc)
      ||chickenLoc.equals(car11Loc))
      {
      display.setImage(chickenLoc, chicken);
      display.showMessageDialog("YOU DEAD\ntry again :(");
      chickenLoc = new Location(5, 1);
      display.setImage(chickenLoc, chicken);
      }

    }
  }
    
public void keyPressed(int key)
{
//System.out.println("key code:  " + key);

if (key == 37 && chickenLoc.getCol() - 1 > -1) // left
{
   display.setImage(chickenLoc, null);
   chickenLoc = new Location(chickenLoc.getRow(), chickenLoc.getCol() - 1);
   display.setImage(chickenLoc, chicken);
}
     
if (key == 39 && chickenLoc.getCol() + 1 < 23) // right
{
   display.setImage(chickenLoc, null);
   chickenLoc = new Location(chickenLoc.getRow(), chickenLoc.getCol() + 1);
   display.setImage(chickenLoc, chicken);
}

if (key == 38 && chickenLoc.getRow() - 1 > -1) // up
{
   display.setImage(chickenLoc, null);
   chickenLoc = new Location(chickenLoc.getRow() - 1, chickenLoc.getCol());
   display.setImage(chickenLoc, chicken);
}

if (key == 40 && chickenLoc.getRow() + 1 < 10) // down
{
   display.setImage(chickenLoc, null);
   chickenLoc = new Location(chickenLoc.getRow() + 1, chickenLoc.getCol());
   display.setImage(chickenLoc, chicken);
}

}

//this method is called at regular intervals
  public void step()
  {
    // car 1
      display.pause(200);
      display.setImage(car1Loc, null);
      if (car1Loc.getRow() == 9)
         car1Loc = new Location(0, car1Loc.getCol());
      else 
         car1Loc = new Location(car1Loc.getRow() + 1, car1Loc.getCol());
      display.setImage(car1Loc, "redcar.png");
      //car 2
     display.setImage(car2Loc, null);
      if (car2Loc.getRow() == 0)
         car2Loc = new Location(9, car2Loc.getCol());
      else 
         car2Loc = new Location(car2Loc.getRow() - 1, car2Loc.getCol());
      display.setImage(car2Loc, "purplecar.png");
      //car 3
      display.setImage(car3Loc, null);
      if (car3Loc.getRow() == 9)
         car3Loc = new Location(0, car3Loc.getCol());
      else 
         car3Loc = new Location(car3Loc.getRow() + 1, car3Loc.getCol());
      display.setImage(car3Loc, "greencar.png");
      //car 4
      display.setImage(car4Loc, null);
      if (car4Loc.getRow() == 0)
         car4Loc = new Location(9, car4Loc.getCol());
      else 
         car4Loc = new Location(car4Loc.getRow() - 1, car4Loc.getCol());
      display.setImage(car4Loc, "yellowcar.png");
      //car 5
      display.setImage(car5Loc, null);
      if (car5Loc.getRow() == 0)
         car5Loc = new Location(9, car5Loc.getCol());
      else 
         car5Loc = new Location(car5Loc.getRow() - 1, car5Loc.getCol());
      display.setImage(car5Loc, "orangecar.png");
      //car 6
      display.setImage(car6Loc, null);
      if (car6Loc.getRow() == 9)
         car6Loc = new Location(0, car6Loc.getCol());
      else 
         car6Loc = new Location(car6Loc.getRow() + 1, car6Loc.getCol());
      display.setImage(car6Loc, "greencar.png");
      //car 7
      display.setImage(car7Loc, null);
      if (car7Loc.getRow() == 9)
         car7Loc = new Location(0, car7Loc.getCol());
      else 
         car7Loc = new Location(car7Loc.getRow() + 1, car7Loc.getCol());
      display.setImage(car7Loc, "redcar.png");
      //car 8
      display.setImage(car8Loc, null);
      if (car8Loc.getRow() == 0)
         car8Loc = new Location(9, car8Loc.getCol());
      else 
         car8Loc = new Location(car8Loc.getRow() - 1, car8Loc.getCol());
      display.setImage(car8Loc, "purplecar.png");
      //car 9
      display.setImage(car9Loc, null);
      if (car9Loc.getRow() == 0)
         car9Loc = new Location(9, car9Loc.getCol());
      else 
         car9Loc = new Location(car9Loc.getRow() - 1, car9Loc.getCol());
      display.setImage(car9Loc, "orangecar.png");
      //car 10
      display.setImage(car10Loc, null);
      if (car10Loc.getRow() == 9)
         car10Loc = new Location(0, car10Loc.getCol());
      else 
         car10Loc = new Location(car10Loc.getRow() + 1, car10Loc.getCol());
      display.setImage(car10Loc, "greencar.png");
      //car 11
      display.setImage(car11Loc, null);
      if (car11Loc.getRow() == 0)
         car11Loc = new Location(9, car11Loc.getCol());
      else 
         car11Loc = new Location(car11Loc.getRow() - 1, car11Loc.getCol());
      display.setImage(car11Loc, "yellowcar.png");

  }
  
  //this code starts a game when you click the run button
  public static void main(String[] args)
  {
    CrossyRoad c = new CrossyRoad();
    c.play();
  }



}