import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private DataBase dataBase;
    private String name;
    private List<MenuItem> menuItemList;
    public Menu(String name) {
        this.name = name;
        this.menuItemList = new ArrayList<MenuItem>();
    }
    public String getName() {
        return name;
    }
    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }
    public void addMenuItem(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }


    public void addExportGaragesItem(){
        MenuItem item=new MenuItem("Export garage", new Action(){
            @Override
            public void execute(){
                String fileName=askForFileName();
                dataBase.exportGaragesToCSV(fileName);
            }
        },this);
        addMenuItem(item);
    }
    public void addExportOrdersItem(){
        MenuItem item=new MenuItem("Export orders", new Action(){
            @Override
            public void execute(){
                String fileName=askForFileName();
                dataBase.exportOrdersToCSV(fileName);
            }
        },this);
        addMenuItem(item);
    }


    private String askForFileName() {
        Scanner scanner=new Scanner(System.in);
        scanner.useDelimiter("\n");
        String fileName=scanner.next();
        return fileName;
    }
}
