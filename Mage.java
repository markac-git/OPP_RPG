import java.util.Random;

/*OBS! This subclass extends player. Therefore it adopts methods from within the abstract parent class Player
 * Most of the methods within this class overwrites the abstract methods defined in Player. The comments written
 * in this class can mostly be transferred to the other subclass "Warrior". Therefore, I've only written a few
 * comments in Warrior class that separates it from this class. Therefore, this class' comments should be read first*/
public class Mage extends Player {
    private int mana = 100;
    private int numOfManaPotions = 5;


    //Creating Getters and Setters to make variables accessible from outside this class
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getNumOfManaPotions() {
        return numOfManaPotions;
    }

    public void setNumOfManaPotions(int numOfManaPotions) {
        this.numOfManaPotions = numOfManaPotions;
    }


    @Override
    public void status() {
        System.out.println("-------------------------\n" +
                "------PLAYER STATUS------\n" +
                "-------------------------");
        System.out.println(
                "     __/\\__\n" +
                        ". _  \\\\''//\n" +
                        "-( )-/_||_\\\n" +
                        " .'. \\_()_/\n" +
                        "  |   | . \\\n" +
                        "  |   | .  \\\n" +
                        " .'. ,\\_____'.\n");
        //calling getters to access the variable from Player class except mana and numOfManaPotions since they are within this class
        System.out.println(getRole() + " " + getName() + ":");
        System.out.println("Lvl             : " + getLvl());
        System.out.println("Max health      : " + getMaxHp());
        System.out.println("Current Health  : " + gethP());
        System.out.println("Mana            : " + mana);
        System.out.println("Mana potions    : " + numOfManaPotions);
        System.out.println("Max Damage      : " + getMaxAtt() + "\n");

    }

    /*Called by (class Location, line: 184) overwrites abstract method from Player.
    Returns either true or false depending on whether the player manage to flee,
    which controls the nextDoor boolean in class Location*/
    @Override
    public boolean flee() {
        move(); //calling (this class, line 70) // no matter what, player is moving
        boolean flee;
        Random random = new Random(); //repeat (class Location, line: 141)
        int chance = (((random.nextInt(5))) + 1) * mana; //picks an integer between 1-6 and times it with mana
        //decides whether the player manage to flee in addition to variable "change"
        if (chance > 200) {
            System.out.println("Managed to flee ...");
            flee = true;
        } else {
            System.out.println("Failed to flee ...");
            flee = false;
        }
        return flee; //returns either true or false
    }

    @Override
    public void move() {
        System.out.print("*** Hovering above the ground *** ");
        mana -= 5; //spends mana as hovering
        System.out.println("your mana is reduced to " + mana);
    }

    /*Overwrites abstract method from class Player*/
    @Override
    public void takePotion() {
        System.out.println("1. Take mana potion");
        System.out.println("2. Take health potion");

        /*As subclasses adopts methods from parent class choose can be
        called to avoid initialising more Scanners*/
        switch (choose()) {
            case 1:
                manaPotion(); //calling method (this class, line: 126)
                break;
            case 2:
                healing(); //calling method (this class, line: 118)
                break;
            default:
                /*error handling: this line is read if user input doesn't match the options in this case: 1,2.
                this is an error handling in addition to (class Player, line: 113)*/
                System.out.println("Your choice doesn't match the options given");
        }
    }

    /*Overwrites abstract method from Player. Method that returns an integer: "damage dealt"*/
    @Override
    public int attack() {
        int damageDealt;

        if (mana >= 10) {
            //if enough mana left
            System.out.println(
                    "----------------- \n" +
                            "--PLAYER ATTACK-- \n" +
                            "-----------------");
            System.out.println("*** Casting Spell ***");
            mana -= 10; //spends mana

            Random random = new Random(); //repeat (class Location, line: 141)
            damageDealt = getMaxAtt() - random.nextInt(10); //maxDamage minus (picks random integer from 0-9)
            if (damageDealt == 0) {
                System.out.println("*** Missed... *** \n"); //player is able to miss and not deal any damage
            } else {
                System.out.println("Damage dealt: " + damageDealt + "\n");
            }
        } else {
            //if not enough mana left
            System.out.println("OOOH NO.. You don't got enough mana left but the \n enemy still saw you in your attempt...");
            damageDealt = 0; //returns zero if no mana left. The enemy still gets the change to attack
        }
        return damageDealt;
    }

    //called by (this class, line: 90)
    private void healing() {
        if (mana >= 20) { //ain't using getters and setters as variables are from within this class - except hP and maxHp
            //if enough mana
            System.out.println("*** Healing spell is casted ***");
            mana -= 20; //spends mana on healing
            sethP(getMaxHp()); //calling setter and getter from parent class Player and sets hP to maxHp
            System.out.println("Now you have " + mana + " mana left");
            System.out.println("and your HP is now " + gethP());
        } else {
            System.out.println("You don't got enough mana");
        }
    }

    //called by (this class, line: 87)
    private void manaPotion() {
        if (numOfManaPotions > 0) { //ain't using getters and setters as variables are from within this class
            //if any potions left
            System.out.println("*** Tacking mana potion ***");
            numOfManaPotions--;
            mana += 20;
            System.out.println("Now you have " + numOfManaPotions + " mana potions left");
            System.out.println("And your mana is now " + mana);
        } else {
            System.out.println("You don't got any mana potions left");
        }
    }
}
