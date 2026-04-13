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
        buildings.add(new Building("Grandma", 1));   // Adds 1 per 10s
        buildings.add(new Building("Factory", 50)); // Adds 50 per 10s
    }

    public void run() {
        lastGeneration = System.currentTimeMillis();
        System.out.println("Game started! Cupcakes will be generated every 10 seconds.");
        System.out.println("Press Enter to see upgrade/buy options...");
        
        while (true) {
            // Check for input
            checkInput();
            
            // Check for generation
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastGeneration >= 10000) {
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
        System.out.println("1. Buy Grandma (Cost: 10 cupcakes)");
        System.out.println("2. Buy Factory (Cost: 500 cupcakes)");
        System.out.println("Enter your choice:");
    }
    
    private void processChoice(String choice) {
        if (choice.equals("1") && totalCupcakes >= 10) {
            buyGrandma();
            totalCupcakes -= 10;
            System.out.println("Bought a Grandma! Total Cupcakes: " + totalCupcakes);
        } else if (choice.equals("2") && totalCupcakes >= 500) {
            buyFactory();
            totalCupcakes -= 500;
            System.out.println("Bought a Factory! Total Cupcakes: " + totalCupcakes);
        } else {
            System.out.println("Not enough cupcakes or invalid choice.");
        }
    }
    
    public void buyGrandma() {
        // Simple example to increment count
        buildings.get(0).count++; 
    }
    
    public void buyFactory() {
        // Simple example to increment count
        buildings.get(1).count++; 
    }
}
