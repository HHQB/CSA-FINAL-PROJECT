public class Building {
    String name;
    long count = 0;
    long baseRate; // Amount of cupcakes produced per every ten seconds
    long baseUpgradeCost; // Base cost for the first upgrade of this building
    long upgradeLevel = 0; // Track how many times this building has been upgraded

    /**
     * Creates a new building type with a name and a base cupcake production rate.
     *
     * @param name     the name of the building
     * @param baseRate the base production rate for the building
     */
    public Building(String name, long baseRate) {
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
        } else if (name.equals("Shipment")) {
            this.baseUpgradeCost = 500000000L;
        } else if (name.equals("Alchemy-Lab")) {
            this.baseUpgradeCost = 3300000000L;
        } else if (name.equals("Portal")) {
            this.baseUpgradeCost = 510000000000L;
        } else if (name.equals("Time-Machine")) {
            this.baseUpgradeCost = 7500000000000L;
        } else if (name.equals("Antimatter-Condenser")) {
            this.baseUpgradeCost = 100000000000L;
        } else if (name.equals("Prism")) {
            this.baseUpgradeCost = 14000000000000L;
        } else if (name.equals("Chancemaker")) {
            this.baseUpgradeCost = 17000000000000L;
        } else if (name.equals("Fractal-Engine")) {
            this.baseUpgradeCost = 21000000000000L;
        } else if (name.equals("Javascript-Console")) {
            this.baseUpgradeCost = 26000000000000L;
        } else if (name.equals("Idleverse")) {
            this.baseUpgradeCost = 31000000000000L;
        } else if (name.equals("Cortex-Baker")) {
            this.baseUpgradeCost = 41000000000000L;
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
    long getTotalProduction() {
        return (long)(baseRate * count * Math.pow(2, upgradeLevel));
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
        } else if (name.equals("Shipment")) {
            return 5000000000.0 * Math.pow(1.15, count);
        } else if (name.equals("Alchemy-Lab")) {
            return 33000000000.0 * Math.pow(1.15, count);
        } else if (name.equals("Portal")) {
            return 510000000000.0 * Math.pow(1.15, count);
        } else if (name.equals("Time-Machine")) {
            return 7500000000000.0 * Math.pow(1.15, count);
        } else if (name.equals("Antimatter-Condenser")) {
            return 100000000000.0 * Math.pow(1.15, count);
        } else if (name.equals("Prism")) {
            return 14000000000000.0 * Math.pow(1.15, count);
        } else if (name.equals("Chancemaker")) {
            return 17000000000000.0 * Math.pow(1.15, count);
        } else if (name.equals("Fractal-Engine")) {
            return 21000000000000.0 * Math.pow(1.15, count);
        } else if (name.equals("Javascript-Console")) {
            return 26000000000000.0 * Math.pow(1.15, count);
        } else if (name.equals("Idleverse")) {
            return 31000000000000.0 * Math.pow(1.15, count);
        } else if (name.equals("Cortex-Baker")) {
            return 41000000000000.0 * Math.pow(1.15, count);
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
    public long getUpgradeLevel() {
        return upgradeLevel;
    }
}
