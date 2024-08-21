import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GetFreePleaceAction implements Action{
   private DataBase dataBase;
   public GetFreePleaceAction(DataBase dataBase) {
       this.dataBase = dataBase;
   }

       @Override
    public void execute() {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Enter Date: ");
           LocalDate  date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
           int freePleace=0;
           for (Garage garage : dataBase.getGarages()) {
               if (!garage.isBusy()){
                   freePleace++;
               }
           }for (Master master : dataBase.getMasters()) {
               if (!master.isBusy()){
                   freePleace++;
               }
           }
           System.out.println("Number of available free pleaces on the service at : " +date+": "+ freePleace);

    }
}
