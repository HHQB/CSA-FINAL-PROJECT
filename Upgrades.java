public class Upgrades {
    String name;
    long cost; // Cost of the upgrade
    String description; // Description of the upgrade's effect
    Building targetBuilding; // The specific building this upgrade affects

    /**
     * Creates a new upgrade with a name, cost, and description.
     *
     * @param name        the name of the upgrade
     * @param cost        the cost of the upgrade
     * @param description a description of what the upgrade does
     */
    public Upgrades(String name, long cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.targetBuilding = null;
    }

    /**
     * Creates a new upgrade targeted at a specific building.
     *
     * @param name            the name of the upgrade
     * @param cost            the cost of the upgrade
     * @param description     a description of what the upgrade does
     * @param targetBuilding  the building this upgrade affects
     */
    public Upgrades(String name, long cost, String description, Building targetBuilding) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.targetBuilding = targetBuilding;
    }

    /**
     * Applies a building upgrade to the target building, multiplying its future purchase price by 100.
     */
    public void buildingUpgrade() {
        if (targetBuilding != null) {
            targetBuilding.upgrade();
            System.out.println(name + " applied to " + targetBuilding.name + "!");
            System.out.println("New upgrade level: " + targetBuilding.getUpgradeLevel());
            System.out.println("New building price: " + String.format("%.2f", targetBuilding.getPrice()));
        } else {
            System.out.println("Error: No target building set for this upgrade!");
        }
    }

    public void multiplierUpgrade() {
        Game.productionMultiplier *= 2; // Example: doubles the production multiplier
        System.out.println("Production multiplier increased! Current multiplier: " + Game.productionMultiplier);
    }
}