import java.util.List;
import java.util.Scanner;

public class GetMasterByOrderAction implements  Action{
    private DataBase dataBase;
    public GetMasterByOrderAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order ID");
        int orderID = scanner.nextInt();
        Order order=findOrder(dataBase.getOrders(), orderID);
        if (order!=null){
            System.out.println(order.getMaster().getName());
        }else {
            System.out.println("Order not found");
        }
    }
    private Order findOrder(List<Order> orders,int orderID) {
        for(Order order:orders) {
            if (order.getId()==orderID){
                return order;
            }
        }
    return null;}
}
