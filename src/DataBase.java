import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Master> masters;
    private List<Order> orders;
    private List<Garage> garages;

    public DataBase() {
        this.masters = new ArrayList<Master>();
        this.orders = new ArrayList<Order>();
        this.garages = new ArrayList<Garage>();
    }

    public List<Master> getMasters() {
        return masters;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Garage> getGarages() {
        return garages;
    }
    public void addMaster(Master master) {
        masters.add(master);
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public void addGarage(Garage garage) {
        garages.add(garage);
    }
    public void removeMaster(Master master) {
        masters.remove(master);
    }
    public void removeOrder(Order order) {
        orders.remove(order);
    }
    public void removeGarage(Garage garage) {
        garages.remove(garage);
    }
}
