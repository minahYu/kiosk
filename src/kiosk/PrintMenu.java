package kiosk;

import java.util.List;

public class PrintMenu {
    static int waitingNumber = 1; // 대기번호
    static double surcharge = 0; // 버거 double일 경우 2300원 추가
    static int gap = 10; // 음식선택 메뉴판 공백

    // 카테고리메뉴 출력시 공통적으로 보여지는 부분을 출력하는 메서드
    public static void printCommon() {
        System.out.println("\"MOM'S TOUCH BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
    }

    // 음식관련 메뉴 출력하는 메서드
    public static void printSelectedFoodMenu(List<Products> productsList) {
        printCommon();
        System.out.println("[ " + productsList.get(0).getCategory().toUpperCase() + " MENU ]");
        productsList.forEach(menuList ->
                System.out.println(String.format("%d. %-" + gap + "s | W ", menuList.getNumber(), menuList.getName())
                        + menuList.getPrice() + " | " + menuList.getExplanation()));
        System.out.println();
    }

    // 카테고리 메뉴 출력하는 메서드
    public static void printCategoryMenu(String menuName) {
        System.out.println("[ " + menuName.toUpperCase() + " MENU ]");
        Order.mainMenuList.stream().filter(mainMenu -> mainMenu.getCategory().equals(menuName))
                .forEach(mainMenu -> System.out.printf("%d. %-8s |\t %s",
                        mainMenu.getNumber(), mainMenu.getName(), mainMenu.getExplanation()));
        System.out.println();
    }

    // 옵션에 대한 질문을 출력하는 메서드
    public static void printOptionCheck(int menuNumber, List<Products> productsList) {
        Menu menu = new Menu();

        Products selectedProduct = productsList.stream().filter(product ->
                product.getNumber() == menuNumber).toList().get(0);
        System.out.println("\"" + String.format("%-10s | W", selectedProduct.getName())
                + selectedProduct.getPrice() + " | " + selectedProduct.getExplanation() + "\"");

        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        productsList.stream().filter(product -> product.getNumber() == menuNumber)
                .forEach(product -> {
                    double doublePrice = Math.floor((product.getPrice() + surcharge) * 10) / 10.0;
                    System.out.println("1. Single(W " + product.getPrice() + ")\t\t 2. Double(W " + doublePrice + ")\n");

                    int selectedOptionNumber = menu.getInput();
                    printCartCheck(selectedOptionNumber, selectedProduct);
                });
    }

    // 장바구니에 추가할지 물어보는 질문 출력하는 메서드
    public static void printCartCheck(int selectedNumber, Products product) {
        Menu menu = new Menu();

        double finalPrice = 0; // 장바구니에 들어가는 상품의 최종적인 가격
        menu.twoOptionsRange(selectedNumber);

        switch (selectedNumber) {
            case 1:
                finalPrice = product.getPrice();
                break;
            case 2:
                finalPrice = Math.floor((product.getPrice() + surcharge) * 10) / 10.0;
                break;
        }

        System.out.println("\"" + String.format("%-21s", product.getName())
                + " | W " + finalPrice + " | " + product.getExplanation() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        menu.selectAddCart(product.getName(), selectedNumber, finalPrice, product);
    }

    // 장바구니 목록 출력하는 메서드
    public void printCartList() {
        Menu menu = new Menu();
        System.out.println("아래와 같이 주문 하시겠습니까?\n");

        System.out.println("[ Orders ]");
        Order.cartList.forEach(list -> System.out.println(String.format("%-21s", list.getName())
                + " | " + list.getOption() + " | W " + list.getPrice() + " | "
                + list.getCount() + "개 | " + list.getExplanation()));

        System.out.println("\n[ Total ]");
        double total = (Order.cartList.stream().mapToDouble(list -> list.getPrice() * list.getCount()).sum());
        System.out.println("W " + Math.floor(total * 10) / 10 + "\n");

        System.out.println("1. 주문 \t 2.메뉴판");
        menu.selectOrderOrMenu();
    }

    // 주문 완료시 출력되는 메서드
    public static boolean printCompleteOrder() {
        boolean cartEmpty = false; // 장바구니가 비어있으면 true, 아니면 false

        if (Order.cartList.size() == 0) { // 장바구니에 담긴 게 없을 때
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

    // 주문 취소관련 문구를 출력하는 메서드
    public static void printOrderCancel() {
        Menu menu = new Menu();
        System.out.println("진행하던 주문을 취소하시겠습니까?\n");
        System.out.println("1. 확인 \t 2.취소");
        menu.selectOrderCancel();
    }

    // 총 판매상품 목록 현황 화면을 출력하는 메서드
    public void printTotalSalesList() {
        Menu menu = new Menu();
        double totalSalesAmount = Order.totalSalesList.stream()
                .mapToDouble(totalAmount -> totalAmount.getPrice()).sum(); // 총 판매된 금액 계산

        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ W " + Math.floor(totalSalesAmount * 10) / 10 + " ] 입니다.\n");

        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        Order.totalSalesList.forEach(totalSale ->
                System.out.println(String.format("- %-10s | ", totalSale.getName()) + "W " + totalSale.getPrice()));
        System.out.println();

        System.out.println("1. 돌아가기");
        menu.back();
    }
}