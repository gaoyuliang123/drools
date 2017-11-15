package com.tgl.template;

public class Item {
    private String name;
    private int price;
    private int weight;
    private ItemCode itemCode;

    public Item() {
    }

    public Item(String name, int price, int weight, ItemCode itemCode) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemCode getItemCode() {
        return itemCode;
    }

    public void setItemCode(ItemCode itemCode) {
        this.itemCode = itemCode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
