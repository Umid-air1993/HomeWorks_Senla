public class MenuItem {
    private String title;
    private Action action;
    private Menu nextMenu;
    @Inject
    private DataBase dataBase;

    @Inject
    private AdminService adminService;
    public MenuItem(String title, Action action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Action getAction() {
        return action;
    }
    public Menu getNextMenu() {
        return nextMenu;
    }

}

