import java.io.IOException;
import java.util.Properties;

public class Builder {

    @ConfigProperty(configFileName = "src/app.properties", propertyName = "database.url")
    private String databaseUrl;

    @ConfigProperty(configFileName = "src/app.properties", propertyName = "database.username")
    private String databaseUsername;

    @ConfigProperty(configFileName = "src/app.properties", propertyName = "database.password")
    private String databasePassword;

    @Inject
    private DataBase dataBase;

    @Inject
    private AdminService adminService;

    @Inject
    private PermissionManager permissionManager;

    private Menu rootMenu;

    public Builder() {
        this.rootMenu = new Menu("Main menu ");


    }
    public void configure() throws IOException, IllegalAccessException, InstantiationException {
        Configuration.loadConfig(this);

        DependencyInjector.injectDependencies(this);

        System.out.println("Database URL: " + databaseUrl);
        System.out.println("Database Username: " + databaseUsername);
        System.out.println("Database Password: " + databasePassword);
    }

    public void buildMenu() {
        DataBase dataBase = new DataBase();
        AdminService adminService = new AdminService(dataBase);
        PermissionManager permissionManager=new PermissionManager(new Properties());

        Menu addMenu = new Menu("Add ");
        addMenu.addMenuItem(new MenuItem("Add the master", new AddmasterAction(dataBase,adminService), rootMenu));
        addMenu.addMenuItem(new MenuItem("Add the garage ", new AddGarageAction(dataBase), rootMenu));
        addMenu.addMenuItem(new MenuItem("Add the Order", new AddOrderAction(dataBase,adminService), rootMenu));
        addMenu.addMenuItem(new MenuItem("Add free place garage ", new AddFreePlaceToGarageAction(dataBase,adminService), rootMenu));
        addMenu.addMenuItem(new MenuItem("Permission to delete an order  ", new AllowRemoveOrderAction(dataBase,permissionManager), rootMenu));
        addMenu.addMenuItem(new MenuItem("Restore the saved state programm  ", new RestoreStateAction(dataBase), rootMenu));
        addMenu.addMenuItem(new MenuItem("Write the new state programm to a file  ", new SaveStateAction(dataBase), rootMenu));

        Menu removeMenu = new Menu("Remove ");
        removeMenu.addMenuItem(new MenuItem("Remove master", new RemoveMasterAction(dataBase), rootMenu));
        removeMenu.addMenuItem(new MenuItem("Remove garage space", new RemoveGarageSpaceAction(dataBase), rootMenu));
        removeMenu.addMenuItem(new MenuItem("Remove Order", new RemoveOrderAction(dataBase), rootMenu));
        removeMenu.addMenuItem(new MenuItem("Remove free place from garage", new RemoveFreePlaceFromGarageAction(dataBase,adminService), rootMenu));

        Menu viewMenu = new Menu("View ");
        viewMenu.addMenuItem(new MenuItem("Free garage", new GetfreeGarageAction(dataBase,adminService), rootMenu));
        viewMenu.addMenuItem(new MenuItem("Orders", new GetOrderAction(dataBase, adminService), rootMenu));
        viewMenu.addMenuItem(new MenuItem("Masters", new GetMasterAction(dataBase), rootMenu));
        viewMenu.addMenuItem(new MenuItem("Sort Order", new GetSortOrdersAction(dataBase), rootMenu));
        viewMenu.addMenuItem(new MenuItem("Order by master", new GetOrderAction(dataBase,adminService), rootMenu));
        viewMenu.addMenuItem(new MenuItem("Master by order", new GetMasterByOrderAction(dataBase,adminService), rootMenu));
        viewMenu.addMenuItem(new MenuItem("Orders by date", new GetOrderbyDateAction(dataBase, adminService), rootMenu));
        viewMenu.addMenuItem(new MenuItem("Quantity order", new GetFreePleaceAction(dataBase,adminService), rootMenu));
        viewMenu.addMenuItem(new MenuItem("Nearest free date", new GetNearestFreedate(dataBase,adminService), rootMenu));
        viewMenu.addMenuItem(new MenuItem("Time Shift", new OrderTimeShiftAction(dataBase,adminService), rootMenu));

        Menu importMenu = new Menu("Import ");
        importMenu.addMenuItem(new MenuItem("Import the master", new AddImportMastersAction(dataBase), rootMenu));
        importMenu.addMenuItem(new MenuItem("Import the garages", new AddImportGaragesAction(dataBase), rootMenu));
        importMenu.addMenuItem(new MenuItem("Import the orders", new AddImportOrdersAction(dataBase), rootMenu));

        Menu exportMenu = new Menu("Export ");
        exportMenu.addMenuItem(new MenuItem("Export the master", new AddExportMastersAction(dataBase), rootMenu));
        exportMenu.addMenuItem(new MenuItem("Export the garages", new AddExportGaragesAction(dataBase), rootMenu));
        exportMenu.addMenuItem(new MenuItem("Export the orders", new AddExportOrdersAction(dataBase), rootMenu));

        rootMenu.addMenuItem(new MenuItem("Add", new Action() {
            @Override
            public void execute() {

            }
        }, addMenu));
        rootMenu.addMenuItem(new MenuItem("Remove", new Action() {
            @Override
            public void execute() {

            }
        }, removeMenu));
        rootMenu.addMenuItem(new MenuItem("View", new Action() {
            @Override
            public void execute() {

            }
        }, viewMenu));
        rootMenu.addMenuItem(new MenuItem("Import", new Action() {
            @Override
            public void execute() {

            }
        }, importMenu));
        rootMenu.addMenuItem(new MenuItem("Export", new Action() {
            @Override
            public void execute() {

            }
        }, exportMenu));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
