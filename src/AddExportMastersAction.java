import java.io.File;
import java.util.List;
import java.util.Scanner;

public class AddExportMastersAction implements Action {
    private DataBase dataBase;

    public AddExportMastersAction(DataBase dataBase) {
        this.dataBase =dataBase;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Enter the name of the file: ");

            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.next();
            File file = new File(fileName);
            if (file.exists()) {
                System.out.println("File already exists! Write again? (Y/N)");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("Y")) {
                    dataBase.exportMastersToCSV(fileName);
                } else {
                    System.out.println("Export canceled");
                }
            } else {
                dataBase.exportMastersToCSV(fileName);
            }
        } catch (Exception e) {
            System.out.println("Export Error " + e.getMessage());
            e.printStackTrace();
        }
    }
}
