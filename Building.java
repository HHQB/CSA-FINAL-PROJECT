public class Building {
    String name;
    int count = 0;
    int baseRate; // Amount of cupcakes produced per every ten seconds

    public Building(String name, int baseRate) {
        this.name = name;
        this.baseRate = baseRate;
    }

    int getTotalProduction() {
        return baseRate * count;
    }

    public int getPrice() {
        if (name.equals("Clicker")) {
            return 10 * (int) Math.pow(1.15, count);
        } else if (name.equals("Grandma")) {
            return 100 * (int) Math.pow(1.15, count);
        } else if (name.equals("Farm")) {
            return 1000 * (int) Math.pow(1.15, count);
        } else if (name.equals("Factory")) {
            return 10000 * (int) Math.pow(1.15, count);
        } else if (name.equals("Bank")) {
            return 1000000 * (int) Math.pow(1.15, count);
        } else if (name.equals("Temple")) {
            return 1000000 * (int) Math.pow(1.15, count);
        } else if (name.equals("Wizard-Tower")) {
            return 1000000000 * (int) Math.pow(1.15, count);
        }
        return Integer.MAX_VALUE; // Default case
    }
}
