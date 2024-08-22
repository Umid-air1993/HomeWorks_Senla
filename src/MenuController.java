import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuController {
    private Builder builder;
    private Navigator navigator;
    public MenuController(Builder builder) {
        this.builder = builder;
        this.navigator = new Navigator(builder.getRootMenu()) ;

    }
    public void run(){
        builder.buildMenu();
      try {
          while (true){
              navigator.printMenu();
              Scanner scanner = new Scanner(System.in);
              System.out.println("Enter number menu item:");
              int menuItem = scanner.nextInt();
              navigator.navigate(menuItem);
          }
      }catch (InputMismatchException e){
          System.out.println("Please enter a valid number");
          while (true){
              navigator.printMenu();
              Scanner scanner = new Scanner(System.in);
              System.out.println("Enter number menu item:");
              int menuItem = scanner.nextInt();
              navigator.navigate(menuItem);
      }}
    }
}
