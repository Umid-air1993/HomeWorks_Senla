import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RemoveMasterAction implements Action {
    private DataBase dataBase;

    public RemoveMasterAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        int masterId;
        do {
            System.out.println("Enter master id");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please Enter valid master id");
                scanner.next();
            }
             masterId = scanner.nextInt();
            scanner.nextLine();
            List<Master> masters = dataBase.getMasters();
            boolean masterFound = false;
            for (Master master : masters) {
                if (master.getId() == masterId) {
                    masterFound = true;
                    dataBase.removeMaster(master);
                    System.out.println("Master "+master.getName()+" removed");
                    break;
                }
            }if (!masterFound){
                System.out.println("Master not found");
            }
        } while (masterId<1||masterId>dataBase.getMaxMasterId()); {

        }

    }
}
