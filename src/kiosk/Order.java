package kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    static List<Products> cartList = new ArrayList<>(); // 장바구니 목록

    static List<Menu> mainMenuList = Arrays.asList( // 메인 메뉴
            new Menu(1, "Shakeshack", "Burgers", "앵거스 비프 통살을 다져만든 버거"),
            new Menu(2,"Shakeshack", "Forzen Custard", "매장에서 신선하게 만드는 아이스크림"),
            new Menu(3, "Shakeshack", "Drinks", "매장에서 직접 만드는 음료"),
            new Menu(4, "Shakeshack", "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"),
            new Menu(5, "Order", "Order", "장바구니를 확인 후 주문합니다."),
            new Menu(6, "Order", "Cancel", "진행중인 주문을 취소합니다.")
    );

    static List<Products> burgerList = Arrays.asList( // 버거
            new Products(1, "Burger", 6.9, "ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
            new Products(2, "Burger", 8.9, "SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
            new Products(3, "Burger", 9.4, "Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"),
            new Products(4, "Burger", 6.9, "Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
            new Products(5, "Burger", 5.4, "Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거")
    );

    static List<Products> drinkList = Arrays.asList( // 음료
            new Products(1, "Drink", 6.9, "Coke", "콜라"),
            new Products(2, "Drink", 8.9, "Cider", "사이다"),
            new Products(3, "Drink", 9.4, "Green Grape Ade", "청포도 에이드"),
            new Products(4, "Drink", 6.9, "Lemon Ade", "레몬 에이드"),
            new Products(5, "Drink", 5.4, "Orange Juice", "오렌지 주스")
    );
}
