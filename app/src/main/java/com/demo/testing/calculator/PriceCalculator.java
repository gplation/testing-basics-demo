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
            double total = 0;
            boolean isVipUser = false;

            User user = UserService.getUser(userId);

            if (user != null) {
                for (Integer vipId : store.getVips()) {
                    if (vipId == user.getUserId()) {
                        isVipUser = true;
                        break;
                    }
                }
                List<Integer> itemIds = user.getItemCodes();

                double basePrice = 0;
                for (int skuCode : itemIds) {
                    Item sku = store.getItemDetails(skuCode);

                    basePrice = sku.getPrice();
                    total += basePrice - (basePrice * sku.getApplicableDiscount()) / 100;
                }

                if (isVipUser)
                    total -= (total * store.getVipDiscountPercentage()) / 100;

                return total;
            } else {
                throw new UserNotFoundException();
            }
        } finally {
            timerContext.stop();
        }
    }

}