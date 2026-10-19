package com.lingrui.question.T3;

public class ItemStack {
    private int quantity;
    private Item item;

    public ItemStack(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public ItemStack() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
