import java.util.*;
import java.util.concurrent.*;

public class Game {
    private long totalCupcakes = 0;
    private List<Building> buildings = new ArrayList<>();

    public Game() {
        // Initialize your building types
        buildings.add(new Building("Grandma", 1));   // Adds 1 per 10s
        buildings.add(new Building("Factory", 50)); // Adds 50 per 10s
    }

    public void startAutoGeneration() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        scheduler.scheduleAtFixedRate(() -> {
            int cupcakesProducedThisTurn = 0;
            
            // Sum up production from all building types
            for (Building b : buildings) {
                cupcakesProducedThisTurn += b.getTotalProduction();
            }
            
            totalCupcakes += cupcakesProducedThisTurn;
            System.out.println("Added " + cupcakesProducedThisTurn + " cupcakes! Total: " + totalCupcakes);
            System.out.println("Press any key to see upgrade/buy options...");
            
        }, 0, 10, TimeUnit.SECONDS);
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
