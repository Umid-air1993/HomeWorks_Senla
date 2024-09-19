import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class AddFreePlaceToGarageAction implements Action{
    private DataBase dataBase;
    private AdminService adminService;
    private Properties properties;
    public AddFreePlaceToGarageAction(DataBase dataBase, AdminService adminService) {
        this.dataBase = dataBase;
        this.adminService = adminService;
        this.properties = new Properties();
        loadProperties();
    }
    public void loadProperties() {
       InputStream inputStream = getClass().getResourceAsStream("/config.properties");
            System.out.println("InputStream: " + inputStream);
            if (inputStream == null) {
                System.out.println("InputStream is null");
            }else {
                try {
                    properties.load(inputStream);
                } catch (IOException e) {
                    System.out.println("Error loading config.properties" + e.getMessage());
                }
            }
    }
@Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
    System.out.println("Enter ID garage: ");
    int garageId = scanner.nextInt();
        Garage garage = adminService.findGarage(dataBase.getGarages(),garageId);
        if(garage==null){
            int spaceNamber=-1;
            boolean validInput = false;
            while(!validInput){
                System.out.println("Enter space number (number must be a positive ): ");
                try {
                    spaceNamber = scanner.nextInt();
                    if(spaceNamber<=0){
                        System.out.println("The seat number must be a positive integer. Please try again. ");

                    }else {
                        validInput = true;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Error! Please try again. ");
                    scanner.next();
                }
            }
garage.addAvaliablePleace(spaceNamber);
        }else {
            System.out.println("Garage not found.");
        }



}
}
