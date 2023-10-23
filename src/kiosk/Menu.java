package kiosk;

import java.util.List;
import java.util.Scanner;

public class Menu {
    int number;
    String category;
    String name = "";
    String explanation;

    private final Scanner sc = new Scanner(System.in);

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

    // 입력받은 값이 정해진 범위내에 없을 때 메세지를 출력하는 메서드
    static public void wrongInput() {
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
    }

    // 선택지가 두개일 때(1 or 2) 범위가 벗어나게 되면 실행되는 메서드
    public void twoOptionsRange(int selectedNumber) {
        while(selectedNumber != 1 && selectedNumber !=2) {
            wrongInput();
            selectedNumber = getInput();
        }
    }

    // 카테고리를 선택하는 메서드
    public void selectCategory() {
        int selectedNumber = getInput();
        PrintMenu printMenu = new PrintMenu();

        switch (selectedNumber) {
            case 0:
                printMenu.printTotalSalesList();
                break;
            case 1:
                PrintMenu.gap = 21;
                printMenu.printSelectedFoodMenu(Order.burgerList);
                selectProductMenu(Order.burgerList);
                PrintMenu.surcharge = 2.3;
                break;
            case 2:
                PrintMenu.gap = 35;
                printMenu.printSelectedFoodMenu(Order.chickenList);
                selectProductMenu(Order.chickenList);
                PrintMenu.surcharge = 2.3;
                break;
            case 3:
                PrintMenu.gap = 10;
                printMenu.printSelectedFoodMenu(Order.drinkList);
                selectProductMenu(Order.drinkList);
                PrintMenu.surcharge = 0.5;
                break;
            case 4:
                PrintMenu.gap = 10;
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
                wrongInput();
        }
    }

    // 입력값을 받는 메서드
    public int getInput() {
        int selectedNumber = sc.nextInt();

        return selectedNumber;
    }

    // 음식 메뉴 선택하는 메서드
    public void selectProductMenu(List<Products> productsList) {
        int selectedNumber = getInput(); // 입력받기
        int listLastNumber = productsList.get(productsList.size()-1).getNumber();

        while(selectedNumber < 1 || selectedNumber > listLastNumber) {
            wrongInput();
            selectedNumber = getInput();
        }
        PrintMenu.printOptionCheck(selectedNumber, productsList);
    }

    // 장바구니에 담을지 선택하는 메서드
    public void selectAddCart(String menuName, int selectedOptionNumber, double finalPrice, Products product) {
        int selectedNumber = getInput();
        String option = selectedOptionNumber == 1 ? "S" : "D";

        twoOptionsRange(selectedNumber);
        switch (selectedNumber) {
            case 1: // 추가
                boolean exist = false;
                Products myProduct = new Products(product.getNumber(), product.getCategory(),
                        finalPrice, option, product.getName(), product.getExplanation());

                for (Products inCartProduct : Order.cartList) {
                    if (inCartProduct.getName().equals(myProduct.getName())
                            && inCartProduct.getOption().equals(myProduct.getOption())) {
                        inCartProduct.setCount(inCartProduct.getCount() + 1);
                        exist = true;
                        break;
                    }
                }

                if (!exist) {
                    myProduct.setCount(myProduct.getCount() + 1);
                    Order.cartList.add(myProduct);
                }
                Order.totalSalesList.add(myProduct);
                System.out.println(menuName + " 가 장바구니에 추가되었습니다\n");
                break;
            case 2: // 취소
                break;
        }
    }

    // 장바구니 리스트 본 후 주문할지, 메뉴판으로 돌아갈지 선택하는 메서드
    public void selectOrderOrMenu() {
        WaitingThread waitingThread = new WaitingThread();
        int selectedNumber = getInput();

        twoOptionsRange(selectedNumber);

        switch (selectedNumber) {
            case 1:
                if (!PrintMenu.printCompleteOrder()) { // 장바구니가 채워져 있으면
                    waitingThread.run(); // 3초 기다리기
                    Order.cartList.clear();
                }
                break;
            case 2:
                break;
        }
    }

    // 주문을 취소할지 계속할지 선택하는 메서드
    public void selectOrderCancel() {
        int selectedNumber = getInput();
        twoOptionsRange(selectedNumber);

        switch (selectedNumber) {
            case 1:
                Order.cartList.clear();
                System.out.println("진행하던 주문이 취소되었습니다.\n");
                break;
            case 2:
                break;
        }
    }

    // 총 판매 상품 목록 현황 화면에서 돌아가기 버튼을 눌러야 돌아가게끔 하는 메서드
    public void back() {
        int input = getInput();
        boolean check = false;

        while(!check) {
            if (input == 1) {
                check = true;
            } else {
                wrongInput();
                input = getInput();
            }
        }
    }
}