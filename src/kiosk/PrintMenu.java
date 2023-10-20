package kiosk;

import java.util.List;
import java.util.stream.Stream;

public class PrintMenu {
    static int waitingNumber = 1; // 대기번호
    static double doublePrice = 2.3; // 버거 double일 경우 2300원 추가

    public static void printCommon() { // 메뉴 출력시 공통적으로 출력되는 부분
        System.out.println("\"MOM'S TOUCH BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
    }
    public static void printCategoryMenu(String menuName) { // 카테고리 메뉴 선택
        System.out.println("[ " + menuName.toUpperCase() + " MENU ]");
        Order.mainMenuList.stream().filter(mainMenu -> mainMenu.getCategory().equals(menuName))
                .forEach(mainMenu -> System.out.println(String.format("%d. %-10s |\t %s",
                                mainMenu.getNumber(), mainMenu.getName(), mainMenu.getExplanation())));
        System.out.println();
    }

    public static void printSelectedFoodMenu(List<Products> productsList) { // 메인메뉴에서 선택된 음식관련 메뉴 출력
        printCommon();

        System.out.println("[ " + productsList.get(0).getCategory().toUpperCase() + " MENU ]");
        productsList.stream().forEach(menuList ->  System.out.println(menuList.getNumber() + ". " + menuList.getName()
                + " | W " + menuList.getPrice() + " | " + menuList.getExplanation()));
        System.out.println();
    }
    
    public static void printOptionCheck(int menuNumber, List<Products> productsList) { // 옵션에 대한 질문 출력
        Menu menu = new Menu();

        productsList.stream().filter(product -> product.getNumber() == menuNumber)
        .forEach(product -> System.out.println("\"" + String.format("%-10s | W", product.getName())
                        + product.getPrice() + " | " + product.getExplanation() + "\""));

        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        productsList.stream().filter(product -> product.getNumber() == menuNumber)
                .forEach(product -> {System.out.println("1. Single(W " + product.getPrice() +
                    ")\t\t 2. Double(W " + product.getPrice() + doublePrice + ")\n");
                    int selectedOptionNumber = menu.selectOption(product);
                    printCartCheck(menuNumber, selectedOptionNumber, productsList);
        });
    }

    public static void printCartCheck(int menuNumber, int selectedOptionNumber, List<Products> productsList) { // 장바구니에 추가할지 물어보는 질문 출력
        Menu menu = new Menu();
        // 사용자가 입력한 번호와 일치하면
        productsList.stream().filter(product -> product.getNumber() == menuNumber)
        .forEach(product -> {
            double finalPrice = 0; // 장바구니에 들어가는 상품의 최종적인 가격
            if(selectedOptionNumber == 1)
                finalPrice = product.getPrice();
            else if(selectedOptionNumber == 2)
                finalPrice = product.getPrice()+doublePrice;

            System.out.println("\"" + product.getName()
                    + " | W " + finalPrice + " | " + product.getExplanation() + "\"");

            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");

            if(selectedOptionNumber == 2)
                product.setPrice(finalPrice);
            menu.selectAddCart(product.getName(), productsList);
        });
    }

    public void printCartList() { // 장바구니 목록 출력
        Menu menu = new Menu();
        System.out.println("아래와 같이 주문 하시겠습니까?\n");

        System.out.println("[ Orders ]");
        Order.cartList.stream().forEach(list ->  System.out.println(list.getName()
                + " | W " + list.getPrice() + " | " + list.getCount() + " | " + list.getExplanation()));

        System.out.println("\n[ Total ]");
        double total = Order.cartList.stream().mapToDouble(list -> list.getPrice()).sum();
        System.out.println("W " + total + "\n");

        System.out.println("1. 주문 \t 2.메뉴판");
        menu.selectOrderOrMenu();
    }

    public static boolean printCompleteOrder() { // 주문완료 화면
        boolean cartEmpty = false; // 장바구니가 비어있으면 true, 아니면 false

        if(Order.cartList.size() == 0) { // 장바구니에 담긴 게 없을 때
            cartEmpty = true;
            System.out.println("장바구니에 담긴 상품이 없습니다.\n" +
                    "구매 원하는 상품을 골라주세요.\n");
        } else { // 장바구니 내역이 있을 때
            int timeCount = 3;

            System.out.println("주문이 완료되었습니다!\n");
            System.out.println("대기번호는 [ " + waitingNumber + " ] 번 입니다.");
            waitingNumber++; // 다음 대기번호는 +1
            System.out.println("(" + timeCount + "초후 메뉴판으로 돌아갑니다.)\n");
        }

        return cartEmpty;
    }

    public static void printOrderCancel() { // 주문 취소 화면
        Menu menu = new Menu();
        System.out.println("진행하던 주문을 취소하시겠습니까?\n");
        System.out.println("1. 확인 \t 2.취소");
        menu.selectOrderCancel();
    }

    public void printTotalSalesList() { // 총 판매상품 목록 현황 화면
        Double totalSalesAmount = Order.totalSalesList.stream()
                .mapToDouble(totalAmount -> totalAmount.getPrice()).sum(); // 총 판매된 금액 계산

        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ W " + totalSalesAmount + " ] 입니다.\n");

        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        Order.totalSalesList.stream()
                .forEach(totalSale -> System.out.println(String.format("- %-10s | ", totalSale.getName())
                        + "W " + totalSale.getPrice()));
        System.out.println();

        System.out.println("1. 돌아가기");
    }
}

