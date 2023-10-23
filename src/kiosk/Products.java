package kiosk;

public class Products extends Menu{
    private double price;
    private int count;
    private String option;

    // 생성자
    public Products() {};
    public Products(int number, String category, double price, String name, String explanation) {
        super.number = number;
        super.category = category;
        this.price = price;
        this.count = 0;
        this.option = "S"; // default : single
        super.name = name;
        super.explanation = explanation;
    }

    public Products(int number, String category, double price, String option, String name, String explanation) {
        super.number = number;
        super.category = category;
        this.price = price;
        this.count = 0;
        this.option = option; // default : single
        super.name = name;
        super.explanation = explanation;
    }

    // getter
    public double getPrice() { return price; }
    public int getCount() { return count; }
    public String getOption() { return option; }

    // setter
    public void setPrice(double price) { this.price = price; }
    public void setCount(int count) { this.count = count; }
    public void setOption(String option) { this.option = option; }
}

