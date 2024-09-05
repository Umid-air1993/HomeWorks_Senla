import java.util.Scanner;

public class AddImportOrdersAction implements Action {

    private DataBase dataBase;

    public AddImportOrdersAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    //        MenuItem item=new MenuItem("Import Garage", new Action() {
    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the name of the file: ");
            scanner.useDelimiter("\n");
            String fileName = scanner.next();
            dataBase.importOrdersFromCSV(fileName);
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }


}

