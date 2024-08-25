import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GetOrdersAction implements Action {
    private DataBase dataBase;
    public GetOrdersAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }
@Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("“Enter sort type (1- by submission date, 2- by due date, 3- by price):” ");
        int type = scanner.nextInt();
        scanner.nextLine();
        List<Order> orders = dataBase.getOrders();
        switch (type) {
            case 1:
                Collections.sort(orders, Comparator.comparing(Order::getStartDate));
                break;
            case 2:
                Collections.sort(orders, Comparator.comparing(Order::getEndDate));
                break;
            case 3:
                Collections.sort(orders, Comparator.comparing(Order::getPrice));
                break;
        }
    System.out.println("Orders: ");
        for (Order order : orders) {
            System.out.println(order.getId()+" "+order.getStartDate()+" "+order.getEndDate()+" "+order.getPrice());

        }
        /*   public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sort type (1 by submission date, 2 by due date, 3 by price): ");
        int sortType = scanner.nextInt();
        scanner.nextLine();
        List<Order> orders = dataBase.getOrders();
        List<Order> currentOrders = dataBase.getOrders();
        for (Order order : orders) {
            if (!order.isDone()&&!order.isDeleted()&&!order.isCancelled()) {
                currentOrders.add(order);
            }
        }
        switch (sortType) {
            case 1:
                Collections.sort(currentOrders, Comparator.comparing(Order::getStartDate));
                break;
                case 2:
                    Collections.sort(currentOrders, Comparator.comparing(Order::getEndDate));
                    break;
                    case 3:
                        Collections.sort(currentOrders, Comparator.comparing(Order::getPrice));
                        break;
        }
        System.out.println("Current orders: ");
        for (Order order : currentOrders) {
            System.out.println(order.getId()+" "+order.getStartDate()+" "+order.getEndDate()+" "+order.getPrice());*/
}
}
