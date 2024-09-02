import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdminService {

    public Master findMaster(List<Master> masters, int id, String name) {
        for (Master master : masters) {
            if (master.getId() == id) {
                return master;
            }
        }
        return null;
    }

    public Garage findGarage(List<Garage> garages, int garageId) {
        for (Garage garage : garages) {
            if (garage.getId() == garageId) {
                return garage;
            }
        }
        return null;
    }

    public Order findOrder(List<Order> orders, int orderID) {
        for (Order order : orders) {
            if (order.getId() == orderID) {
                return order;
            }
        }
        return null;
    }
    public LocalDate findNearestFreedate(DataBase dataBase){
        LocalDate date = LocalDate.now();
        while (true){
            int freePleace=0;
            for (Garage garage : dataBase.getGarages()) {
                if (!garage.isBusy()){
                    freePleace++;
                }
            }
            for (Master master : dataBase.getMasters()) {
                if (!master.isBusy()){
                    freePleace++;
                }
            }
            if (freePleace>0){
                System.out.println("Nearest free date:");
                return date;
            }
            date=date.plusDays(1);
        }
    }
    public int getFreePlace(DataBase dataBase,LocalDate date){
        int freePleace=0;
        for (Garage garage : dataBase.getGarages()) {
            if (!garage.isBusy()){
                freePleace++;
            }
        }for (Master master : dataBase.getMasters()) {
            if (!master.isBusy()){
                freePleace++;
            }
        }return freePleace;
    }
    public List<Order> getOrdersByDateAndType(DataBase dataBase,int type, LocalDate startDate, LocalDate endDate ) {
        List<Order> orders = dataBase.getOrders();
        List<Order> ordersByDate = new ArrayList<>();
        for (Order order:orders){
            if ((type==1&&order.isDone())||(type==2&&order.isDeleted())||(type==3&&order.isCancelled())){
                if (order.getStartDate().isAfter(startDate)&&order.getEndDate().isBefore(endDate)){
                    ordersByDate.add(order);
                }
            }
        }
        return ordersByDate;
    }
    public List<Garage> getFreeGarage(DataBase dataBase) {
        List<Garage> freeGarages =new ArrayList<>();
        for (Garage garage : dataBase.getGarages()) {
            if (!garage.isBusy()) {
                freeGarages.add(garage);}
        }
        return freeGarages;
    }
    public List<Order> getOrderByMasterName(DataBase dataBase,String masterName){
        List<Order> orders = dataBase.getOrders();
        List<Order> result = new ArrayList<>();
        for(Order order:orders){
            if(order.getMaster().equals(masterName)){
            result.add(order);
            }
        }return result;
    }
}
