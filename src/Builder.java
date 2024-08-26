public class Builder {
    private Menu rootMenu;
    public Builder(){
        this.rootMenu = new Menu("Main menu ");

    }
    public void buildMenu(){
        DataBase dataBase = new DataBase();

        Menu addMenu = new Menu("Add ");
        addMenu.addMenuItem(new MenuItem("Add the master",new AddmasterAction(dataBase),rootMenu));
        addMenu.addMenuItem(new MenuItem("Add the garage",new AddGarageAction(dataBase),rootMenu));
        addMenu.addMenuItem(new MenuItem("Add the Order",new AddOrderAction(dataBase),rootMenu));

        Menu viewMenu = new Menu("View ");
        viewMenu.addMenuItem(new MenuItem("Free garage",new GetfreeGarageAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Orders",new GetOrderAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Masters",new GetMasterAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Sort Order",new GetSortOrdersAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Order by master",new GetOrderAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Master by order",new GetMasterByOrderAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Orders by date",new GetOrderbyDateAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("quantity order",new GetFreePleaceAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Nearest free date",new GetNearestFreedate(dataBase),rootMenu));

        Menu importMenu = new Menu("Import ");
        importMenu.addMenuItem(new MenuItem("Import the master",new AddImportMastersAction(dataBase),rootMenu));
        importMenu.addMenuItem(new MenuItem("Import the garages",new AddImportGaragesAction(dataBase),rootMenu));
        importMenu.addMenuItem(new MenuItem("Import the orders",new AddImportOrdersAction(dataBase),rootMenu));

        Menu exportMenu = new Menu("Export ");
        exportMenu.addMenuItem(new MenuItem("Export the master",new AddExportMastersAction(dataBase),rootMenu));
        exportMenu.addMenuItem(new MenuItem("Export the garages",new AddExportGaragesAction(dataBase),rootMenu));
        exportMenu.addMenuItem(new MenuItem("Export the orders",new AddExportOrdersAction(dataBase),rootMenu));

        rootMenu.addMenuItem(new MenuItem("Add", new Action() {
            @Override
            public void execute() {

            }
        },addMenu));
        rootMenu.addMenuItem(new MenuItem("View", new Action() {
            @Override
            public void execute() {

            }
        },viewMenu));
        rootMenu.addMenuItem(new MenuItem("Import", new Action() {
            @Override
            public void execute() {

            }
        },importMenu));
        rootMenu.addMenuItem(new MenuItem("Export", new Action() {
            @Override
            public void execute() {

            }
        },exportMenu));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
