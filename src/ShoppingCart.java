import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Fruit, Integer> items;
    private PricingStrategy pricingStrategy;

    public ShoppingCart(PricingStrategy pricingStrategy) {
        items = new HashMap<>();
        this.pricingStrategy = pricingStrategy;
    }

    public void addItem(Fruit fruit, int weight) {
        items.put(fruit, weight);
    }

    public BigDecimal calculateTotalPrice() {
        return pricingStrategy.calculateTotal(items);
    }
}
