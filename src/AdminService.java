import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AdminService implements Serializable {
    private DataBase dataBase;

    public AdminService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

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

    public LocalDate findNearestFreedate(DataBase dataBase) {
        LocalDate date = LocalDate.now();
        while (true) {
            int freePleace = 0;
            for (Garage garage : dataBase.getGarages()) {
                if (!garage.isBusy()) {
                    freePleace++;
                }
            }
            for (Master master : dataBase.getMasters()) {
                if (!master.isBusy()) {
                    freePleace++;
                }
            }
            if (freePleace > 0) {
                System.out.println("Nearest free date:");
                return date;
            }
            date = date.plusDays(1);

            if (date.isAfter(LocalDate.now().plusYears(1))) {
                throw new NoAvialabledateException("No Available date found");
            }
        }
    }

    public int getFreePlace(DataBase dataBase, LocalDate date) {
        int freePleace = 0;
        for (Garage garage : dataBase.getGarages()) {
            if (!garage.isBusy()) {
                freePleace++;
            }
        }
        for (Master master : dataBase.getMasters()) {
            if (!master.isBusy()) {
                freePleace++;
            }
        }
        return freePleace;
    }

    public List<Order> getOrdersByDateAndType(DataBase dataBase, int type, LocalDate startDate, LocalDate endDate) {
        List<Order> orders = dataBase.getOrders();
        List<Order> ordersByDate = new ArrayList<>();
        for (Order order : orders) {
            if ((type == 1 && order.isDone()) || (type == 2 && order.isDeleted()) || (type == 3 && order.isCancelled())) {
                if (order.getStartDate().isAfter(startDate) && order.getEndDate().isBefore(endDate)) {
                    ordersByDate.add(order);
                }
            }
        }
        return ordersByDate;
    }

    public List<Garage> getFreeGarage(DataBase dataBase) {
        List<Garage> freeGarages = new ArrayList<>();
        for (Garage garage : dataBase.getGarages()) {
            if (!garage.isBusy()) {
                freeGarages.add(garage);
            }
        }
        return freeGarages;
    }

    public List<Order> getOrderByMasterName(DataBase dataBase, String masterName) {
        List<Order> orders = dataBase.getOrders();
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getMaster().equals(masterName)) {
                result.add(order);
            }
        }
        return result;
    }

    public void removeSpaceFromGarage(Garage garage, int spaceNumber) {
        garage.removeAvaliablePleace(spaceNumber);
    }

    public void proccesOrder(Order order) {
        if (dataBase.isTimeOfSetEnable()) {
            int timeOffSet = dataBase.getTimeOfSet();
            Date executionTime = order.getExecutionTime();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(executionTime);
            calendar.add(Calendar.MINUTE, timeOffSet);
            order.setExecutionTime(calendar.getTime());
        }
        System.out.println("Order fulfillment time: " + order.getExecutionTime());
    }

    public void getOrderByName(DataBase dataBase, String masterName) {
        List<Order> orders = dataBase.getOrders();
        boolean found = false;
        for (Order order : orders) {
            if (order.getName().equals(masterName)) {
                System.out.println("Order ID: " + order.getId() + ", Master: " +
                        order.getMaster().getName() + ", Start Date: " + order.getStartDate() + ", End Date: " + order.getEndDate() +
                        ", Price: " + order.getPrice());
                found = true;

            }
        }
        if (!found) {
            System.out.println("No order found fo Master: " + masterName);

        }
    }

    public void getOrderById(DataBase dataBase, int orderID) {
        List<Order> orders1 = dataBase.getOrders();
        boolean found1 = false;
        for (Order order : orders1) {
            if (order.getId() == orderID) {
                System.out.println("Order ID: " + order.getId() + ", Master: " +
                        order.getMaster().getName() + ", Start Date: " + order.getStartDate() + ", End Date: " + order.getEndDate() +
                        ", Price: " + order.getPrice());
                found1 = true;
                break;
            }
        }
        if (!found1) {
            System.out.println("Order whith ID " + orderID + " is not found");
        }
    }
}
