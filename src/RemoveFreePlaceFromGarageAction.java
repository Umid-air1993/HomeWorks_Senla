import java.util.InputMismatchException;
import java.util.Scanner;

public class RemoveFreePlaceFromGarageAction implements Action {
    private DataBase dataBase;
    private AdminService adminService;
    public RemoveFreePlaceFromGarageAction(DataBase dataBase, AdminService adminService) {
        this.dataBase = dataBase;
        this.adminService = adminService;
    }
    @Override
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the garage");
        int garageId = scanner.nextInt();
        Garage garage=adminService.findGarage(dataBase.getGarages(),garageId);
        if(garage!=null){
            int spaceNamber=-1;
            boolean validInput = false;
            while(!validInput){
                System.out.println("Enter the number of the location to be deleted (must be a positive integer: " );
                try {
                    spaceNamber = scanner.nextInt();
                    if(spaceNamber<=0) {
                        System.out.println("The seat number must be a positive integer. Please try again.\n");
                    }else {
                        validInput = true;
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Error! Please enter a valid integer. Please try again.\n");
                    scanner.next();
                }
            }adminService.removeSpaceFromGarage(garage,spaceNamber);
        }else {
            System.out.println("The garage does not exist. Please try again.\n");
        }

    }
}
