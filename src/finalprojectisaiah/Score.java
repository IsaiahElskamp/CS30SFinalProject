package finalprojectisaiah;
import javax.swing.JOptionPane;

/**
 *This class is used to keep score for the player, and can be called in the 
 *main class
 * 
 * @author Izzy Elskamp
 */
public class Score 
{
    //creates a private integer property to be used as a score counter
    //it is encapsulated inside of this class, so it can only be changed here
    private int score;
    
    /**
     * constructor to set default values
     */
    public Score()
    {
        score = 0;       
    }
    /**
     * Adds 1 to the player score
     */
    public void add()
    {
        score++;
    }
    /**
     * Tells the player what their score is
     */
    public void scorePrint()
    {
        JOptionPane.showMessageDialog(null, "Your score is: " + score);
    }
    /**
     * resets the score to 0
     */
    public void reset()
    {
        score = 0;
    }
    
}
