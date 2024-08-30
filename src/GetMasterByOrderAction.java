import java.util.List;
import java.util.Scanner;

public class GetMasterByOrderAction implements  Action{
    private DataBase dataBase;
    private AdminService adminService;
    public GetMasterByOrderAction(DataBase dataBase, AdminService adminService) {
        this.dataBase = dataBase;
        this.adminService = adminService;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order ID");
        int orderID = scanner.nextInt();
        Order order=adminService.findOrder(dataBase.getOrders(), orderID);
        if (order!=null){
            System.out.println(order.getMaster().getName());
        }else {
            System.out.println("Order not found");
        }
    }

}
