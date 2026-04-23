import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    // the long that counts all dem cupcakes
    private long totalCupcakes = 0;
    // arraylist of buldings
    private List<Building> buildings = new ArrayList<>();
    // for input handling
    private volatile boolean waitingForChoice = false;
    // buffer for input
    private StringBuilder inputBuffer = new StringBuilder();
    // for cupcake generation timing
    private long lastGeneration;
    // track if space was pressed (for space+enter to generate cupcake)
    private boolean spacePressedBeforeEnter = false;

    public Game() {
        // Initialize your building types
        buildings.add(new Building("Clicker", 1)); // Adds 1 per 5s
        buildings.add(new Building("Grandma", 10)); // Adds 10 per 5s
        buildings.add(new Building("Farm", 50)); // Adds 50 per 5s
        buildings.add(new Building("Factory", 500)); // Adds 500 per 5s
        buildings.add(new Building("Bank", 1000)); // Adds 1000 per 5s
        buildings.add(new Building("Temple", 2000)); // Adds 2000 per 5s
        buildings.add(new Building("Wizard-Tower", 5000)); // Adds 5000 per 5s
    }

    public void run() {
        lastGeneration = System.currentTimeMillis();
        System.out.println("Game started! Cupcakes will be generated every 5 seconds.");
        System.out.println("Press Enter to see upgrade/buy options...");

        // Main game loop
        while (true) {
            // Check for input
            checkInput();

            // Check for generation THIS IS THE GENERATION TIMER (:
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastGeneration >= 5000) {
                generateCupcakes();
                lastGeneration = currentTime;
            }
            // Sleep briefly to avoid busy waiting
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    // input handling
    private void checkInput() {
        try {
            // read available input without blocking
            while (System.in.available() > 0) {
                int c = System.in.read();
                if (c == ' ') {
                    spacePressedBeforeEnter = true; // Mark that space was pressed
                } else if (c == '\n' || c == '\r') {
                    // Check if space was pressed before this enter
                    if (spacePressedBeforeEnter) {
                        // Space + Enter = generate cupcake
                        totalCupcakes += 1;
                        System.out.println("Added 1 cupcake! Total: " + totalCupcakes);
                        spacePressedBeforeEnter = false;
                    } else {
                        // Just Enter = open buy menu
                        String line = inputBuffer.toString().trim();
                        inputBuffer.setLength(0);
                        if (!waitingForChoice) {
                            showOptions();
                            waitingForChoice = true;
                        } else {
                            processChoice(line);
                            waitingForChoice = false;
                        }
                    }
                } else {
                    inputBuffer.append((char) c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateCupcakes() {
        int cupcakesProducedThisTurn = 0;

        // Sum up production from all building types
        for (Building b : buildings) {
            cupcakesProducedThisTurn += b.getTotalProduction();
        }

        totalCupcakes += cupcakesProducedThisTurn;
        System.out.println("Added " + cupcakesProducedThisTurn + " cupcakes! Total: " + totalCupcakes);
        System.out.println("Press Enter to see upgrade/buy options...");
    }

    private void showOptions() {
        System.out.println("Upgrade/Buy options:");
        for (int i = 0; i < buildings.size(); i++) {
            Building b = buildings.get(i);
            System.out.println((i + 1) + ". Buy " + b.name + " (Cost: " + b.getPrice() + " cupcakes)");
        }
        System.out.println("Enter your choice:");
    }

    // process the player's choice and buy the corresponding building if they have
    // enough cupcakes
    private void processChoice(String choice) {
        int index;
        try {
            index = Integer.parseInt(choice) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice.");
            return;
        }

        if (index < 0 || index >= buildings.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Building building = buildings.get(index);
        int price = building.getPrice();

        if (totalCupcakes < price) {
            System.out.println("Not enough cupcakes. You need " + price + ".");
            return;
        }

        totalCupcakes -= price;
        building.count++;
        System.out.println("Bought a " + building.name + "! Total Cupcakes: " + totalCupcakes);
    }

    // methods to buy the buildings
    public void buyClicker() {
        // increase count
        buildings.get(0).count++;
    }

    public void buyGrandma() {
        // increase count
        buildings.get(1).count++;
    }

    public void buyFarm() {
        // increase count
        buildings.get(2).count++;
    }

    public void buyFactory() {
        // increase count
        buildings.get(3).count++;
    }

    public void buyBank() {
        // increase count
        buildings.get(4).count++;
    }

    public void buyTemple() {
        // increase count
        buildings.get(5).count++;
    }

    public void buyWizardTower() {
        // increase count
        buildings.get(6).count++;
    }
}
