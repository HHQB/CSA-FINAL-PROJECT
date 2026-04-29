public class Building {
    String name;
    int count = 0;
    int baseRate; // Amount of cupcakes produced per every ten seconds
    int baseUpgradeCost; // Base cost for the first upgrade of this building
    int upgradeLevel = 0; // Track how many times this building has been upgraded

    /**
     * Creates a new building type with a name and a base cupcake production rate.
     *
     * @param name     the name of the building
     * @param baseRate the base production rate for the building
     */
    public Building(String name, int baseRate) {
        this.name = name;
        this.baseRate = baseRate;
        this.upgradeLevel = 0;
        
        // Set base upgrade cost based on building type
        if (name.equals("Clicker")) {
            this.baseUpgradeCost = 10;
        } else if (name.equals("Grandma")) {
            this.baseUpgradeCost = 100;
        } else if (name.equals("Farm")) {
            this.baseUpgradeCost = 1000;
        } else if (name.equals("Factory")) {
            this.baseUpgradeCost = 10000;
        } else if (name.equals("Bank")) {
            this.baseUpgradeCost = 100000;
        } else if (name.equals("Temple")) {
            this.baseUpgradeCost = 100000;
        } else if (name.equals("Wizard-Tower")) {
            this.baseUpgradeCost = 1000000;
        } else {
            this.baseUpgradeCost = 100;
        }
    }

    /**
     * Returns the total cupcake production for this building based on how many are
     * owned and upgrade level. Each upgrade doubles the production.
     *
     * @return total production from this building type
     */
    int getTotalProduction() {
        return (int)(baseRate * count * Math.pow(2, upgradeLevel));
    }

    /**
     * Calculates the cost to buy the next building of this type.
     *
     * @return the calculated price for the next building
     */
    public double getPrice() {
        if (name.equals("Clicker")) {
            return 10 * Math.pow(1.15, count);
        } else if (name.equals("Grandma")) {
            return 100 * Math.pow(1.15, count);
        } else if (name.equals("Farm")) {
            return 1000 * Math.pow(1.15, count);
        } else if (name.equals("Factory")) {
            return 10000 * Math.pow(1.15, count);
        } else if (name.equals("Bank")) {
            return 1000000 * Math.pow(1.15, count);
        } else if (name.equals("Temple")) {
            return 1000000 * Math.pow(1.15, count);
        } else if (name.equals("Wizard-Tower")) {
            return 1000000000 * Math.pow(1.15, count);
        }
        return Integer.MAX_VALUE; // Default case
    }

    /**
     * Gets the upgrade cost for this building based on upgrade level.
     * Cost multiplies by 100 for each upgrade level.
     *
     * @return the cost of the next upgrade
     */
    public double getUpgradeCost() {
        return baseUpgradeCost * Math.pow(100, upgradeLevel);
    }

    /**
     * Upgrades this building, multiplying future upgrade costs by 100.
     */
    public void upgrade() {
        upgradeLevel++;
    }

    /**
     * Gets the current upgrade level of this building.
     *
     * @return the upgrade level
     */
    public int getUpgradeLevel() {
        return upgradeLevel;
    }
}
