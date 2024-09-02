import java.util.InputMismatchException;
import java.util.Scanner;

public class AddGarageAction implements Action {
    private DataBase dataBase;

    public AddGarageAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter Garage ID: ");
            int garageID = scanner.nextInt();
            System.out.println("Enter Garage Name: ");
            String garageName = scanner.next();
            Garage garage = new Garage(garageID, garageName);
            dataBase.addGarage(garage);
            System.out.println("Garage added");
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number");
        }
    }


}
