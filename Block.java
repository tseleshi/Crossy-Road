import java.util.*;
/**
 * Write a description of class Block here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Block
{
    private Location[] locs;
    private Color color; 
    /**
     * Constructor for objects of class Block
     */
    public Block(int blocktype, Location topleft)
    {
        if(blocktype == 0)
        //0 is the square
        {
            locs = new Location[4]; 
            locs[0] = topleft; 
            locs[1] = new Location(topleft.getRow(), topleft.getCol() + 1);
            locs[2] = new Location(topleft.getRow() + 1, topleft.getCol());
            locs[3] = new Location(topleft.getRow()+1, topleft.getCol()+1);
            color = new Color(255, 255, 153);
        }
        if(blocktype == 1)
        //1 is horizontal 3
        {
            locs = new Location[3];
            locs[0] = topleft;
            locs[1] = new Location(topleft.getRow(), topleft.getCol() + 1);
            locs[2] = new Location(topleft.getRow(), topleft.getCol() + 2);
            color = new Color(204, 255, 204);
        }
        if(blocktype == 2)
        //2 is the big one
        {
            locs = new Location[6];
            locs[0] = topleft;
            locs[1] = new Location(topleft.getRow() + 1, topleft.getCol());
            locs[2] = new Location(topleft.getRow() + 1, topleft.getCol() + 1);
            locs[3] = new Location(topleft.getRow() + 2, topleft.getCol());
            locs[4] = new Location(topleft.getRow() + 2, topleft.getCol() + 1);
            locs[5] = new Location(topleft.getRow() + 2, topleft.getCol() + 2);
            color = new Color(255, 204, 229);
        }
        if(blocktype == 3)
        //3 is the lshape on top
        {
            locs = new Location[3];
            locs[0] = topleft;
            locs[1] = new Location(topleft.getRow(), topleft.getCol() + 1);
            locs[2] = new Location(topleft.getRow() + 1, topleft.getCol() + 1);
            color = new Color(229, 204, 255);
        }
        if(blocktype == 4)
        //4 is the longer lshape on top
        {
            locs = new Location[4];
            locs[0] = topleft;
            locs[1] = new Location(topleft.getRow(), topleft.getCol() + 1);
            locs[2] = new Location(topleft.getRow(), topleft.getCol() + 2);
            locs[3] = new Location(topleft.getRow() + 1, topleft.getCol() + 2);
            color = new Color(204, 255, 255);
        }
        if(blocktype == 5)
        //5 is the downward column
        {
            locs = new Location[4];
            locs[0] = topleft;
            locs[1] = new Location(topleft.getRow() + 1, topleft.getCol());
            locs[2] = new Location(topleft.getRow() + 2, topleft.getCol());
            locs[3] = new Location(topleft.getRow() + 3, topleft.getCol());
            color = new Color(255, 102, 102);
        }
        if(blocktype == 6)
        //6 is long lshape on bottom
        {
            locs = new Location[4];
            locs[0] = topleft;
            locs[1] = new Location(topleft.getRow(), topleft.getCol() + 1);
            locs[2] = new Location(topleft.getRow(), topleft.getCol() + 2);
            locs[3] = new Location(topleft.getRow() - 1, topleft.getCol() + 2);
            color = new Color(255, 204, 153);
        }
        if(blocktype == 7)
        //7 is the alone piece
        {
            locs = new Location[1];
            locs[0] = topleft;
            color = new Color(204, 229, 255);
        }
    }
    
    public int getNumSquares()
    {
        return locs.length;
    }
    
    public Color getColor()
    {
        return color;
    }
    
     public Location getLocation(int index)
    {
        return locs[index];
    }
    
    public void setLocation (int index, Location loc)
    {
        locs[index] = loc; 
    }
}
