import java.util.ArrayList;
import java.util.List;

public class Menu {
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
}
