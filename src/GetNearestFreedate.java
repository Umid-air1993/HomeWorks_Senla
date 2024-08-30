import java.time.LocalDate;

public class GetNearestFreedate implements Action{
    private DataBase dataBase;
    private AdminService adminService;
    public GetNearestFreedate(DataBase dataBase, AdminService adminService) {
        this.dataBase = dataBase;
        this.adminService = adminService;
    }

    @Override
    public void execute() {
        LocalDate nearestFreedate = adminService.findNearestFreedate(dataBase);
        System.out.println("Nearest free date: "+nearestFreedate);
    }
}
