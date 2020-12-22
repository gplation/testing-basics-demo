package com.demo.testing.calculator;

import java.util.List;

public class PriceCalculator {

    private Timer timer;

    public PriceCalculator(MetricFactory factory) {
        timer = factory.createTimer("PriceCalculator", "calculateTotalPrice");
    }

    public double calculateTotalPrice(int userId, Store store) {
        TimerContext timerContext = timer.time();
        try {
            return calcTotal(userId, store);
        } finally {
            timerContext.stop();
        }
    }

    private double calcTotal(int userId, Store store) {

        User user = getUser(userId);

        if (user != null) {
            List<Integer> itemIds = user.getItemCodes();

            double total = 0;
            double basePrice = 0;
            for (int skuCode : itemIds) {
                Item sku = store.getItemDetails(skuCode);

                basePrice = sku.getPrice();
                total += basePrice - (basePrice * sku.getApplicableDiscount()) / 100;
            }

            if (store.hasAsVip(user))
                total -= (total * store.getVipDiscountPercentage()) / 100;

            return total;
        } else {
            throw new UserNotFoundException();
        }
    }

    protected User getUser(int userId) {
        return UserService.getUser(userId);
    }

}