import java.time.LocalDate;
import java.util.NoSuchElementException;

public class GetNearestFreedate implements Action{
    private DataBase dataBase;
    private AdminService adminService;
    public GetNearestFreedate(DataBase dataBase, AdminService adminService) {
        this.dataBase = dataBase;
        this.adminService = adminService;
    }

    @Override
    public void execute() {
      try {
          LocalDate nearestFreedate = adminService.findNearestFreedate(dataBase);
          System.out.println("Nearest free date: " + nearestFreedate);
      }catch (NoSuchElementException e) {
          System.out.println(e.getMessage());
      }catch (Exception e) {
          System.out.println("An unexpected error occurred: " +e.getMessage());
      }
    }
}
