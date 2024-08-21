import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetOrderbyDateAction implements Action{
    private DataBase dataBase;
    public GetOrderbyDateAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of orders (1 - completed, 2 - deleted, 3 - canceled): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the start date: ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Enter the end date: ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Order> orders = dataBase.getOrders();
        List<Order> ordersByDate = new ArrayList<>();
        for (Order order:orders){
            if ((type==1&&order.isDone())||(type==2&&order.isDeleted())||(type==3&&order.isCancelled())){
                if (order.getStartDate().isAfter(startDate)&&order.getEndDate().isBefore(endDate)){
                    ordersByDate.add(order);
                }
            }
        }
        System.out.println("Orders: ");
        for (Order order:ordersByDate){
            System.out.println(order.getId()+"-"+order.getStartDate()+"-"+order.getEndDate()+"-"+order.getPrice());

        }
    }
}
