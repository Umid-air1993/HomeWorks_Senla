import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveGarageSpaceAction implements Action{
    private DataBase dataBase;
    public RemoveGarageSpaceAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> garageSpace = dataBase.getGarageId();
        if(garageSpace.isEmpty()){
            System.out.println("No garage space avialable.");
            return;
        }
        System.out.println("Avialable garage spaces: ");
        for (int id:garageSpace){
            System.out.println(id);
        }
        int garageId;
        do {
            System.out.println("Enter garage id to remove: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
            garageId = scanner.nextInt();
            scanner.nextLine();
        }while (!garageSpace.contains(garageId));
        dataBase.removeGarageSpace(garageId);
        System.out.println("Garage space removed.");

    }
}
