package sections;

import java.util.Scanner;

public class MainMenu {

    public static int printMenu(String[] menuItems, Scanner input){

        for(String menuItem: menuItems){
            System.out.println(menuItem);
        }

        int selectedItem = input.nextInt();

        if(selectedItem <= 0){
            System.out.println("Wrong number input for Menu Items");
            System.exit(0);
        }
        return selectedItem - 1;
    }

}
