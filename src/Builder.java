public class Builder {
    private Menu rootMenu;

    public Builder() {
        this.rootMenu = new Menu("Main menu ");

    }

    public void buildMenu() {
        DataBase dataBase = new DataBase();
        AdminService adminService = new AdminService();

        Menu addMenu = new Menu("Add ");
        addMenu.addMenuItem(new MenuItem("Add the master", new AddmasterAction(dataBase), rootMenu));
        addMenu.addMenuItem(new MenuItem("Add the garage ", new AddGarageAction(dataBase), rootMenu));
        addMenu.addMenuItem(new MenuItem("Add the Order", new AddOrderAction(dataBase), rootMenu));

        Menu removeMenu = new Menu("Remove ");
        removeMenu.addMenuItem(new MenuItem("Remove master", new RemoveMasterAction(dataBase), rootMenu));
        removeMenu.addMenuItem(new MenuItem("Remove garage space", new RemoveGarageSpaceAction(dataBase), rootMenu));
        removeMenu.addMenuItem(new MenuItem("Remove Order", new RemoveOrderAction(dataBase), rootMenu));

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

        Menu importMenu = new Menu("Import ");
        importMenu.addMenuItem(new MenuItem("Import the master", new AddImportMastersAction(dataBase), rootMenu));
        importMenu.addMenuItem(new MenuItem("Import the garages", new AddImportGaragesAction(dataBase), rootMenu));
        importMenu.addMenuItem(new MenuItem("Import the orders", new AddImportOrdersAction(dataBase), rootMenu));

        Menu exportMenu = new Menu("Export ");
        exportMenu.addMenuItem(new MenuItem("Export the master", new AddExportMastersAction(dataBase), rootMenu));
        exportMenu.addMenuItem(new MenuItem("Export the garages", new AddExportGaragesAction(dataBase), rootMenu));
        exportMenu.addMenuItem(new MenuItem("Export the orders", new AddExportOrdersAction(dataBase), rootMenu));

        rootMenu.addMenuItem(new MenuItem("Add", null, addMenu));
        rootMenu.addMenuItem(new MenuItem("Remove", null, removeMenu));
        rootMenu.addMenuItem(new MenuItem("View", null, viewMenu));
        rootMenu.addMenuItem(new MenuItem("Import", null, importMenu));
        rootMenu.addMenuItem(new MenuItem("Export", null, exportMenu));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
