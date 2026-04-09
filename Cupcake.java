public class Cupcake {
    private static int cupcakeCount;

    public static void addCupcakes(int count) {
        cupcakeCount += count;
    }

    public static int returnCupcakeCount() {
        return cupcakeCount;
    }
}