package finalprojectisaiah;

/**
 *This class is used to create a randomly generated enemy to utilize random attacks
 *against the player
 * 
 * @author Izzy Elskamp
 */

//This class inherits everything from the character class, allowing the enemy 
//to have a health value and a name. This is due to the "extends" keyword
public class Enemy extends Character
{
    //creates properties specific to the enemy class
    
    //creates an integer property that will hold the amount of damage an enemy deals
    int enemyMove;
    //creates a string property that will hold the name of the move the enemy used
    String attackName;
    
    /**
     * Constructor to set default property values
     */
    public Enemy()
    {
        name = "Ogre";
        health = 100;
        enemyMove = 10;
        attackName = "Slash";      
    }
    /**
     * This method is used to create a new randomly generated enemy
     */
    public void enemyCreate()
    {
        //creates a final string of names for the system to choose from
        final String[] ENEMYNAMES = {"Ogre", "Goblin", "Giant", "Dark Mage", 
            "Chicken", "Rat", "Skeleton"};
        
        //random number generator set to choose between 0 and 6. This will allow
        //the computer to choose a name for the enemy
        final int HIGH = 0;
        final int LOW = 6;
        double seed = Math.random();
        double H = (double) HIGH;
        double L = (double) LOW;
        double random = (H - L + 1) * seed + L;
        int nameInt = (int) random;
        //creates a name string using the index number of the ENEMYNAMES array
        String name = ENEMYNAMES[nameInt];
        //sends it to the name property
        this.name = name;
        
        //random number generator for enemy health
        final int HIGHHP = 250;
        final int LOWHP = 50;
        double seedHp = Math.random();
        double HHP = (double) HIGHHP;
        double LHP = (double) LOWHP;
        double randomHp = (HHP - LHP + 1) * seedHp + LHP; 
        int enemyHp = (int) randomHp;
        //sends the value to the health property
        health = enemyHp;
        
    }
    /**
     * This method is used for when the enemy needs to attack
     */
    public  void attack()
    {
        //creates a final string array of attack names for the enemy
        final String[] ATTACKNAMES = {"Slash", "Ground Pound", "Head Butt", "Kick", 
            "Suspicious Potion", "Tickle", "Insult"};
        //creates a final int array of attack damage for the enemy
        //These two arrays have their index numbers matched up, for example,
        //slash is at index 0, and slash does 10 damage, which means that 
        //10 in enemymoves is at index 0 too.
        //This way, I can retrieve a single number that can be used to get both
        //the attack name and the amount of damage that attack does
        final int[] ENEMYMOVES = {10, 15, 20, 25, 30, 0, 70};
        
        //generates a random number to be used to select a move for the enemy
        final int HIGH = 0;
        final int LOW = 7;
        double seed = Math.random();
        double H = (double) HIGH;
        double L = (double) LOW;
        double random = (H - L + 1) * seed + L;
        int moveInt = (int) random;
        //creates a single int to hold the damage the enemy does based
        //on the index number of the enemymoves array
        int enemyMove = ENEMYMOVES[moveInt];
        //creates a single string to hold the name of the move the enemy used
        //the name and damage have the same index
        String attackName = ATTACKNAMES[moveInt];
        //sends the selected move damage back to the property
        this.enemyMove = enemyMove;
        //sends the selected move name back to the property
        this.attackName = attackName;                                                        
    }      
}
