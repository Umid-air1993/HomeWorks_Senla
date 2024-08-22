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
        addMenu.addMenuItem(new MenuItem("Add the Import",new AddOrderAction(dataBase),rootMenu));

        Menu viewMenu = new Menu("View ");
        viewMenu.addMenuItem(new MenuItem("Free garage",new GetfreeGarageAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Orders",new GetOrderAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Masters",new GetMasterAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Current Order",new GetCurrentOrderAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Order by master",new GetOrderAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Master by order",new GetMasterByOrderAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Orders by date",new GetOrderbyDateAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("quantity order",new GetFreePleaceAction(dataBase),rootMenu));
        viewMenu.addMenuItem(new MenuItem("Nearest free date",new GetNearestFreedate(dataBase),rootMenu));

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
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
