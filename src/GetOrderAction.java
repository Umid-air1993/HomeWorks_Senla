import java.util.List;
import java.util.Scanner;

public class GetOrderAction implements Action{
    private DataBase dataBase;
    public GetOrderAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name Master: ");
        String name = scanner.nextLine();
        Master master=findMaster(dataBase.getMasters(),name);
        if(master == null){
            for(Order order:dataBase.getOrders()){
                if(order.getMaster().equals(master)){
                    System.out.println(order.getMaster()+" "+order.getStartDate()+" "+order.getEndDate()+" "+order.getPrice());

                }
            }
        }else{
            System.out.println("Master not found");
        }
    }
    private Master findMaster(List<Master> masterList, String name){
        for(Master master:masterList){
            if (master.getName().equals(name)){

                return master;
            }
        }return null;
    }
}
