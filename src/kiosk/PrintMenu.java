package kiosk;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PrintMenu {
    static int waitingNumber = 1; // 대기번호
    public static void printCommon() { // 메뉴 출력시 공통적으로 출력되는 부분
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
    }
    public static void printMainMenu() { // 메인메뉴 선택
        String[] menuName = new String[]{"Shakeshack", "Order"};
        printCommon();

        // shakeshack , order 메뉴가 category 부분 제외하고는 모두 중복되고 있어 이 부분 수정하고 싶음.
        // Shakeshack menu
        System.out.println("[ SHAKESHACK MENU ]");
        Order.mainMenuList.stream().filter(mainMenu -> mainMenu.getCategory().equals(menuName[0]))
                .forEach(mainMenu -> System.out.println(mainMenu.getNumber() + ". "
                        + mainMenu.getName() + " | " + mainMenu.getExplanation()));
        System.out.println();


        // Order menu
        System.out.println("[ ORDER MENU ]");
        Order.mainMenuList.stream().filter(mainMenu -> mainMenu.getCategory().equals(menuName[1]))
                .forEach(mainMenu -> System.out.println(mainMenu.getNumber() + ". "
                        + mainMenu.getName() + " | " + mainMenu.getExplanation()));
        System.out.println();
    }

    public static void printSelectedBurgers() { // 버거 선택
        printCommon();

        System.out.println("[ Burgers MENU ]"); // 카테고리에서 가져오기
        Order.burgerList.stream().forEach(burger ->
                System.out.println(burger.getNumber() + ". " + burger.getName()
                        + " | W " + burger.getPrice() + " | " + burger.getExplanation()));
    }
    
    public static void printSelectedDrinks() { // 음료 선택
        System.out.println("[ Drinks MENU ]");

        Order.drinkList.stream().forEach(drink ->
                System.out.println(drink.getNumber() + ". " + drink.getName()
                        + " | W " + drink.getPrice() + " | " + drink.getExplanation()));
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

            menu.selectAddCart(product.getName());
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

    public static void completeOrder() { // 주문완료 화면
        int timeCount = 3;

        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + waitingNumber + " ] 번 입니다.");
        waitingNumber++; // 다음 대기번호는 +1
        System.out.println("(" + timeCount + "초후 메뉴판으로 돌아갑니다.)");
    }

    public static void printOrderCancel() { // 주문 취소 화면
        Menu menu = new Menu();
        System.out.println("진행하던 주문을 취소하시겠습니까?\n");
        System.out.println("1. 확인 \t 2.취소");
        menu.selectOrderCancel();
    }
}

