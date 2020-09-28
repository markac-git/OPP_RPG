import java.util.Random;

public class World {

    //CRATING WORLD - Called by init()
    public static void createWorld() {
        /*Declaring an instance variable of the abstract type Player
        pointing towards a new object (this class, line: 17) created from method (class Player, line: 99-102),
        which returns a sub class that extends the abstract class Player. Hereby meant
        that the new object created - that the instance variable refers to - is either
        pointing at a new Mage or new Warrior*/

        Player player = null; //instance variable is pointing at null from the beginning

        //avoiding an exception - loops while user input doesn't match options given and the player type remains null.
        while (player == null) {
            player = Player.createPlayer();
        }

        /*Calling abstract method (class Player, line: 135), which gets overwritten
        by the subclass, the instance variable "player" is pointing towards. For instance
        if player points at mage, following code is read (class Mage, line: 28)*/
        player.status();

        /*Creating an array of type Location. The instance variable refers to a
         *new object of an array containing 5 Location objects*/
        Location[] locations = new Location[11];

        /*for-loop that runs from 1 to the end of the Location array*/
        for (int i = 1; i < locations.length; i++) {
            /*for every time the loop runs, a new Location, level i
            (regarding to the constructor of Location (class Location, line: XX))
             is placed at position i in the array*/
            locations[i] = new Location(i);
        }

        /*Creating an array of type Enemy. The instance variable refers to a
         *new object of an array containing 5 Enemy objects*/
        Enemy[] enemies = new Enemy[locations.length];
        /*for-loop that runs from 0 to the end of the Enemy array*/
        for (int i = 0; i < enemies.length; i++) {
              /*for every time the loop runs, a new Enemy, level i
            (regarding to the constructor of Enemy (class Enemy, line: XX))
             is placed at position i in the array*/
            enemies[i] = new Enemy(i);
        }

        //Calling game method that expects following parameters
        game(enemies, player, locations);
    }

    //Game method
    public static void game(Enemy[] enemies, Player player, Location[] locations) {
        int state=1; //Declaring and initializing int variable
        boolean nextDoor; //Declaring boolean variable

        /*for-loop that through the locations from zero*/
        for (state=1; state < locations.length; state++) {
            nextDoor = false; //boolean that sort of runs the repetition of for-loop is set to false
            /*prints out toString method (class Location, line: 23) on index=state of array*/
            System.out.println(locations[state].toString());
            System.out.print("As you are ");
            /*Calling abstract method (class Player, line: ), which gets overwritten
            by the subclass, the instance variable "player" is pointing towards*/
            player.move();
            /*Calling method that returns an random integer bound 2 (class Location, line: 136),
             * and controls whether situationOne or situationTwo shall run, while boolean "nextDoor" is false*/
            if (Location.pickRandomSituation()==1) { //alternatively <0.5
                while (!nextDoor) {
                    nextDoor = Location.situationOne(player, enemies, state, nextDoor);
                }
            } else {
                while (!nextDoor) {
                    nextDoor = Location.situationTwo(player, enemies, state, nextDoor);
                }
            }
            //repeats from (line: 53) if nextDoor is true131
        }
    }
}

