import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class GetfreeGarageAction implements Action {
private DataBase dataBase;
private AdminService adminService;
public GetfreeGarageAction(DataBase dataBase, AdminService adminService) {
    this.dataBase = dataBase;
    this.adminService = adminService;
}
@Override
    public void execute() {
List<Garage> freeGarages = adminService.getFreeGarage(dataBase);
    System.out.println("Free Garages: ");
    for (Garage garage : freeGarages) {
        System.out.println(garage.getName());
    }
    }

}

