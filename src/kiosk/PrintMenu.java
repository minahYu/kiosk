package kiosk;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PrintMenu {
    static int waitingNumber = 1; // 대기번호
    public static void printCommon() { // 메뉴 출력시 공통적으로 출력되는 부분
        System.out.println("\"MOM'S TOUCH BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
    }
    public static void printCategoryMenu(String menuName) { // 카테고리 메뉴 선택
        System.out.println("[ " + menuName.toUpperCase() + " MENU ]");
        Order.mainMenuList.stream().filter(mainMenu -> mainMenu.getCategory().equals(menuName))
                .forEach(mainMenu -> System.out.println(mainMenu.getNumber() + ". "
                        + mainMenu.getName() + " | " + mainMenu.getExplanation()));
        System.out.println();
    }

    public static void printSelectedFoodMenu(List<Products> productsList) { // 메인메뉴에서 선택된 음식관련 메뉴 출력
        printCommon();

        System.out.println("[ " + productsList.get(0).getCategory().toUpperCase() + " MENU ]");
        productsList.stream().forEach(menuList ->  System.out.println(menuList.getNumber() + ". " + menuList.getName()
                + " | W " + menuList.getPrice() + " | " + menuList.getExplanation()));
        System.out.println();
    }

    public static void printCartCheck(int menuNumber, List<Products> productsList) { // 장바구니에 추가할지 물어보는 질문 출력
        Menu menu = new Menu();
        Stream<Products> inputProduct = productsList.stream() // 사용자가 입력한 번호와 일치하면
                .filter(product -> product.getNumber() == menuNumber);
        inputProduct.forEach(product -> {
            System.out.println("\"" + product.getName() // 해당 부분 출력
                    + " | W " + product.getPrice() + " | " + product.getExplanation());

            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");

            menu.selectAddCart(product.getName(), productsList);
        });
    }

    public void printCartList() { // 장바구니 목록 출력
        Menu menu = new Menu();
        System.out.println("아래와 같이 주문 하시겠습니까?\n");

        System.out.println("[ Orders ]");
        Order.cartList.stream().forEach(list ->  System.out.println(list.getName()
                + " | W " + list.getPrice() + " | " + list.getExplanation()));

        System.out.println("\n[ Total ]");
        double total = Order.cartList.stream().mapToDouble(list -> list.getPrice()).sum();
        System.out.println("W " + total + "\n");

        System.out.println("1. 주문 \t 2.메뉴판");
        menu.selectOrderOrMenu();
    }

    public static void printCompleteOrder() { // 주문완료 화면
        int timeCount = 3;

        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + waitingNumber + " ] 번 입니다.");
        waitingNumber++; // 다음 대기번호는 +1
        System.out.println("(" + timeCount + "초후 메뉴판으로 돌아갑니다.)\n");
    }

    public static void printOrderCancel() { // 주문 취소 화면
        Menu menu = new Menu();
        System.out.println("진행하던 주문을 취소하시겠습니까?\n");
        System.out.println("1. 확인 \t 2.취소");
        menu.selectOrderCancel();
    }
}

