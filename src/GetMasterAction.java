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
        System.out.println("“Enter sort type (1 - by alphabetical order, 2 - by occupation):” ");
        int type = scanner.nextInt();
        List<Master> masters = dataBase.getMasters();
        switch (type) {
            case 1:
                Collections.sort(masters, Comparator.comparing(Master::getName));
                break;
            case 2:
                Collections.sort(masters, Comparator.comparing(Master::isBusy));
                break;
        }
        System.out.println("Master: ");
        for (Master master : masters) {
            System.out.println(master.getName()+" "+(master.isBusy()?"is busy":"is not busy"));


        }
    }

}
