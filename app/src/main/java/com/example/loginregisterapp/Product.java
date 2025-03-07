package com.example.loginregisterapp;

public class Product {
    private String salePercentage; // e.g., "-20%"
    private int imageResId; // Resource ID for the product image
    private float rating; // e.g., 5.0
    private int reviewCount; // e.g., 10
    private String name; // e.g., "Dorothy Perkins Evening Dress"
    private String price; // e.g., "£25 £125"

    // Constructor
    public Product(String salePercentage, int imageResId, float rating, int reviewCount, String name, String price) {
        this.salePercentage = salePercentage;
        this.imageResId = imageResId;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getSalePercentage() {
        return salePercentage;
    }

    public int getImageResId() {
        return imageResId;
    }

    public float getRating() {
        return rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
