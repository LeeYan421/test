import java.math.BigDecimal;
import java.util.Map;

/**
 * 定义满减策略
 */
public class FullReductionPricingStrategy implements PricingStrategy {
    /**
     * 满减金额
     */
    private final BigDecimal fullAmount;
    /**
     * 减金额
     */
    private final BigDecimal reductionAmount;

    public FullReductionPricingStrategy(BigDecimal fullAmount, BigDecimal reductionAmount) {
        this.fullAmount = fullAmount;
        this.reductionAmount = reductionAmount;
    }

    /**
     * 计算总价
     *
     * @param items
     * @return
     */
    @Override
    public BigDecimal calculateTotal(Map<Fruit, Integer> items) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Map.Entry<Fruit, Integer> entry : items.entrySet()) {
            BigDecimal itemPrice = entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue()));
            totalPrice = totalPrice.add(itemPrice);
        }
        if (totalPrice.compareTo(fullAmount) >= 0) {
            totalPrice = totalPrice.subtract(reductionAmount);
        }
        return totalPrice;
    }

    /**
     * 计算总价
     *
     * @param totalPrice
     * @return
     */
    @Override
    public BigDecimal calculateTotal(BigDecimal totalPrice) {
        if (totalPrice.compareTo(fullAmount) >= 0) {
            totalPrice = totalPrice.subtract(reductionAmount);
        }
        return totalPrice;
    }
}
