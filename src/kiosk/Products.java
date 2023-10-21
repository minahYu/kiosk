package kiosk;

public class Products extends Menu{
    private double price;
    private int count;

    // 생성자
    public Products(int number, String category, double price, String name, String explanation) {
        super.number = number;
        super.category = category;
        this.price = price;
        this.count = 0;
        super.name = name;
        super.explanation = explanation;
    }

    // getter
    public double getPrice() { return price; }
    public int getCount() { return count; }

    // setter
    public void setPrice(double price) { this.price = price; }
    public void setCount(int count) { this.count = count; }
}

