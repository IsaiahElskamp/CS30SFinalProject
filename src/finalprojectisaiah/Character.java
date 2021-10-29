package finalprojectisaiah;
import javax.swing.JOptionPane;
/**
 *This class is used to create a character with a name, health, and an array of
 * selected moves, and move damage
 * 
 * @author Izzy Elskamp
 */
public class Character 
{
    //creates properties to be used in this class, and any that may inherit these
    
    //creates a string property to hold the a name
    String name;
    //creates an int property to hold a health value
    int health;
    //creates a string array property to hold 4 moves that the player chooses
    String[] moves;
    //creates an int array property to hold 4 damage integers that goes along with
    //the moves array
    int[] moveDmg;  
    
    /**
     * constructor to set default values
     */
    public Character()
    {       
        name = "Joe";
        health = 300;
        moves = new String[4];
        moveDmg = new int[4];              
    }
    /**
     * method to create a player. This is where the player names themselves,
     * and chooses their class
     */
    public void create()
    {
        //asks the player what they want their name to be, stores it in a string
        String name = JOptionPane.showInputDialog("Please enter name");
        //creates a final string to hold the class names for the player to choose from
        final String[] CLASSES = {"Melee - 700 Hp, Low Dm", "Wizard - 300 Hp, "
                + "High Dm", "Ranged - 400 Hp, Medium Dm", "Summoner - 50 Hp, "
                + "Very High Dm"};
        //asks the player to select which class they want
        int classChoice = JOptionPane.showOptionDialog(null, "Pick Your Class", 
        "Class Select", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
        null, CLASSES, CLASSES[0]);
        //sends the players name to the name property
        this.name = name;
        
        //if/else statement to determine which method to go to, based on the
        //players choice
        if(classChoice == 0)
        {            
            melee();           
        }   
        else if(classChoice == 1)
        {
            wizard();
        }
        else if(classChoice == 2)
        {
            ranged();
        }
        else
        {
            summoner();
        }
        //for loop to print out the users selected moves before they go into battle       
        String output = "";
        for (int i = 0; i < moves.length; i++) 
        {
            output = output + moves[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, "Your moves are:\n\n" + output);                     
    }  

    //the next 4 methods basically have the same commenting, so you really only
    //have to read the comments on one of them, but I still included comments
    //for each one.
    
    /**
     * method if the player chooses the melee class 
     */
    public void melee()
    {     
        //a final string to hold the move names
        final String[] MELMOVES = {"Slash - 15 dm\n",
                "Spear - 20 dm\n",
                "Healing Potion - 30 heal\n",
                "Jump Slash - 20 dm\n",
                "Shield - blocks the enemy hit\n",
                "Shield Throw - 30 dm\n",
                "Metal Tornado - 40 dm\n",
                "Healing Blade - 40 heal\n"};       
        //final int to hold the damage amounts that each move does
        final int[] MELDMG = {-15, -20, 30, -20, 0, -30, -40, 40};
        //These two arrays have their index numbers matched up, for example,
        //slash is at index 0, and slash does 15 damage, which means that 
        //15 in the damage array is at index 0 too.
        //This way, I can retrieve a single number that can be used to get both
        //the attack name and the amount of damage that attack does
        
        //a final string to hold the moves that will be displayed in the selection
        //screen
        final String MELDISPLAY = ("Choose 4 Moves \n"
                + "Enter the number of move to select\n\n"
                + "0. Slash - 15 dm\n"
                + "1. Spear - 20 dm\n"
                + "2. Healing Potion - 30 heal\n"
                + "3. Jump Slash - 20 dm\n"
                + "4. Shield - blocks the enemy hit\n"
                + "5. Shield Throw - 30 dm\n"
                + "6. Metal Tornado - 40 dm\n"
                + "7. Healing Blade - 40 heal");
           
        //creates a new array to hold the 4 moves the player selects
        String[] melChoices = new String[4]; 
        //creates a new array to hold the 4 move damages that go with the selected moves
        int[] melAttack = new int[4]; 
        
        //for loop that runs 4 times, so the player can select 4 moves to use in battle
        for (int i = 0; i < melChoices.length; i++) 
        {   
            //asks the player what moves they want and parses that choice into 
            //an integer
            String inputChoice = JOptionPane.showInputDialog(MELDISPLAY);
            int userChoice = Integer.parseInt(inputChoice); 
            //error checks the user input to make sure it is within a certain range           
            while(userChoice > 7 || userChoice < 0)
            {
                //prints if the number is not within the specified range
                JOptionPane.showMessageDialog(null,"Please enter a correct number");
                inputChoice = JOptionPane.showInputDialog(MELDISPLAY);
                userChoice = Integer.parseInt(inputChoice); 
            }  
            //fills up both arrays based on each index number of move the player
            //selects. These two arrays will each have 4 elements, that will have
            //the move name, and the corresponding damage
            melChoices[i] = MELMOVES[userChoice];
            melAttack[i] = MELDMG[userChoice];                                                                                                                                                                     
        } 
        //sends the selected move damage back to the moveDmg property
        moveDmg = melAttack;
        //sends the selected move names back to the moves property
        moves = melChoices; 
        //sends the health of this particular class back to the health property
        health = 700;
    }
    
    /**
     * Method if the player chooses the wizard class
     */
    public void wizard()
    {
        //a final string to hold the move names
        final String[] WIZMOVES = {"Yell - 20 dm\n",
                "Healing Spell - 30 heal\n",
                "Earthquake - 40 dm\n",
                "Leaf Storm - 50 dm\n",
                "Icicle Flurry - 60 dm\n",
                "Magic Shield - blocks the enemy hit\n",
                "Life Altar - 60 heal\n",
                "Spontaneous Combustion - 80 dm\n"};
        //final int to hold the damage amounts that each move does
        int[] WIZDAMAGE = {-20, 30, -40, -50, -60, 0, 60, -80};
        //These two arrays have their index numbers matched up, for example,
        //Yell is at index 0, and Yell does 15 damage, which means that 
        //20 in the damage array is at index 0 too.
        //This way, I can retrieve a single number that can be used to get both
        //the attack name and the amount of damage that attack does
        
        //a final string to hold the moves that will be displayed in the selection
        //screen
        final String WIZDISPLAY = ("Choose 4 Moves \n"
                + "Enter the number of move to select\n\n"
                + "0. Yell - 20 dm\n"
                + "1. Healing Spell - 30 heal\n"
                + "2. Earthquake - 40 dm\n"
                + "3. Leaf Storm - 50 dm\n"
                + "4. Icicle Flurry - 60 dm\n"
                + "5. Magic Shield - blocks the enemy hit\n"
                + "6. Life Altar - 60 heal\n"
                + "7. Spontaneous Combustion - 80 dm");
                        
        //creates a new array to hold the 4 moves the player selects
        String[] wizChoices = new String[4]; 
         //creates a new array to hold the 4 move damages that go with the selected moves
        int[] wizAttack = new int[4];   
        
        //for loop that runs 4 times, so the player can select 4 moves to use in battle
        for (int i = 0; i < wizChoices.length; i++) 
        {   
            //asks the player what moves they want and parses that choice into 
            //an integer
            String inputChoice = JOptionPane.showInputDialog(WIZDISPLAY);
            int userChoice = Integer.parseInt(inputChoice); 
            //error checks the user input to make sure it is within a certain range
            while(userChoice > 7 || userChoice < 0)
            {
                //prints if the number is not within the specified range
                JOptionPane.showMessageDialog(null,"Please enter a correct number");
                inputChoice = JOptionPane.showInputDialog(WIZDISPLAY);
                userChoice = Integer.parseInt(inputChoice); 
            }
            //fills up both arrays based on each index number of move the player
            //selects. These two arrays will each have 4 elements, that will have
            //the move name, and the corresponding damage
            wizChoices[i] = WIZMOVES[userChoice];
            wizAttack[i] = WIZDAMAGE[userChoice];                                                                                                                                                                     
        }  
        //sends the selected move damage back to the moveDmg property
        moveDmg = wizAttack;
        //sends the selected move names back to the moves property
        moves = wizChoices;
        //sends the health of this particular class back to the health property
        health = 300;
    }
    
    /**
     * Method if player selects the ranged class
     */
    public void ranged()
    {
        //a final string to hold the move names
        final String[] RNGMOVES = {"1911 - 20 dm\n",
                "Medical Kit - 25 heal\n",
                "Ak-47 - 30 dm\n",
                "Shotgun - 35 dm\n",
                "Riot Shield - blocks the enemy hit\n",
                "Revolver - 40 dm\n",
                "Desert Eagle - 50 dm\n",
                "Air Support - 35 heal\n"};
        
        //creates a new array to hold the 4 moves the player selects
        final int[] RNGDMG = {-20, 25, -30, -35, 0, -40, -50, 35}; 
        //These two arrays have their index numbers matched up, for example,
        //1911 is at index 0, and 1911 does 15 damage, which means that 
        //20 in the damage array is at index 0 too.
        //This way, I can retrieve a single number that can be used to get both
        //the attack name and the amount of damage that attack does
        
        //a final string to hold the moves that will be displayed in the selection
        //screen
        final String RNGDISPLAY = ("Choose 4 Moves \n"
                + "Enter the number of move to select\n\n"
                + "0. 1911 - 20 dm"
                + "1. Medical Kit - 25 heal\n"
                + "2. Ak-47 - 30 dm\n"
                + "3. Shotgun - 35 dm\n"
                + "4. Riot Shield - blocks the enemy hit\n"
                + "5. Revolver - 40 dm\n"
                + "6. Desert Eagle - 50 dm\n"
                + "7. Air Support - 35 heal");
                       
        //creates a new array to hold the 4 moves the player selects
        String[] rngChoices = new String[4];  
        //creates a new array to hold the 4 move damages that go with the selected moves
        int[] rngAttack = new int[4];  
        
        //for loop that runs 4 times, so the player can select 4 moves to use in battle
        for (int i = 0; i < rngChoices.length; i++) 
        {   
            //asks the player what moves they want and parses that choice into 
            //an integer
            String inputChoice = JOptionPane.showInputDialog(RNGDISPLAY);
            int userChoice = Integer.parseInt(inputChoice);
            //error checks the user input to make sure it is within a certain range
            while(userChoice > 7 || userChoice < 0)
            {
                //prints if the number is not within the specified range
                JOptionPane.showMessageDialog(null,"Please enter a correct number");
                inputChoice = JOptionPane.showInputDialog(RNGDISPLAY);
                userChoice = Integer.parseInt(inputChoice); 
            } 
            //fills up both arrays based on each index number of move the player
            //selects. These two arrays will each have 4 elements, that will have
            //the move name, and the corresponding damage
            rngChoices[i] = RNGMOVES[userChoice];
            rngAttack[i] = RNGDMG[userChoice];                                                                                                                                                                     
        }  
        //sends the selected move damage back to the moveDmg property
        moveDmg = rngAttack;
        //sends the selected move names back to the moves property
        moves = rngChoices;
        //sends the health of this particular class back to the health property
        health = 400;
    }
    
    /**
     * Method if player selects summoner class
     */
    public void summoner()
    {
        //a final string to hold the move names
        final String[] SUMMOVES = {"Bees - 30 dm\n",
                "Tree of Life - 20 heal\n",
                "Wolves - 50 dm\n",
                "Wyverns - 70 dm\n",
                "John Wick - 100 dm\n",
                "Doctor - 30 heal\n",
                "Giant Tortoise - blocks the enemy hit\n",
                "Danny Devito - 150 dm\n"};
         //creates a new array to hold the 4 moves the player selects
        final int[] SUMDMG = {-30, 20, -50, -70, -100, 30, 0, -150};
        //These two arrays have their index numbers matched up, for example,
        //Bees is at index 0, and bees do 30 damage, which means that 
        //30 in the damage array is at index 0 too.
        //This way, I can retrieve a single number that can be used to get both
        //the attack name and the amount of damage that attack does
        
        //a final string to hold the moves that will be displayed in the selection
        //screen
        final String SUMDISPLAY = ("Choose 4 Moves \n"
                + "Enter the number of move to select\n\n"
                + "0. Bees - 30 dm\n"
                + "1. Tree of Life - 20 heal\n"
                + "2. Wolves - 50 dm\n"
                + "3. Wyverns - 70 dm\n"
                + "4. John Wick - 100 dm\n"
                + "5. Doctor - 30 heal\n"
                + "6. Giant Tortoise - blocks the enemy hit\n"
                + "7. Danny Devito - 150 dm");
                
        //creates a new array to hold the 4 moves the player selects
        String[] sumChoices = new String[4]; 
        //creates a new array to hold the 4 move damages that go with the selected moves
        int[] sumAttack = new int[4]; 
        
        //for loop that runs 4 times, so the player can select 4 moves to use in battle
        for (int i = 0; i < sumChoices.length; i++) 
        {   
            //asks the player what moves they want and parses that choice into 
            //an integer
            String inputChoice = JOptionPane.showInputDialog(SUMDISPLAY);
            int userChoice = Integer.parseInt(inputChoice);
            //error checks the user input to make sure it is within a certain range
            while(userChoice > 7 || userChoice < 0)
            {
                //prints if the number is not within the specified range
                JOptionPane.showMessageDialog(null,"Please enter a correct number");
                inputChoice = JOptionPane.showInputDialog(SUMDISPLAY);
                userChoice = Integer.parseInt(inputChoice); 
            } 
            //fills up both arrays based on each index number of move the player
            //selects. These two arrays will each have 4 elements, that will have
            //the move name, and the corresponding damage
            sumChoices[i] = SUMMOVES[userChoice];
            sumAttack[i] = SUMDMG[userChoice];                                                                                                                                                                     
        }  
        //sends the selected move damage back to the moveDmg property
        moveDmg = sumAttack;
        //sends the selected move names back to the moves property
        moves = sumChoices;
        //sends the health of this particular class back to the health property
        health = 50;
    }
}
