import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class AddOrderAction implements Action{
    private DataBase database;

    public AddOrderAction(DataBase database) {
        this.database = database;
    }
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of the order: ");
        int id = scanner.nextInt();
        System.out.println("Enter the name of the order: ");
        String name = scanner.nextLine();
        System.out.println("Enter start date of the order(yyyy-MM-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Enter end date of the order(yyyy-MM-dd): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Enter price of the order: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter name of the master");
        String masterName = scanner.nextLine();
        Master master=findMaster(database.getMasters(),masterName);
        System.out.println("Enter name of the garage: ");
        String garageName = scanner.nextLine();
        Garage garage=findGarage(database.getGarages(),garageName);
        Order order=new Order(id,name, startDate, endDate, price, master, garage );
        database.addOrder(order);
        System.out.println("Order added");

    }
    private Master findMaster(List<Master> masters, String name) {
        for (Master master : masters) {
            if (master.getName().equals(name)){
                return master;
            }
        }
        return null;
    }
    private Garage findGarage(List<Garage> garages, String name) {
        for (Garage garage : garages) {
            if (garage.getName().equals(name)){
                return garage;
            }
        }
        return null;
    }

}
