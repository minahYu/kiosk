import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        while(true) {
            PrintMenu.printMainMenu();
            menu.selectMainMenu();
            //System.out.println("$$$");
            break;
        }


        /*List<Menu> shakeshackMenu = Arrays.asList(

        );*/
    }
}