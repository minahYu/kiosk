package kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    int number;
    String category;
    String name = "";
    String explanation;

    private Scanner sc = new Scanner(System.in);

    // 기본생성자
    public Menu() {}

    public Menu(int number, String category, String name, String explanation) {
        this.number = number;
        this.category = category;
        this.name = name;
        this.explanation = explanation;
    }

    // getter
    public int getNumber() {
        return number;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }

    // setter
    public void setName() {
        this.name = name;
    }

    public void setExplanation() {
        this.explanation = explanation;
    }

    public void selectMainMenu() { // 메인메뉴 선택
        int mainMenuNumber = sc.nextInt();
        PrintMenu printMenu = new PrintMenu();

        switch (mainMenuNumber) {
            case 1:
                selectBurgersMenu();
                break;
            case 2:
                break;
            case 3:
                selectDrinksMenu();
                break;
            case 4:
                break;
            case 5: // 장바구니 리스트 화면
                printMenu.printCartList();
                break;
            case 6: // 주문 취소화면
                printMenu.printOrderCancel();
                break;
        }
    }

    public void selectBurgersMenu() { // 버거메뉴 선택
        PrintMenu.printSelectedBurgers(); // 메뉴 보여주기
        int burgerNumber = sc.nextInt(); // 입력받기

        switch(burgerNumber) {
            case 1:
                PrintMenu.printCartCheck(burgerNumber, Order.burgerList);
                System.out.println();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    public void selectDrinksMenu() { // 음료메뉴 선택
        PrintMenu.printSelectedDrinks(); // 메뉴 보여주기
        int drinkNumber = sc.nextInt(); // 입력받기

        switch(drinkNumber) {
            case 1:
                PrintMenu.printCartCheck(drinkNumber, Order.drinkList);
                System.out.println();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    public void selectAddCart(String menuName) { // 장바구니에 담을지 선택
        int addCartNumber = sc.nextInt();
        switch(addCartNumber) {
            case 1:
                Order.burgerList.stream().filter(burger -> burger.getName().equals(menuName))
                                .forEach(burger -> Order.cartList.add(burger)); // menuName 과 일치하는 정보들 cartList에 추가
                System.out.println(menuName + " 가 장바구니에 추가되었습니다");
                break;
            case 2:
                break;
        }
    }

    public void selectOrderOrMenu() { // 장바구니 리스트 본 후 주문할지, 메뉴판으로 돌아갈지 선택
        int selectedNumber = sc.nextInt();
        switch(selectedNumber) {
            case 1:
                // sleep(3000); // 스레드 생성해야할 듯
                PrintMenu.completeOrder();
                break;
            case 2:
                break;
        }
    }

    public void selectOrderCancel() { // 주문 취소 or not 선택
        int selectedNumber = sc.nextInt();
        switch(selectedNumber) {
            case 1:
                Order.cartList.clear();
                System.out.println("진행하던 주문이 취소되었습니다.\n");
                break;
            case 2:
                break;
        }
    }
}
