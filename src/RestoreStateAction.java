public class RestoreStateAction implements Action{
    private DataBase dataBase;
    public RestoreStateAction(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public void execute() {
        DataLoader dataLoader = new DataLoader();
        DataBase loadedDataBase = dataLoader.loadState();

        if (loadedDataBase != null) {
            this.dataBase.update(loadedDataBase);
            System.out.println("Program successfully restored.");
        } else {
            System.out.println("Failed to restore the program state.");
        }}
}
