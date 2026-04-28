public class Building {
    String name;
    int count = 0;
    int baseRate; // Amount of cupcakes produced per every ten seconds

    /**
     * Creates a new building type with a name and a base cupcake production rate.
     *
     * @param name     the name of the building
     * @param baseRate the base production rate for the building
     */
    public Building(String name, int baseRate) {
        this.name = name;
        this.baseRate = baseRate;
    }

    /**
     * Returns the total cupcake production for this building based on how many are
     * owned.
     *
     * @return total production from this building type
     */
    int getTotalProduction() {
        return baseRate * count;
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
}
