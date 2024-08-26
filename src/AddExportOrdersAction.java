import java.util.Scanner;

public class AddExportOrdersAction implements Action{
    private DataBase dataBase;
    public AddExportOrdersAction(DataBase dataBase) {
        this.dataBase = new DataBase();
    }
    @Override
    public void execute(){
      try {
          System.out.println("Enter the name of the file: ");
        Scanner scanner=new Scanner(System.in);
        scanner.useDelimiter("\n");
        String fileName=scanner.next();
        dataBase.exportOrdersToCSV(fileName);
    }catch (Exception e) {
          System.out.println("Error: " + e.getMessage());}
    }

}
