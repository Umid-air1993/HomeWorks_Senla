import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AddmasterAction implements Action{
    private DataBase dataBase;
    private AdminService adminService;
    public AddmasterAction(DataBase dataBase, AdminService adminService) {
        this.dataBase = dataBase;
        this.adminService = adminService;
    }
    public void execute() {
     try {
         Scanner scanner = new Scanner(System.in);

        System.out.println("Enter master id");
        int masterId = scanner.nextInt();
        scanner.nextLine();

         System.out.println("Enter master name: ");
        String masterName = scanner.nextLine();
        Master master=new Master(masterId,masterName);
         if (dataBase == null) {
             System.out.println("dataBase is not initialized!");
         } else {
             dataBase.addMaster(master);
         }
        dataBase.addMaster(master);
        System.out.println("Master added! ");
     }catch (InputMismatchException e){

         System.out.println("Please enter a valid number");}

    }
}
