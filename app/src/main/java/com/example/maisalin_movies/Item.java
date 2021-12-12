package com.example.maisalin_movies;

public class Item {
    private String description;
    private int resId; // image id to be loaded
    private boolean isHappy;
    private int amount;

    //constructor
    public Item(String description, int resId, boolean isHappy, int amount) {
        this.description = description;
        this.resId = resId;
        this.isHappy = isHappy;
        this.amount = amount;
    }

    //getters
    public String getDescription() {
        return description;
    }

    public int getResId() {
        return resId;
    }

    public boolean isHappy() {
        return isHappy;
    }

    public int getAmount() {
        return amount;
    }

    //setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", resId=" + resId +
                ", isHappy=" + isHappy +
                ", amount=" + amount +
                '}';
    }
}
