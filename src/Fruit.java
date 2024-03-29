import java.math.BigDecimal;

// 定义水果类
public class Fruit {
    private String name;
    private BigDecimal price;

    public Fruit(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
