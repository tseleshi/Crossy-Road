import java.util.*;
import javax.swing.*;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    // instance variables - replace the example below with your own
    private Block[][] grid;
    private GridDisplay display;
    private Location selectedloc; //null if no location already selected
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        // initialise instance variables
        grid = new Block [12][12];
        display = new GridDisplay(12,12);
        for(int i = 6; i < 12; i++)
        {
            for(int k = 0; k < 12; k++)
            {
                display.setColor(new Location(i, k), new Color(255, 255, 255));
            }
        }
        for(int i = 0; i < 12; i++)
        {
            for(int k = 6; k < 12; k++)
            {
                display.setColor(new Location(i, k), new Color(255, 255, 255));
            }
        }
        display.setLineColor(new Color(255,255,255));
        Block b = new Block(0, new Location(0, 8));
        Block b2 = new Block(0, new Location(7, 4));
        Block c = new Block(2, new Location (9, 9));
        Block a = new Block(1, new Location(7, 0));
        Block a2 = new Block(1, new Location(3, 9));
        Block d = new Block(7, new Location(3, 7));
        Block f = new Block(5, new Location (7, 7));
        Block g = new Block(3, new Location(9, 0));
        Block h = new Block(4, new Location(5, 8));
        Block e = new Block(6, new Location(11, 3));
        placeBlock(b);
        placeBlock(c);
        placeBlock(a);
        placeBlock(e);
        placeBlock(a2);
        placeBlock(b2); 
        placeBlock(d);
        placeBlock(f);
        placeBlock(g);
        placeBlock(h);
        JOptionPane.showMessageDialog(display, "Click on a block and press on an open space in the black region to move it there. You must fit all the blocks together to win!");
        Location location;
        while(true)
        {
            
            display.pause(100);
            location = display.checkLastLocationClicked();
            if(location != null)
            {
                if(selectedloc != null)
                {
                    //it's the second click; something is already selected; moving process
                    moveBlock(selectedloc, location);
                    selectedloc = null;
                }
                else
                {
                    //it's the first click; nothing selected yet
                    if(grid[location.getRow()][location.getCol()] != null)
                        selectedloc = location; 
                }
            }
            
        }
    }

    public void placeBlock(Block block)
    {
        //loop through locs, call set color
        for (int i = 0; i < block.getNumSquares(); i++)
        {
            display.setColor(block.getLocation(i), block.getColor());
            grid[block.getLocation(i).getRow()][block.getLocation(i).getCol()] = block;
        }
        winner();
    }

    public void moveBlock(Location from, Location to)
    {
        //step 1: erase old block
        //2: change coordinates of block
        //3: draw block in new location
        Block block = grid[from.getRow()][from.getCol()];
        int squares = block.getNumSquares();
        for (int i = 0; i < squares; i++)
        {
            if(block.getLocation(i).getRow() > 5 || block.getLocation(i).getCol() > 5)
            {
                display.setColor(block.getLocation(i), new Color(255, 255, 255));

            }
            else
            {
                display.setColor(block.getLocation(i), new Color(0, 0, 0));
            }
            grid[block.getLocation(i).getRow()][block.getLocation(i).getCol()] = null;

        }
        //2: if good location
        //to - from + loc
        boolean goodmove = true;
        for (int i = 0; i < squares; i++)
        {
            int r = to.getRow() - from.getRow() + block.getLocation(i).getRow();
            int c = to.getCol() - from.getCol() + block.getLocation(i).getCol();
            if(r >= 12 || c >= 12)
            {
                goodmove = false;
            }
            else if(r < 0 || c < 0)
            {
                goodmove = false;
            }
            else if(grid[r][c] != null)
            {
                goodmove = false;
            }
        }
        //2: change coordinates of block
        if(goodmove)
        {
            for (int i = 0; i < squares; i++)
            {
                block.setLocation(i, new Location(to.getRow() - from.getRow() + block.getLocation(i).getRow(), to.getCol() - from.getCol() + block.getLocation(i).getCol()));
            }
        }
        //3: draw block in new location
        placeBlock(block);
    }
    
    public void winner()
    {
        boolean b = true;
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j<6; j++)
            {
                if(grid[i][j] == null)
                {
                    b = false;
                }
            }
        }
        if(b)
        {
            JOptionPane.showMessageDialog(display, "YOU WIN!!!");
        }
        
    }
}
