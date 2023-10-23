package kiosk;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        while (true) {
            // 메인 화면
            PrintMenu.printCommon();
            PrintMenu.printCategoryMenu("Mom's Touch");
            PrintMenu.printCategoryMenu("Order");

            menu.selectCategory();
        }
    }
}