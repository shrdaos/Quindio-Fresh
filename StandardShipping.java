public class StandardShipping implements IShipping {
    @Override
    public double calculateCost(Order order) {
        return 7000; // valor de ejemplo
    }
}
