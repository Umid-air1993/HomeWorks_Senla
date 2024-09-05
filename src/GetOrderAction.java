import java.util.List;
import java.util.Scanner;

public class GetOrderAction implements Action{
    private DataBase dataBase;
    private AdminService adminService;
    public GetOrderAction(DataBase dataBase, AdminService adminService) {
        this.dataBase = dataBase;
        this.adminService = adminService;
    }
    @Override
    public void execute() {
    Scanner scanner = new Scanner(System.in);
        System.out.println("Search order by: 1-Master name, 2-Order ID");
        int choice = scanner.nextInt();
        scanner.nextLine();
      try{  switch (choice) {
            case 1:
                System.out.println("Enter name of Master: ");
                String masterName = scanner.nextLine();
                adminService.getOrderByName(dataBase, masterName);
            break;
                case 2:
                    System.out.println("Enter order ID: ");
                    int orderID = scanner.nextInt();
                    adminService.getOrderById(dataBase, orderID);
                    break;
            default:
                System.out.println("Invalid choice");
        }
    }catch (Exception e){
          System.out.println("Error: " + e.getMessage());}
    }
}
