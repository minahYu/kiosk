package kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        while(true) {
            // 메인 화면
            PrintMenu.printCommon();
            PrintMenu.printCategoryMenu("Mom's Touch");
            PrintMenu.printCategoryMenu("Order");
            
            menu.selectMainMenu();
        }
    }
}
