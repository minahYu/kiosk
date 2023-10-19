import java.util.Arrays;
import java.util.List;

public class Products extends Menu{
    private double price;

    static List<Products> burgerList = Arrays.asList(
            new Products(1, 6.9, "ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
            new Products(2, 8.9, "SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
            new Products(3, 9.4, "Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"),
            new Products(4, 6.9, "Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
            new Products(5, 5.4, "Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거")
    );

    // 생성자
    public Products(int number, double price, String name, String explanation) {
        super.number = number;
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
