package kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {
    
    static List<Products> cartList = new ArrayList<>(); // 장바구니 목록
    static List<Products> totalSalesList = new ArrayList<>(); // 총 판매 목록

    static List<Menu> mainMenuList = Arrays.asList( // 메인 메뉴
            new Menu(1, "Mom's Touch", "Burgers", "넓적다리살, 닭가슴살로 만든 치킨 버거"),
            new Menu(2,"Mom's Touch", "Chickens", "치킨"),
            new Menu(3, "Mom's Touch", "Drinks", "시원한 음료"),
            new Menu(4, "Mom's Touch", "Side", "사이드 메뉴"),
            new Menu(5, "Order", "Order", "장바구니를 확인 후 주문합니다."),
            new Menu(6, "Order", "Cancel", "진행중인 주문을 취소합니다.")
    );

    static List<Products> burgerList = Arrays.asList( // 버거
            new Products(1, "Burger", 4.6, "Thigh Burger", "바삭하고 매콤한 치킨 패티와 신선한 양상추가 조화를 이루는 맘스터치 시그니처 버거"),
            new Products(2, "Burger", 4.8, "Spicy Thigh Burger", "화끈한 불맛이 살아있는 버거, 싸이버거의 매운맛 버전"),
            new Products(3, "Burger", 5.7, "Shrimp Bulgogi Burger", "새우살이 씹히는 통새우살 패티와 불맛 가득 불고기패티의 환상적인 버거"),
            new Products(4, "Burger", 7.7, "Thigh Flex Burger", "통다리살 싸이패티가 2장! 압도적 사이즈의 FLEX, 리얼 입찢버거 싸이플렉스버거"),
            new Products(5, "Burger", 4.4, "Fillet Burger", "바삭한 치킨 패티와 상큼한 양상추가 어우러진 버거")
    );

    static List<Products> drinkList = Arrays.asList( // 음료
            new Products(1, "Drink", 1.6, "Coke", "가슴까지 시원한 콜라 한 잔!"),
            new Products(2, "Drink", 1.6, "Cider", "톡 쏘는 사이다 한잔"),
            new Products(3, "Drink", 2.2, "Green Grape Ade", "청포도알맹이가 쏙쏙~ 상큼한 청포도에이드"),
            new Products(4, "Drink", 2.2, "Lemon Ade", "착즙 방식으로 레몬셀이 살아있어 풍부한 레몬의 맛과 청량감을 느낄 수 있는 레몬 에이드"),
            new Products(5, "Drink", 2.0, "Orange Juice", "오렌지과즙이 풍부한 상큼한 오렌지 주스")
    );

    static List<Products> chickenList = Arrays.asList( // 치킨 메뉴
            new Products(1, "Chicken", 16.9, "Fried Chicken", "싸이버거 스타일 케이준 양념레시피로 더 바삭하고 스파이시한 핫크리스피 치킨"),
            new Products(2, "Chicken", 18.9, "Sweet & Spicy Korean Fried Chicken", "국내산 벌꿀이 함유된 매콤달콤 특제 양념소스로 꿀맛나는 엄마표 맘스양념치킨"),
            new Products(3, "Chicken", 18.9, "Soy Garlic Chicken", "알싸한 마늘 향의 매콤함, 특제 간장소스의 단짠이 조화로운 치킨"),
            new Products(4, "Chicken", 19.5, "Garlic Mustard Chicken", "마늘향과 겨자의 환상조화! 국내산 마늘을 듬뿍 넣어 진한 마늘향과 톡쏘는 겨자 소스가 만나 알싸하고 새콤달콤한 맛의 치킨")
    );
    static List<Products> sideList = Arrays.asList( // 사이드 메뉴
            new Products(1, "Side", 2.0, "Cajun French Fries", "케이준스타일의 바삭한 양념감자 맘스터치의 베스트 사이드 메뉴!"),
            new Products(2, "Side", 3.5, "Spicy Kimddukman", "바삭한 김말이 쫄깃한 떡 강정과 팝콘만두를 매콤한 소스에 맛있게 버무린 매콤김떡만"),
            new Products(3, "Side", 3.5, "Garlic Kimddukman", "바삭한 김말이 쫄깃한 떡 강정과 팝콘만두를 갈릭 소스에 버무려 맵지 않게 즐기는 갈릭김떡만"),
            new Products(4, "Side", 2.0, "Jalapeno Nugget", "콕콕 박힌 할라피뇨로 매콤하게 즐기는 할라피뇨 너겟"),
            new Products(5, "Side", 2.6, "Popcorn Balls", "한입에 쏘옥~들어가는 팝콘 모양의 치킨볼! 시원한 음료와 함께 즐기는 대표 간식")
    );
}
