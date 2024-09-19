import java.util.Scanner;

public class AddExportGaragesAction implements Action {
    private DataBase dataBase;

    public AddExportGaragesAction(DataBase dataBase) {
        this.dataBase =dataBase;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Enter the name of the file: ");
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            String fileName = scanner.next();
            dataBase.exportGaragesToCSV(fileName);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
