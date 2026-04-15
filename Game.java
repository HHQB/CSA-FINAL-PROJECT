import java.io.*;
import java.util.*;

public class Game {
    private long totalCupcakes = 0;
    private List<Building> buildings = new ArrayList<>();
    private volatile boolean waitingForChoice = false;
    private StringBuilder inputBuffer = new StringBuilder();
    private long lastGeneration;

    public Game() {
        // Initialize your building types
        buildings.add(new Building("Clicker", 1)); // Adds 1 per 5s
        buildings.add(new Building("Grandma", 10));   // Adds 10 per 5s
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
        
        while (true) {
            // Check for input
            checkInput();
            
            // Check for generation
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastGeneration >= 5000) {
                generateCupcakes();
                lastGeneration = currentTime;
            }
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    
    private void checkInput() {
        try {
            while (System.in.available() > 0) {
                int c = System.in.read();
                if (c == '\n' || c == '\r') {
                    String line = inputBuffer.toString().trim();
                    inputBuffer.setLength(0);
                    if (!waitingForChoice) {
                        showOptions();
                        waitingForChoice = true;
                    } else {
                        processChoice(line);
                        waitingForChoice = false;
                    }
                } else {
                    inputBuffer.append((char)c);
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
        System.out.println("1. Buy Clicker (Cost: 10 cupcakes)");
        System.out.println("2. Buy Grandma (Cost: 100 cupcakes)");
        System.out.println("3. Buy Farm (Cost: 500 cupcakes)");
        System.out.println("4. Buy Factory (Cost: 1000 cupcakes)");
        System.out.println("5. Buy Bank (Cost: 2000 cupcakes)");
        System.out.println("6. Buy Temple (Cost: 5000 cupcakes)");
        System.out.println("7. Buy Wizard-Tower (Cost: 10000 cupcakes)");
        System.out.println("Enter your choice:");
    }
    
    private void processChoice(String choice) {
        if (choice.equals("1") && totalCupcakes >= 10) {
            buyClicker();
            totalCupcakes -= 10;
            System.out.println("Bought a Clicker! Total Cupcakes: " + totalCupcakes);
        } else if (choice.equals("2") && totalCupcakes >= 100) {
            buyGrandma();
            totalCupcakes -= 100;
            System.out.println("Bought a Grandma! Total Cupcakes: " + totalCupcakes);
        } else if (choice.equals("3") && totalCupcakes >= 500) {
            buyFarm();
            totalCupcakes -= 500;
            System.out.println("Bought a Farm! Total Cupcakes: " + totalCupcakes);
        } else if (choice.equals("4") && totalCupcakes >= 1000) {
            buyFactory();
            totalCupcakes -= 1000;
            System.out.println("Bought a Factory! Total Cupcakes: " + totalCupcakes);
        } else if (choice.equals("5") && totalCupcakes >= 2000) {
            buyBank();
            totalCupcakes -= 2000;
            System.out.println("Bought a Bank! Total Cupcakes: " + totalCupcakes);
        } else if (choice.equals("6") && totalCupcakes >= 5000) {
            buyTemple();
            totalCupcakes -= 5000;
            System.out.println("Bought a Temple! Total Cupcakes: " + totalCupcakes);
        } else if (choice.equals("7") && totalCupcakes >= 10000) {
            buyWizardTower();
            totalCupcakes -= 10000;
            System.out.println("Bought a Wizard-Tower! Total Cupcakes: " + totalCupcakes);
        } else {
            System.out.println("Not enough cupcakes or invalid choice.");
        }
    }
    
    public void buyClicker() {
        // Simple example to increment count
        buildings.get(0).count++; 
    }

    public void buyGrandma() {
        // Simple example to increment count
        buildings.get(1).count++; 
    }

    public void buyFarm() {
        // Simple example to increment count
        buildings.get(2).count++; 
    }
    
    public void buyFactory() {
        // Simple example to increment count
        buildings.get(3).count++; 
    }

    public void buyBank() {
        // Simple example to increment count
        buildings.get(4).count++; 
    }

    public void buyTemple() {
        // Simple example to increment count
        buildings.get(5).count++; 
    }

    public void buyWizardTower() {
        // Simple example to increment count
        buildings.get(6).count++; 
    }
}
