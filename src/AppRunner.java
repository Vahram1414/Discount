import com.sun.source.tree.BreakTree;

import java.util.List;
import java.util.Scanner;

public class AppRunner {

    public static int amount;
    public double calculateDiscount;
    public double discount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        double discount = calculateDiscount(amount);
        System.out.println("Ваша скидка: " + discount);
        while(amount > 1000) {
            System.out.println("Ваша скидка" + calculateDiscount(amount * discount));
        }
        System.out.println("Скидка " + calculateDiscount(amount));
    }


    public static double calculateDiscount(double amount) {

        List<DiscountRule> discountRules = List.of(
                new DiscountRule(0.0, 999.0, 0.0),
                new DiscountRule(1000.0, 4999.0, 0.05),
                new DiscountRule(5000.0, Double.MAX_VALUE, 0.1)
        );
        for (int i = 0; i < 3; i++) {
            if (discountRules.get(i).isApplicable) {
                DiscountRule.calculateDiscount(amount);
            }
        }
        return amount;
    }

    static class DiscountRule {
        public static boolean isApplicable;
        private Double minAmount;
        private Double maxAmount;

        public static Double discount;

        public DiscountRule(Double minAmount, Double maxAmount, Double discount) {
            this.minAmount = minAmount;
            this.maxAmount = maxAmount;
            this.discount = discount;
        }

        public boolean isApplicable(double amount) {

            return amount >= minAmount && amount <= maxAmount;
        }

        public static double calculateDiscount(double amount) {

            return amount * discount;
        }
    }
}


