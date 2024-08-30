import java.util.List;
import java.util.Scanner;

public class AddImportMastersAction implements Action {
    private DataBase dataBase;

    public AddImportMastersAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        try {
            String fileName = askForFileName();
            dataBase.importMastersFromCSV(fileName);
        } catch (Exception e) {
            System.out.println("Enter the name of the file: ");
        }

    }


    private String askForFileName() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file: ");
        scanner.useDelimiter("\n");
        String fileName = scanner.next();
        return fileName;


    }
}
