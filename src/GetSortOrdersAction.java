import java.util.List;
import java.util.Scanner;

public class GetSortOrdersAction implements Action {
    private DataBase dataBase;

    public GetSortOrdersAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("“Enter sort type (1- by submission date, 2- by due date, 3- by price):” ");
            int type = scanner.nextInt();
            scanner.nextLine();
            List<Order> sortedOrders = dataBase.getSortedOrders(type);
            System.out.println("Orders: ");
            for (Order order : sortedOrders) {
                System.out.println("ID: " + order.getId() + ", " + order.getStartDate() + ", " + order.getEndDate() + ", Price: " + order.getPrice());

            }
        } catch (Exception e) {
            OrderException.handleException(e);
        }
    }
}
