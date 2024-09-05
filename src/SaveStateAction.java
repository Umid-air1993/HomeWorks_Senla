import java.util.Scanner;

public class SaveStateAction implements Action{
    private DataBase dataBase;
    public SaveStateAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        DataSaver dataSave = new DataSaver();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the file to save the program state: ");
        String filePath = scanner.nextLine();
        dataSave.saveState(dataBase, filePath);
    }
}

