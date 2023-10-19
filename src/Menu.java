import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    int number;
    private String category;
    String name;
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

    // getter, setter
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

    public void setName() {
        this.name = name;
    }

    public void setExplanation() {
        this.explanation = explanation;
    }

    
    public void selectBurgersMenu() { // 버거메뉴 선택
        PrintMenu.printSelectedBurgers(); // 메뉴 보여주기

        int burgerNumber = sc.nextInt(); // 입력받기

        switch(burgerNumber) {
            case 1:
                PrintMenu.printCartCheck(burgerNumber);
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

    public void selectMainMenu() { // 메인메뉴 선택
        int mainMenuNumber = sc.nextInt();

        switch (mainMenuNumber) {
            case 1:
                selectBurgersMenu();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }
}
