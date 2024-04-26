public class Main {
    public static void main(String[] args) {
        // Create a new GUI
        GUI gui = new GUI();
        
        // Create a race with a distance of 10
        Race myRace = new Race(10);

        // Create three horses
        Horse horse1 = new Horse('A', "Apollo", "TEST", "TEST");
        Horse horse2 = new Horse('B', "Bucephalus", "TEST", "TEST");
        Horse horse3 = new Horse('C', "Comet", "TEST", "TEST");

        // Add the horses 
        myRace.addHorse(horse1, 1);
        myRace.addHorse(horse2, 2);
        myRace.addHorse(horse3, 3);

        // Start the race
        myRace.startRace();
    
        
    }
}