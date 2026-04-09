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
}
