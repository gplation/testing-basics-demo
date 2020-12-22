package com.demo.testing.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;

public class PriceCalculatorTest {

    static final User UNREGISTERED_USER = null;
    static final Store UNUSED_STORE = null;
    static final int UNREGISTERED_USER_ID = -1;

    Item TV = new Item(101, 100d, 1, 10d);
    Item OVEN = new Item(102, 200d, 1, 15d);

    Store store;
    User user;

    // SUT
    PriceCalculator priceCalculator;

    MockMetricFactory metricFactory;
    MockTimer timer;
    MockTimerContext timerContext;
    User queriedUser;

    @Before
    public void init() {
        metricFactory = new MockMetricFactory();
        timer = new MockTimer();
        timerContext = new MockTimerContext();

        priceCalculator = new MyPriceCalculator(metricFactory);
    }

    @After
    public void wrapUp() {
        assertThat(timerContext.isStopCalled, is(true));
    }

    @Test(expected = UserNotFoundException.class)
    public void should_throw_exception_if_user_is_not_registered() {
        // Arrange (Given)

        queriedUser = UNREGISTERED_USER;

        // Act (When)
        priceCalculator.calculateTotalPrice(UNREGISTERED_USER_ID, UNUSED_STORE);

        // Assert (Then)
    }

    @Test
    public void should_return_total_with_only_regular_discounts_applied() {
        // Arrange (Given)
        createStore();
        user = createUser();

        queriedUser = user;

        // Act (When)
        double totalPrice = priceCalculator.calculateTotalPrice(user.getUserId(), store);

        // Assert (Then)
        assertThat(totalPrice, is(closeTo(260d, 0.1)));
    }

    @Test
    public void should_return_total_with_both_regular_and_vip_discounts_applied() {
        user = createUser();
        createStore();
        store.addVip(user);
        store.setVipDiscountPercentage(10d);

        queriedUser = user;

        // Act (When)
        double totalPrice = priceCalculator.calculateTotalPrice(user.getUserId(), store);

        // Assert (Then)
        assertThat(totalPrice, is(closeTo(234d, 0.1)));
    }

    private User createUser() {
        User user = new User(1);
        user.addItemCode(TV.getSkuCode());
        user.addItemCode(OVEN.getSkuCode());
        return user;
    }

    private void createStore() {
        store = new Store();
        store.addItem(TV);
        store.addItem(OVEN);
    }

    private class MockMetricFactory extends MetricFactory {
        @Override
        public Timer createTimer(String moduleName, String methodName) {
            return timer;
        }
    }

    private class MockTimer extends Timer {
        @Override
        public TimerContext time() {
            return timerContext;
        }
    }

    private class MockTimerContext extends TimerContext {
        boolean isStopCalled = false;

        @Override
        public void stop() {
            isStopCalled = true;
        }
    }

    private class MyPriceCalculator extends PriceCalculator {
        public MyPriceCalculator(MetricFactory factory) {
            super(factory);
        }

        @Override
        protected User getUser(int userId) {
            return queriedUser;
        }
    }

}