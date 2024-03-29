import java.math.BigDecimal;
import java.util.Map;

public interface PricingStrategy {
    BigDecimal calculateTotal(Map<Fruit, Integer> items);

    BigDecimal calculateTotal(BigDecimal totalPrice);
}
