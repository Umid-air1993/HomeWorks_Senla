public class Master {
    private int id;
    private   String name;
    private boolean isBusy;



    Master(int id, String name) {
        this.id = id;
        this.name = name;
        this.isBusy = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public boolean isBusy() {
        return isBusy;
    }
    public void setBusy(boolean busy) {
        this.isBusy = busy;
    }
}

