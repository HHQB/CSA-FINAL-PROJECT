public class Main {
    /**
     * Starts the cupcake game by creating a new {@code Game} instance and running
     * it.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // 1. Create the game instance
        Game myGame = new Game();

        // 2. Simulate buying buildings
        System.out.println("Starting game... Press Space then Enter to generate a cupcake");

        // 3. Start the game
        myGame.run();
    }
}
