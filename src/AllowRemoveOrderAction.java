import javax.xml.crypto.Data;
import java.util.Properties;
import java.util.Scanner;

public class AllowRemoveOrderAction implements Action {
    private DataBase dataBase;
    private PermissionManager permissionManager;
    public AllowRemoveOrderAction(DataBase dataBase, PermissionManager permissionManager) {
        this.dataBase = dataBase;
        this.permissionManager=permissionManager;

    }
    @Override
    public void execute() {
        if (!permissionManager.isAllowed("allowRemoveOrder")) {
            System.out.println("Removing orders is not allowed.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the order ID to remove: ");
        int orderId = scanner.nextInt();

        dataBase.removeOrder1(orderId);

        System.out.println("Order removed successfully!");

    }
}
