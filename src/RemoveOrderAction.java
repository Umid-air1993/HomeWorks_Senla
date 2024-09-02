import java.util.List;
import java.util.Scanner;

public class RemoveOrderAction implements Action {
    private DataBase dataBase;

    public RemoveOrderAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int orderId;
        do {
            System.out.println("Enter order ID");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please Enter valid order id");
                scanner.next();
            }
            orderId = scanner.nextInt();
            scanner.nextLine();
            List<Order> orders = dataBase.getOrders();
            boolean foundOrder = false;
            for (Order order : orders) {
                if (order.getId() == orderId) {
                    foundOrder = true;
                    dataBase.removeOrder(order);
                    System.out.println("Order " + orderId + " removed");
                    break;
                }
            }
            if (!foundOrder) {
                System.out.println("Order " + orderId + " not found");
            }
        } while (orderId < 1 || orderId > dataBase.getMaxOrderId());
        {
        }
    }
}
