public class Cupcake {
    private static long cupcakeCount;

    // I dont even need this class anymore lmao

    public static void addCupcakes(long count) {
        cupcakeCount += count;
    }

    public static long returnCupcakeCount() {
        return cupcakeCount;
    }
}