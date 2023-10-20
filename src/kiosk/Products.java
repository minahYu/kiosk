package kiosk;

public class Products extends Menu{
    private double price;
    private int count;

    // 생성자
    public Products() {};

    // 메뉴 관련
    /*public Products(int number, String category, double price, double doublePrice, String name, String explanation) {
        super.number = number;
        super.category = category;
        this.price = price;
        this.doublePrice = doublePrice;
        super.name = name;
        super.explanation = explanation;
    }*/

    // 주문 관련
    public Products(int number, String category, double price, String name, String explanation) {
        super.number = number;
        super.category = category;
        this.price = price;
        this.count = 0;
        super.name = name;
        super.explanation = explanation;
    }

    // getter
    public double getPrice() {
        return price;
    }
    /*public double getDoublePrice() {
        return doublePrice;
    }*/
    public int getCount() {
        return count;
    }

    // setter
    public void setPrice(double price) {
        this.price = price;
    }
    /*public void setDoublePrice(double doublePrice) {
        this.doublePrice = doublePrice;
    }*/
    public void setCount(int count) { this.count = count; }
}

