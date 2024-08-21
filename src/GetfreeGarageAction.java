import java.sql.SQLOutput;
import java.util.List;

public class GetfreeGarageAction implements Action {
private DataBase dataBase;
public GetfreeGarageAction(DataBase dataBase) {
    this.dataBase = dataBase;
}
@Override
    public void execute() {
    List<Garage> freeGarages = dataBase.getGarages();
    for (Garage garage : dataBase.getGarages()) {
        if (!garage.isBusy()) {
        freeGarages.add(garage);}
        }
    System.out.println("Free Garages: ");
    for (Garage garage : freeGarages) {
        System.out.println(garage.getName());
    }
    }

}

