package kiosk;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

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
    public int getNumber() { return number; }
    public String getCategory() { return category; }
    public String getName() { return name; }
    public String getExplanation() { return explanation; }

    // setter
    public void setName() { this.name = name; }
    public void setExplanation() { this.explanation = explanation; }

    public void selectMainMenu() { // 메인메뉴 선택
        int mainMenuNumber = sc.nextInt();
        PrintMenu printMenu = new PrintMenu();

        switch (mainMenuNumber) {
            case 0:
                printMenu.printTotalSalesList();
                break;
            case 1:
                printMenu.printSelectedFoodMenu(Order.burgerList);
                selectProductMenu(Order.burgerList);
                break;
            case 2:
                printMenu.printSelectedFoodMenu(Order.chickenList);
                selectProductMenu(Order.chickenList);
                break;
            case 3:
                printMenu.printSelectedFoodMenu(Order.drinkList);
                selectProductMenu(Order.drinkList);
                break;
            case 4:
                printMenu.printSelectedFoodMenu(Order.sideList);
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
        boolean containInputNumber = productsList.contains(foodNumber); // 입력 받은 값이 productsList에 있는지

        if(!containInputNumber) {
            //PrintMenu.printCartCheck(foodNumber, productsList);
            PrintMenu.printOptionCheck(foodNumber, productsList);
            System.out.println();
        } else {
            System.out.println("메뉴에 해당하는 숫자를 입력해주세요.\n");
        }
    }

    public int selectOption(Products productStream) {
        int selectedNumber = sc.nextInt();
        /*double changePrice = 0; // 수정된 가격 저장할 변수

        if(selectedNumber == 2) { // 옵션 2번 선택시 가격 수정
            changePrice = productStream.getPrice() + PrintMenu.doublePrice;
            //productStream.setPrice(productStream.getPrice() + PrintMenu.doublePrice);
        }*/

        return selectedNumber;
    }

    public void selectAddCart(String menuName, List<Products> productsList) { // 장바구니에 담을지 선택
        int addCartNumber = sc.nextInt();
        switch(addCartNumber) {
            case 1:
                productsList.stream().filter(product -> product.getName().equals(menuName))
                                .forEach(product -> { // menuName 과 일치하는 정보들 cartList와 totalSalesList에 추가
                                    if(Order.cartList.contains(product)) {
                                        product.setCount(product.getCount()+1);
                                    } else {
                                        Order.cartList.add(product);
                                        product.setCount(product.getCount() + 1);
                                    }
                                    Order.totalSalesList.add(product);
                                });
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
                if(!PrintMenu.printCompleteOrder()) { // 장바구니가 채워져 있으면
                    waitingThread.run(); // 3초 기다리기
                    Order.cartList.clear();
                }
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








