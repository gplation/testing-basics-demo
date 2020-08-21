package com.demo.testing.calculator;

public class Item {
    private int skuCode;
    private double price;
    private int totalQuantity;
    private double applicableDiscount;

    public Item(int skuCode, double price, int totalQuantity, double applicableDiscount) {
        this.skuCode = skuCode;
        this.price = price;
        this.totalQuantity = totalQuantity;
        this.applicableDiscount = applicableDiscount;
    }

    // for testing
    public Item(final Item otherItem) {
        this.skuCode = otherItem.getSkuCode();
        this.price = otherItem.getPrice();
        this.totalQuantity = otherItem.getTotalQuantity();
        this.applicableDiscount = otherItem.getApplicableDiscount();
    }

    public double getApplicableDiscount() {
        return applicableDiscount;
    }

    public void setApplicableDiscount(double applicableDiscount) {
        this.applicableDiscount = applicableDiscount;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(int skuCode) {
        this.skuCode = skuCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
