import java.math.BigDecimal;

public class Supermarket {
    public static void main(String[] args) {
        Fruit apple = new Fruit("Apple", new BigDecimal("8"));
        Fruit strawberry = new Fruit("Strawberry", new BigDecimal("13"));
        Fruit mango = new Fruit("Mango", new BigDecimal("20"));

        ShoppingCart customerA = new ShoppingCart(new OriginalPricingStrategy());
        customerA.addItem(apple, 5);
        customerA.addItem(strawberry, 3);
        System.out.println("顾客 A 需支付：" + customerA.calculateTotalPrice() + " 元");

        ShoppingCart customerB = new ShoppingCart(new OriginalPricingStrategy());
        customerB.addItem(apple, 2);
        customerB.addItem(strawberry, 4);
        customerB.addItem(mango, 1);
        System.out.println("顾客 B 需支付：" + customerB.calculateTotalPrice() + " 元");

        ShoppingCart customerC = new ShoppingCart(new DiscountPricingStrategy(new BigDecimal("0.8")));
        customerC.addItem(apple, 3);
        customerC.addItem(strawberry, 5);
        customerC.addItem(mango, 2);
        System.out.println("顾客 C 需支付：" + customerC.calculateTotalPrice() + " 元");

        ShoppingCart customerD = new ShoppingCart(new FullReductionPricingStrategy(new BigDecimal("100"), new BigDecimal("10")));
        customerD.addItem(apple, 3);
        customerD.addItem(strawberry, 5);
        customerD.addItem(mango, 2);
        System.out.println("顾客 D 需支付：" + customerD.calculateTotalPrice() + " 元");

        ShoppingCart customerE = new ShoppingCart(new CombinedPricingStrategy(new DiscountPricingStrategy(new BigDecimal("0.8")),new FullReductionPricingStrategy(new BigDecimal("100"), new BigDecimal("10"))));
        customerE.addItem(apple, 3);
        customerE.addItem(strawberry, 5);
        customerE.addItem(mango, 2);
        System.out.println("顾客 E 需支付：" + customerE.calculateTotalPrice() + " 元");
    }
}
