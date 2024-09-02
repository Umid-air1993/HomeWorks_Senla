import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddOrderAction implements Action {
    private DataBase database;

    public AddOrderAction(DataBase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        try {

            AdminService adminService = new AdminService();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter id of the order: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the order description: ");
            String name = scanner.nextLine();
            LocalDate startDate;
            LocalDate endDate;
            while (true) {
                try {
                    System.out.println("Enter start date of the order(yyyy-MM-dd): ");
                    startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    System.out.println("Enter end date of the order(yyyy-MM-dd): ");
                    endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    if (!startDate.isBefore(endDate)) {
                        System.out.println("Start date must be before end date. Please enter again.");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid date format. Please try again");
                }
            }
            System.out.println("Enter price of the order: ");
            double price = scanner.nextDouble();
            if (price < 0) {
                throw new Exception("Price can not be negative");
            }
            scanner.nextLine();
            System.out.println("Enter ID of the master");
            int masterId = scanner.nextInt();
            String masterName = scanner.nextLine();
            Master master = adminService.findMaster(database.getMasters(), masterId, masterName);
            if (master == null) {
                System.out.println("Master not found.Please enter a valid ID and name");
                return;
            }
            System.out.println("Enter name of the garage: ");
            int garageId = scanner.nextInt();
            Garage garage = adminService.findGarage(database.getGarages(), garageId);
            if (garage == null) {
                System.out.println("Garage not found.Please enter a valid  garage ID");
                return;
            }
            Order order = new Order(id, name, startDate, endDate, price, master, garage);
            database.addOrder(order);
            System.out.println("Order added");
        } catch (
                InputMismatchException e) {
            System.out.println("Please enter a valid number");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
