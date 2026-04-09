public class Main {
    public static void main(String[] args) {
        // 1. Create the game instance
        Game myGame = new Game();

        // 2. Start the background production timer
        myGame.startAutoGeneration();

        // 3. Simulate buying buildings
        System.out.println("Starting game! Buying 3 Factories...");
        myGame.buyFactory(); 
        myGame.buyFactory(); 
        myGame.buyFactory(); 

        // 4. Keep the app running
        // In a real GUI app, the window (JFrame) keeps the program open.
        // For a console app, we use a simple loop or sleep to prevent it from exiting immediately.
        try {
            System.out.println("Game is active. Check the console for updates every 10 seconds.");
            while (true) {
                Thread.sleep(1000); // Keep the main thread alive
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
