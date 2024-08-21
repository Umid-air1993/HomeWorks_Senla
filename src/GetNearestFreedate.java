import java.time.LocalDate;

public class GetNearestFreedate implements Action{
    private DataBase dataBase;
    public GetNearestFreedate(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        LocalDate date = LocalDate.now();
        while (true){
            int freePleace=0;
            for (Garage garage : dataBase.getGarages()) {
                if (!garage.isBusy()){
                    freePleace++;
                }
            }
            for (Master master : dataBase.getMasters()) {
                if (!master.isBusy()){
                    freePleace++;
                }
            }
            if (freePleace>0){
                System.out.println("Nearest free date:"+date);
                return;
            }
            date=date.plusDays(1);
        }
    }
}
