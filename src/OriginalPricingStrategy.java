import java.math.BigDecimal;
import java.util.Map;

/**
 * 定义原始价格策略
 */
public class OriginalPricingStrategy implements PricingStrategy {

    /**
     * 计算总价
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
        return totalPrice;
    }

    @Override
    public BigDecimal calculateTotal(BigDecimal totalPrice) {
        return totalPrice;
    }
}
