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
                PrintMenu.printSelectedFoodMenu(Order.burgerList);
                selectProductMenu(Order.burgerList);
                break;
            case 2:
                PrintMenu.printSelectedFoodMenu(Order.chickenList);
                selectProductMenu(Order.chickenList);
                break;
            case 3:
                PrintMenu.printSelectedFoodMenu(Order.drinkList);
                selectProductMenu(Order.drinkList);
                break;
            case 4:
                PrintMenu.printSelectedFoodMenu(Order.sideList);
                selectProductMenu(Order.sideList);
                break;
            case 5: // 장바구니 리스트 화면
                printMenu.printCartList();
                break;
            case 6: // 주문 취소화면
                printMenu.printOrderCancel();
                break;
        }
    }

    public void selectProductMenu(List<Products> productsList) { // 메뉴 선택 (음식)
        int foodNumber = sc.nextInt(); // 입력받기

        PrintMenu.printCartCheck(foodNumber, productsList);
        System.out.println();
    }

    public void selectAddCart(String menuName, List<Products> productsList) { // 장바구니에 담을지 선택
        int addCartNumber = sc.nextInt();
        switch(addCartNumber) {
            case 1:
                productsList.stream().filter(product -> product.getName().equals(menuName))
                                .forEach(product -> Order.cartList.add(product)); // menuName 과 일치하는 정보들 cartList에 추가
                System.out.println(menuName + " 가 장바구니에 추가되었습니다");
                break;
            case 2:
                break;
        }
    }

    public void selectOrderOrMenu() { // 장바구니 리스트 본 후 주문할지, 메뉴판으로 돌아갈지 선택
        WaitingThread waitingThread = new WaitingThread();
        int selectedNumber = sc.nextInt();
        switch(selectedNumber) {
            case 1:
                PrintMenu.printCompleteOrder();
                waitingThread.run(); // 3초 기다리기
                Order.cartList.clear();
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








