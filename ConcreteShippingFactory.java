public class ConcreteShippingFactory extends ShippingFactory {
    
    public IShipping createShipping(ShippingType type) {
        switch(type) {
            case STANDARD: return new StandardShipping();
            case EXPRESS: return new ExpressShipping();
            default:
                throw new IllegalArgumentException("Shipping no soportado: " + type);
        }
    }
}

