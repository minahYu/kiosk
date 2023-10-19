import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PrintMenu {
    static List<Menu> mainMenuList = Arrays.asList(
            new Menu(1, "Shakeshack", "Burgers", "앵거스 비프 통살을 다져만든 버거"),
            new Menu(2,"Shakeshack", "Forzen Custard", "매장에서 신선하게 만드는 아이스크림"),
            new Menu(3, "Shakeshack", "Drinks", "매장에서 직접 만드는 음료"),
            new Menu(4, "Shakeshack", "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"),
            new Menu(5, "Order", "Order", "장바구니를 확인 후 주문합니다."),
            new Menu(6, "Order", "Cancel", "진행중인 주문을 취소합니다.")
    );

    public static void printCommon() { // 메뉴 출력시 공통적으로 출력되는 부분
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
    }
    public static void printMainMenu() { // 메인메뉴 선택
        printCommon();

        // shakeshack , order 메뉴가 category 부분 제외하고는 모두 중복되고 있어 이 부분 수정하고 싶음.
        // Shakeshack menu
        System.out.println("[ SHAKESHACK MENU ]");
        mainMenuList.stream().filter(mainMenu -> mainMenu.getCategory().equals("Shakeshack"))
                .forEach(mainMenu -> System.out.println(mainMenu.getNumber() + ". "
                                + mainMenu.getName() + " | " + mainMenu.getExplanation()));
        System.out.println();



        // Order menu
        System.out.println("[ ORDER MENU ]");
        mainMenuList.stream().filter(mainMenu -> mainMenu.getCategory().equals("Order"))
                .forEach(mainMenu -> System.out.println(mainMenu.getNumber() + ". "
                        + mainMenu.getName() + " | " + mainMenu.getExplanation()));
        System.out.println();
    }

    public static void printSelectedBurgers() { // 버거 선택
        printCommon();

        System.out.println("[ Burgers MENU ]");
        Products.burgerList.stream().forEach(burger ->
                System.out.println(burger.getNumber() + ". " + burger.getName()
                        + " | W " + burger.getPrice() + " | " + burger.getExplanation()));
    }

    public static void printCartCheck(int menuNumber) { // 장바구니에 추가할지 물어보는 질문 출력
        Stream<Products> inputProduct = Products.burgerList.stream() // 사용자가 입력한 번호와 일치하면
                .filter(burger -> burger.getNumber() == menuNumber);
        inputProduct.forEach(product -> System.out.println("\"" + product.getName() // 해당 부분 출력
                + " | W " + product.getPrice() + " | " + product.getExplanation()));

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
    }
}
