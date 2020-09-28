import java.util.Scanner; //Importing scanner from Java library

public class Main { //Compiler begins at this point
    public static void main(String[] args) {
        menu(); //Calling menu method
    }

    public static void menu() {
        System.out.println("-------------------------\n" +
                "--------WELCOME TO-------\n" +
                "-----ADVENTURE QUEST-----\n" +
                "-------------------------");

        /*Declaring an instance variable of type Scanner pointing
        towards a new object imported from java.util library*/
        Scanner menuInput = new Scanner(System.in);

        System.out.println("1. How to play\n" +
                "2. Start game ");

        if (!menuInput.hasNextInt()) {
            System.out.println("wrong input!");
            System.out.println("Let's start over");
            menu(); //avoiding an exception by calling menu again if user input is no integer
        }

        int menuChoice = menuInput.nextInt(); //declaring int menuChoice and sets it as input

        //switch statement controlled by int menuChoice
        switch (menuChoice) {
            case 1:
                rules(); //Calling rules method (this class, line: 42)
                break; //breaks out of switch statement if this is the case
            case 2:
                init(); //Calling init method (this class, line: 67)
                break;
            default:
        }
        menu(); //avoiding an exception if user input doesn't match switch statement
    }

    public static void rules() {
        System.out.println("-------------------------\n" +
                "----------RULES----------\n" +
                "-------------------------\n" +

                "     ______ ______\n" +
                "    _/      Y      \\_\n" +
                "   // ~~ ~~ | ~~ ~  \\\\\n" +
                "  // ~ ~ ~~ | ~~~ ~~ \\\\\n" +
                " //________.|.________\\\\\n" +
                "`----------`-'----------'\n" +

                "Welcome to a text-based adventure RPG! \n You choose a character " +
                "that you follow through different locations. The type of character   \n" +
                "you choose determines the stats, abilities and items available. As the game  \n" +
                "begins you'll run into different kind of situations depending on your \n" +
                "decisions. " + "\n\n" + "How to play: you decide the characters action by entering an integer \n" +
                "regarding the action you wish the character to perform\n");


        menu(); //Calling menu method (this class, line: 08) again to make the program loop
    }

    public static void init() {
        World.createWorld(); //Calling method from World class (class World, line: 06)
    }
}
