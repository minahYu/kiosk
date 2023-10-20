package kiosk;

public class Products extends Menu{
    private double price;
    private int count = 0;

    // 생성자
    public Products() {};

    public Products(int number, String category, double price, String name, String explanation) {
        super.number = number;
        super.category = category;
        this.price = price;
        super.name = name;
        super.explanation = explanation;
    }

    public Products(int number, String category, double price, int count, String name, String explanation) {
        super.number = number;
        super.category = category;
        this.price = price;
        this.count = count;
        super.name = name;
        super.explanation = explanation;
    }

    // getter
    public double getPrice() {
        return price;
    }

    // setter
    public void setPrice() {
        this.price = price;
    }
}

