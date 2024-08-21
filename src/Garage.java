public class Garage {
private   int id;
private   String name;
    private     boolean busy;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isBusy() {
        return busy;
    }
    public void setBusy(boolean busy){
        this.busy = busy;
    }

    public Garage(int id, String name) {
        this.id = id;
        this.name = name;
        this.busy = false;
    }
}
