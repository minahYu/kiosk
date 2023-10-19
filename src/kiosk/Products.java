package kiosk;

import java.util.Arrays;
import java.util.List;

public class Products extends Menu{
    private double price;

    // 생성자
    public Products(int number, String category, double price, String name, String explanation) {
        super.number = number;
        super.category = category;
        this.price = price;
        super.name = name;
        super.explanation = explanation;
    }

    // getter, setter
    public double getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = price;
    }
}

