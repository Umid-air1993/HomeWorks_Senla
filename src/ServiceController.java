import java.util.Date;
import java.util.List;

public class ServiceController {
    AdminService admin = new AdminService();

        void addMaster(String name) {
            admin.addMaster(name);
        }

        void removeMaster(String name) {
            admin.removeMaster(name);
        }

        void addGarage(int id) {
            admin.addGarage(id);
        }

        void removeGarage(int id) {
            admin.removeGarage(id);
        }

        void addOrder(int id, Date submissionDate, Date plannedStartDate, double price) {
            admin.addOrder(id, submissionDate, plannedStartDate, price);
        }

        void removeOrder(int id) {
            admin.removeOrder(id);
        }

        void closeOrder(int id) {
            admin.closeOrder(id);
        }

        void cancelOrder(int id) {
            admin.cancelOrder(id);
        }

        List<Garage> listFreeGarages() {
            return admin.listFreeGarages();
        }

        List<Order> listOrders(String sortBy) {
            return admin.listOrders(sortBy);
        }

        List<Master> listMasters(String sortBy) {
            return admin.listMasters(sortBy);
        }

        List<Order> listCurrentOrders(String sortBy) {
            return admin.listCurrentOrders(sortBy);
        }

        List<Order> listOrdersByMaster(String masterName) {
            return admin.listOrdersByMaster(masterName);
        }

        List<Master> listMastersByOrder(int orderId) {
            return admin.listMastersByOrder(orderId);
        }

        List<Order> listOrdersByStatusAndDateRange(String status, Date startDate, Date endDate, String sortBy) {
            return admin.listOrdersByStatusAndDateRange(status, startDate, endDate, sortBy);
        }

        int countFreeSpacesOnDate(Date date) {
            return admin.countFreeSpacesOnDate(date);
        }

        Date findNextFreeDate() {
            return admin.findNextFreeDate();
        }


}
