package kiosk;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        while(true) {
            PrintMenu.printMainMenu();
            menu.selectMainMenu();
        }
    }
}
