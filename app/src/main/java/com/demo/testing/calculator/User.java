package com.demo.testing.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private int userId;
    private List<Integer> skuCodes = new ArrayList<>();

    public User(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void addItemCode(int code) {
        skuCodes.add(code);
    }

    public List<Integer> getItemCodes() {
        return Collections.unmodifiableList(skuCodes);
    }
}
