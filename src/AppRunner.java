import java.util.List;
import java.lang.ClassNotFoundException;
import java.util.Scanner;

public class AppRunner {

    public static int amount;
    public static int price;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        {
            System.out.println("введите сумму заказа");
            int amount = sc.nextInt();
//            char operation = sc.next().charAt(0);
            if (amount > 1000.0 && amount <= 4999.0) {
                price = (int) (amount * 0.05);
                System.out.println(amount * 0.05);
            } else if (amount > 5000.0) {
                price = (int) (amount * 0.1);
                System.out.println(amount * 0.1);
            }
        }
    }

    public double calculateDiscount(double amount) {

        List<DiscountRule> discountRules = List.of(
                new DiscountRule(0.0, 999.0, 0.05),
                new DiscountRule(1000.0, Double.MAX_VALUE, 0.1)
        );
        return 0.0;
    }

    static class DiscountRule {
        private Double minAmount;
        private Double maxAmount;

        public Double discount;

        public DiscountRule(Double minAmount, Double maxAmount, Double discount) {
            this.minAmount = minAmount;
            this.maxAmount = maxAmount;
            this.discount = discount;
        }

        public boolean isApplicable(double amount) {
            return amount >= minAmount && amount <= maxAmount;
        }

        public double calculateDiscount(double amount) {
            return amount * discount;
        }
    }
}