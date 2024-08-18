import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ServiceUI {
        ServiceController controller = new ServiceController();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        void start() throws ParseException {
            while (true) {
                System.out.println("1. Add Master");
                System.out.println("2. Remove Master");
                System.out.println("3. Add place in garage");
                System.out.println("4. Remove place in garage");
                System.out.println("5.Add Order");
                System.out.println("6. Remove Order");
                System.out.println("7. Close Order");
                System.out.println("8. Cancel Order");
                System.out.println("9. Show list free place in garage");
                System.out.println("10. Show list orders");
                System.out.println("11. show list masters");
                System.out.println("12. Show the list of currently running orders");
                System.out.println("13. Show orders performed by a specific master");
                System.out.println("14. Show masters performed by a specific order");
                System.out.println("15. Show orders for a period of time");
                System.out.println("16. Show the number of available seats on the service for any date");
                System.out.println("17.  Find nearlest free date");
                System.out.println("0. Exit");
                System.out.print("Select the option: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (option) {
                    case 1:
                        System.out.print("Enter Master name : ");
                        String masterName = scanner.nextLine();
                        controller.addMaster(masterName);
                        break;
                    case 2:
                        System.out.print("Enter Master name: ");
                        masterName = scanner.nextLine();
                        controller.removeMaster(masterName);
                        break;
                    case 3:
                        System.out.print("Enter ID pleace in garage: ");
                        int garageId = scanner.nextInt();
                        controller.addGarage(garageId);
                        break;
                    case 4:
                        System.out.print("Enter ID pleace in garage: ");
                        garageId = scanner.nextInt();
                        controller.removeGarage(garageId);
                        break;
                    case 5:
                        System.out.print("Enter order ID : ");
                        int orderId = scanner.nextInt();
                        System.out.print("Enter the date of filing  (dd-MM-yyyy): ");
                        String submissionDateStr = scanner.next();
                        Date submissionDate = dateFormat.parse(submissionDateStr);
                        System.out.print("Enter the planned start date (dd-MM-yyyy): ");
                        String plannedStartDateStr = scanner.next();
                        Date plannedStartDate = dateFormat.parse(plannedStartDateStr);
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        controller.addOrder(orderId, submissionDate, plannedStartDate, price);
                        break;
                    case 6:
                        System.out.print("Enter ID order: ");
                        orderId = scanner.nextInt();
                        controller.removeOrder(orderId);
                        break;
                    case 7:
                        System.out.print("Enter ID order: ");
                        orderId = scanner.nextInt();
                        controller.closeOrder(orderId);
                        break;
                    case 8:
                        System.out.print("Enter ID order: ");
                        orderId = scanner.nextInt();
                        controller.cancelOrder(orderId);
                        break;
                    case 9:
                        List<Garage> freeGarages = controller.listFreeGarages();
                        System.out.println("Free pleace in garage:");
                        for (Garage garage : freeGarages) {
                            System.out.println("ID: " + garage.id);
                        }
                        break;
                    case 10:
                        System.out.print("Sort (submissionDate, submissionDate, plannedStartDate, price): ");
                        String sortBy = scanner.next();
                        List<Order> orders = controller.listOrders(sortBy);
                        System.out.println("List order:");
                        for (Order order : orders) {
                            System.out.println("ID: " + order.id + ", Status: " + order.status + ", submissionDate: " + dateFormat.format(order.submissionDate) + ", submissionDate: " + dateFormat.format(order.plannedStartDate) + ", Price: " + order.price);
                        }
                        break;
                    case 11:
                        System.out.print("Sort of (name, isBusy): ");
                        sortBy = scanner.next();
                        List<Master> masters = controller.listMasters(sortBy);
                        System.out.println("List masters:");
                        for (Master master : masters) {
                            System.out.println("Name: " + master.name + ", Busy: " + master.isBusy);
                        }
                        break;
                    case 12:
                        System.out.print("Li (submissionDate, completionDate, price): ");
                        sortBy = scanner.next();
                        List<Order> currentOrders = controller.listCurrentOrders(sortBy);
                        System.out.println("Current orders in progress:");
                        for (Order order : currentOrders) {
                            System.out.println("ID: " + order.id + ", Status: " + order.status + ", submissionDate: " + dateFormat.format(order.submissionDate) + ", completionDate: " + dateFormat.format(order.plannedStartDate) + ", Price: " + order.price);
                        }
                        break;
                    case 13:
                        System.out.print("Enter name of master: ");
                        masterName = scanner.nextLine();
                        List<Order> ordersByMaster = controller.listOrdersByMaster(masterName);
                        System.out.println("Orders carried out by the craftsman " + masterName + ":");
                        for (Order order : ordersByMaster) {
                            System.out.println("ID: " + order.id + ", Status: " + order.status + ", submissionDate: " + dateFormat.format(order.submissionDate) + ", completionDate: " + dateFormat.format(order.plannedStartDate) + ", Price: " + order.price);
                        }
                        break;
                    case 14:
                        System.out.print("Enter ID orders: ");
                        orderId = scanner.nextInt();
                        List<Master> mastersByOrder = controller.listMastersByOrder(orderId);
                        System.out.println("Masters fulfilling the order" + orderId + ":");
                        for (Master master : mastersByOrder) {
                            System.out.println("Name: " + master.name + ", Busy: " + master.isBusy);
                        }
                        break;
                    case 15:
                        System.out.print("Enter status order (executed, deleted, canceled): ");
                        String status = scanner.next();
                        System.out.print("Enter the start date (dd-MM-yyyy): ");
                        String startDateStr = scanner.next();
                        Date startDate = dateFormat.parse(startDateStr);
                        System.out.print("Enter finish date (dd-MM-yyyy): ");
                        String endDateStr = scanner.next();
                        Date endDate = dateFormat.parse(endDateStr);
                        System.out.print("Sort  (submissionDate, completionDate, price): ");
                        sortBy = scanner.next();
                        List<Order> ordersByStatusAndDateRange = controller.listOrdersByStatusAndDateRange(status, startDate, endDate, sortBy);
                        System.out.println("Orders over a period of time:");
                        for (Order order : ordersByStatusAndDateRange) {
                            System.out.println("ID: " + order.id + ", Status: " + order.status + ", submissionDate: " + dateFormat.format(order.submissionDate) + ", completionDate: " + dateFormat.format(order.plannedStartDate) + ", Price: " + order.price);
                        }
                        break;
                    case 16:
                        System.out.print("Enter date (dd-MM-yyyy): ");
                        String dateStr = scanner.next();
                        Date date = dateFormat.parse(dateStr);
                        int freeSpaces = controller.countFreeSpacesOnDate(date);
                        System.out.println("Number of available seats on " + dateStr + ": " + freeSpaces);
                        break;
                    case 17:
                        Date nextFreeDate = controller.findNextFreeDate();
                        System.out.println("Near avialable pleace: " + dateFormat.format(nextFreeDate));
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error. Please try again.");
                }
            }
        }
}
