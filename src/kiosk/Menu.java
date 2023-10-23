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
    public void setName(String name) { this.name = name; }
    public void setExplanation(String explanation) { this.explanation = explanation; }

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
                PrintMenu.surcharge = 2.3;
                break;
            case 2:
                printMenu.printSelectedFoodMenu(Order.chickenList);
                selectProductMenu(Order.chickenList);
                PrintMenu.surcharge = 2.3;
                break;
            case 3:
                printMenu.printSelectedFoodMenu(Order.drinkList);
                selectProductMenu(Order.drinkList);
                PrintMenu.surcharge = 0.5;
                break;
            case 4:
                printMenu.printSelectedFoodMenu(Order.sideList);
                selectProductMenu(Order.sideList);
                PrintMenu.surcharge = 0.5;
                break;
            case 5: // 장바구니 리스트 화면
                printMenu.printCartList();
                break;
            case 6: // 주문 취소화면
                printMenu.printOrderCancel();
                break;
            default:
                System.out.println("잘못된 입력입니다.\n");
        }
    }

    public void selectProductMenu(List<Products> productsList) { // 메뉴 선택 (음식)
        int foodNumber = sc.nextInt(); // 입력받기

        PrintMenu.printOptionCheck(foodNumber, productsList);
    }

    public int selectOption(Products productStream) {
        int selectedNumber = sc.nextInt();

        return selectedNumber;
    }

    public void selectAddCart(String menuName, int selectedOptionNumber, double finalPrice, Products product) { // 장바구니에 담을지 선택
        int addCartNumber = sc.nextInt();
        String option = selectedOptionNumber==1 ? "S" : "D";


        switch(addCartNumber) {
            case 1:
                boolean exist = false;
                Products myProduct = new Products(product.getNumber(), product.getCategory(),
                        finalPrice, option, product.getName(), product.getExplanation());

                for(Products inCartProduct : Order.cartList) {
                    if(inCartProduct.getName().equals(myProduct.getName())
                            && inCartProduct.getOption().equals(myProduct.getOption())) {
                        inCartProduct.setCount(inCartProduct.getCount() + 1);
                        exist = true;
                        break;
                    }
                }

                if(exist == false) {
                    myProduct.setCount(myProduct.getCount() + 1);
                    Order.cartList.add(myProduct);
                }
                Order.totalSalesList.add(myProduct);
                System.out.println(menuName + " 가 장바구니에 추가되었습니다\n");
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








