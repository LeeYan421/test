import java.math.BigDecimal;
import java.util.Map;

/**
 * 定义折扣策略
 */
public class DiscountPricingStrategy implements PricingStrategy {
    /**
     * 折扣率
     */
    private final BigDecimal discountRate;

    public DiscountPricingStrategy(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public BigDecimal calculateTotal(Map<Fruit, Integer> items) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Map.Entry<Fruit, Integer> entry : items.entrySet()) {
            BigDecimal itemPrice = entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue()));
            if (entry.getKey().getName().equals("Strawberry")) {
                itemPrice = itemPrice.multiply(discountRate);
            }
            totalPrice = totalPrice.add(itemPrice);
        }
        return totalPrice;
    }

    @Override
    public BigDecimal calculateTotal(BigDecimal totalPrice) {
        return totalPrice;
    }
}
