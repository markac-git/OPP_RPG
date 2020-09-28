import java.util.Random;

/*OBS! This subclass extends player. Therefore it adopts methods from within the abstract parent class Player
 * Most of the methods within this class overwrites the abstract methods defined in Player. Furthermore
 * this subclass is much alike the other subclass "Mage". Therefore, only a few comments are written where
 * this class separates from the other one. */
public class Warrior extends Player {
    private int stamina = 100;
    private int numOfHeals = 3;
    private int numOfStaminaPotions = 3;

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getNumOfHeals() {
        return numOfHeals;
    }

    public void setNumOfHeals(int numOfHeals) {
        this.numOfHeals = numOfHeals;
    }

    public int getNumOfStaminaPotions() {
        return numOfStaminaPotions;
    }

    public void setNumOfStaminaPotions(int numOfStaminaPotions) {
        this.numOfStaminaPotions = numOfStaminaPotions;
    }

    @Override
    public int attack() {
        int damageDealt;
        if (stamina >= 10) {
            System.out.println(
                    "--------------------------\n" +
                            "-------PLAYER ATTACK------\n" +
                            "--------------------------\n" +
                            "      /| ________________ \n" +
                            "O|===|* >________________>\n" +
                            "      \\|\n");

            System.out.println("*** Swinging sword ***");
            stamina -= 10; //spending stamina when swinging sword

            Random random = new Random();
            damageDealt = getMaxAtt() - random.nextInt(9);
            System.out.println("Damage dealt: " + damageDealt);
            System.out.println();
        } else {
            System.out.println("OOOH NO.. You don't got enough mana left but the \n enemy still saw you in your attempt...");
            damageDealt = 0;
        }
        return damageDealt;
    }

    @Override
    public void status() {
        System.out.println("-------------------------\n" +
                "------PLAYER STATUS------\n" +
                "-------------------------");
        System.out.println(
                "           |\n" +
                        "      \\+/  |\n" +
                        "   | _<=>_ |\n" +
                        "  0/ \\ / o=o\n" +
                        " \\/\\ ^ /`0\n" +
                        "     /_^_\\\n" +
                        "     || ||\n" +
                        "    _d|_|b_\n");
        System.out.println(getRole() + " " + getName() + ":");
        System.out.println("Lvl             : " + getLvl());
        System.out.println("Max health      : " + getMaxHp());
        System.out.println("Current Health  : " + gethP());
        System.out.println("Stamina:        : " + stamina);
        System.out.println("Heal potions:   : " + numOfHeals);
        System.out.println("Stamina potions : " + numOfStaminaPotions);
        System.out.println("Max Damage      : " + getMaxAtt());
        System.out.println();
    }

    @Override
    public boolean flee() {
        move();
        boolean flee;
        Random random = new Random();
        int chance = (((random.nextInt(5)) + 1) * stamina);

        if (chance > 200) {
            System.out.println("Managed to flee ...");
            flee = true;
        } else {
            System.out.println("Failed to flee ...");
            flee = false;
        }
        return flee;
    }

    @Override
    public void move() {
        System.out.print("*** Running *** ");
        stamina -= 5;
        System.out.println("your stamina is reduced to " + stamina);
    }

    @Override
    public void takePotion() {
        System.out.println("1. Take stamina potion");
        System.out.println("2. Take health potion");
        switch (choose()) {
            case 1:
                staminaPotion();
                break;
            case 2:
                healing();
                break;
            default:
                /*error handling: this line is read if user input doesn't match the options in this case: 1,2.
                this is an error handling in addition to (class Player, line: 113)*/
                System.out.println("Your choice doesn't match the options given");
        }
    }

    private void healing() {
        System.out.println("*** Tacking health potion ***");
        numOfHeals--;
        sethP(getMaxHp());
        System.out.println("Now you have " + numOfHeals + " health potions left");
        System.out.println("and your HP is now " + gethP());
    }

    private void staminaPotion() {
        if (numOfHeals > 0) {
            System.out.println("*** Tacking stamina potion ***");
            numOfStaminaPotions--;
            stamina += 20;
            System.out.println("Now you have " + numOfStaminaPotions + " stamina potions left");
            System.out.println("And your stamina is now " + stamina);
        } else {
            System.out.println("You don't got any stamina potions left");
        }
    }
}
