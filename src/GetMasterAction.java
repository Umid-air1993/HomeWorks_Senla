import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GetMasterAction implements Action {
    private DataBase dataBase;

    public GetMasterAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("“Enter sort type (1 - by alphabetical order, 2 - by occupation,3-by ID):” ");
        int type = scanner.nextInt();
        scanner.nextLine();
        List<Master> masters = dataBase.getSortedMasters(type);
        System.out.println("Master: ");
        for (Master master : masters) {
            System.out.println("ID: "+master.getId()+ ", "+master.getName() + " " + (master.isBusy() ? "is busy" : "is not busy"));


        }
    }

}
