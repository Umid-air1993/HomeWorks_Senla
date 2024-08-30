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
        switch (choice) {
            case 1:
                System.out.println("Enter name of Master: ");
                String masterName = scanner.nextLine();
                List<Order> orders=dataBase.getOrders();
                boolean found=false;
                for(Order order:orders){
                    if(order.getName().equals(masterName)){
                        System.out.println( "Order ID: "+order.getId()+", Master: "+
                                order.getMaster().getName()+", Start Date: "+order.getStartDate()+", End Date: "+order.getEndDate()+
                                ", Price: "+order.getPrice());
                        found=true;

                    }  if ( !found){
                        System.out.println("No order found fo Master: "+masterName);

                    }
                }break;
                case 2:
                    System.out.println("Enter order ID: ");
                    int orderID = scanner.nextInt();
                    List<Order> orders1=dataBase.getOrders();
                    boolean found1=false;
                    for (Order order : orders1) {
                        if (order.getId() == orderID) {
                            System.out.println( "Order ID: "+order.getId()+", Master: "+
                                    order.getMaster().getName()+", Start Date: "+order.getStartDate()+", End Date: "+order.getEndDate()+
                                    ", Price: "+order.getPrice());
                            found1=true;
                            break;
                        }if (!found1){
                            System.out.println("Order whith ID "+orderID+" is not found");
                        }
                    }break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
