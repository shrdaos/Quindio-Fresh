public class ExpressShipping implements IShipping {
    @Override
    public double calculateCost(Order order) {
        return 15000; // valor de ejemplo
    }
}

