import java.util.Scanner;

public class AddImportGaragesAction implements Action {

    private DataBase dataBase;

    public AddImportGaragesAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the file: ");
            scanner.useDelimiter("\n");
            String fileName = scanner.next();
            dataBase.importGaragesFromCSV(fileName);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

