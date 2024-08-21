import java.util.Scanner;

public class AddmasterAction implements Action{
    private DataBase dataBase;
    public AddmasterAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter master id");
        int masterId = scanner.nextInt();

        System.out.println("Enter master name: ");
        String masterName = scanner.nextLine();
        Master master=new Master(masterId,masterName);
        dataBase.addMaster(master);
        System.out.println("Master added! ");

    }
}
