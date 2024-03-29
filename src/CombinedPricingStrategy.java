import java.math.BigDecimal;
import java.util.Map;

/**
 * 定义组合策略，先算折扣，后计算满减得出最终的价格
 */
public class CombinedPricingStrategy implements PricingStrategy{
    private final PricingStrategy discountPricingStrategy;
    private final PricingStrategy fullReductionPricingStrategy;
    public CombinedPricingStrategy(PricingStrategy discountPricingStrategy, PricingStrategy fullReductionPricingStrategy)
    {
        this.discountPricingStrategy = discountPricingStrategy;
        this.fullReductionPricingStrategy = fullReductionPricingStrategy;
    }
    public BigDecimal calculateTotal(Map<Fruit, Integer> items)
    {
        BigDecimal totalPrice = discountPricingStrategy.calculateTotal(items);
        return fullReductionPricingStrategy.calculateTotal(totalPrice);
    }

    @Override
    public BigDecimal calculateTotal(BigDecimal totalPrice) {
        return totalPrice;
    }
}
