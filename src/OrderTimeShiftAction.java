import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderTimeShiftAction implements Action {
    private DataBase dataBase;
    private AdminService adminService;
    private Order order;

    public OrderTimeShiftAction(DataBase dataBase, AdminService adminService) {
        this.dataBase = dataBase;
        this.adminService = adminService;

    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Current status of order fulfillment time offsets: " + (dataBase.isTimeOfSetEnable() ? "On" : "Off"));
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter '1' to enable or '0' to disable order lead time offset");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    dataBase.setTimeOfSetEnable(true);
                    System.out.println("Order lead time offset enabled");
                    adminService.proccesOrder(order);
                } else if (choice == 0) {
                    dataBase.setTimeOfSetEnable(false);
                    System.out.println("Order lead time offset disabled");
                } else {
                    System.out.println("Invalid selection. Lead time offset remaining" + (dataBase.isTimeOfSetEnable() ? "On" : "Of"));
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input! p;ease enter '1' or '0'.");
                scanner.next();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                break;
            }
        }
    }

}
