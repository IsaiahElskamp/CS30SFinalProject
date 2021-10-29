package finalprojectisaiah;
import javax.swing.JOptionPane;
/**
 *Final Project: Arena Battle Simulator
 * 
 * This is a turn based strategy game where the player gets a wide selection
 * of classes and moves to choose from. The objective is to make it as far as
 * possible before dying. Randomly generated enemies will confront you, so you 
 * never know what you are going up against.
 * 
 * @author Izzy Elskamp
 */
public class FinalProjectIsaiah 
{   
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //loop to go back to menu when player dies
        while(true)
        {
            //creates a new score from the score class
            Score score = new Score();
            //a string array for the menuChoices
            final String[] menuChoices = {"Play", "Quit"};
            //asks the player what they want to do in the menu, it returns an
            //integer value based on their choice
            int menuChoice = JOptionPane.showOptionDialog(null, "Arena Battle Simulator", 
                    "ABS", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                    null, menuChoices, menuChoices[0]);
            //if the player selects "play" the game will start
            if (menuChoice == 0)
            {
                //calls the play method
                play(score);
            }
            //if the player selects "quit"
            else
            {
                //calls the exit method
                exit();
            }
        }
    }
    
    /**
     * 
     * @param score takes the score created in the main method for use here
     * This method runs the actual game, and is where most things happen
     */
    public static void play(Score score)
    {
        //creates a new character for the player to use
        Character character = new Character();
        //calls the create method in the Character class
        character.create();
        
        //checks if the players health is above 0, and continues to run if true
        while(character.health > 0)
        {     
            //creates a new enemy for the player to defeat
            Enemy enemy = new Enemy();
            //calls the enemyCreate method, located in the enemy class
            enemy.enemyCreate();
            //shows the player what enemy they are going up against and how
            //much health each has
            JOptionPane.showMessageDialog(null, "Player: " + character.name 
                        + "\nHealth: " + character.health + "\n\nEnemy: " 
                        + enemy.name + "\nHealth: " + enemy.health);
            //runs everything inside of the loop while the enemy is above 0 health
            while (enemy.health > 0)
            {   
                //asks the player to choose a move out of the moves they selected
                //in the character creation phase
                int choice = JOptionPane.showOptionDialog(null, "Choose Your Move", 
                "Game", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                null, character.moves, character.moves[0]);
                
                //calls the attack method from the enemy class, the enemy will
                //choose a random move
                enemy.attack(); 
                //takes the move the character chose and makes a single string
                //from the array based on the index choice
                //it does this for both the move name, and the move damage int
                String moveName = character.moves[choice];
                int moveD = character.moveDmg[choice];
                
                //checks if the characters selected move is above 0, if it is
                //it will be considered a healing move and will be added to 
                //the players health
                if(moveD > 0)
                {
                    character.health = character.health + moveD;
                }
                //checks if the selected move is equal to 0, if it is, it will be
                //considered a shield move, and will effectively make the enemies
                //move damageless
                else if(moveD == 0)
                {
                    enemy.enemyMove = 0;
                }
                //if it is none of the above qualities, it will be below 0, and
                //will simply take away from the enemy health
                else
                {
                    enemy.health = enemy.health + moveD;
                }                
                //informs the player on what move they used, and the impact to 
                //their, or the enemy health as a result
                //this is run before the players health is effected by the enemy
                //move so they can clearly see what healing moves did
                JOptionPane.showMessageDialog(null, character.name + " used: " 
                        + moveName + "\n\nYour Health: " + character.health + 
                        "\nEnemy Health: " + enemy.health);
                //here is where the enemy move is taken into account, and takes
                //it away from the player health
                character.health = character.health - enemy.enemyMove;
                
                //informs the player on what move the enemy used, and the impact
                //to the players health
                JOptionPane.showMessageDialog(null, enemy.name + " used: " + 
                        enemy.attackName + " - " + enemy.enemyMove + " dm" + 
                        "\n\nYour Health: " + character.health + 
                        "\nEnemy Health: " + enemy.health);
                
                //checks whether the enemy is dead or not
                if (enemy.health <= 0)
                {
                    //adds to the players score and prints it out
                    score.add();
                    score.scorePrint();
                }
                //checks whether the player is below 0 health, shows then resets 
                //the score before taking them back to the menu
                if (character.health <= 0)
                {
                    JOptionPane.showMessageDialog(null, "You Died");
                    score.scorePrint();
                    score.reset();
                    break;
                }                              
            }
        }                                                       
    }
    /**
     * method to terminate the program
     */
    public static void exit()
    {
        JOptionPane.showMessageDialog(null, "The program ended normally");
        System.exit(0);    
    }             
}
