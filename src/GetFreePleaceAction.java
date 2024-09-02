import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GetFreePleaceAction implements Action{
   private DataBase dataBase;
   private AdminService adminService;
   public GetFreePleaceAction(DataBase dataBase, AdminService adminService) {
       this.dataBase = dataBase;
       this.adminService = adminService;
   }

       @Override
    public void execute() {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Enter Date: ");
           LocalDate  date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
          DateTimeFormatter.ofPattern("yyyy-MM-dd");
          int freePleace= adminService.getFreePlace(dataBase,date);
           System.out.println("Number of available free pleaces on the service at : " +date+": "+ freePleace);

    }
}
