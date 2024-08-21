import java.time.LocalDate;
import java.util.Date;

public class Order {

       private int id;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private double price;
    private Master master;
    private Garage garage;
    private boolean done;
    private boolean deleted;
    private boolean cancelled;

    public Order(int id, String status, LocalDate startDate, LocalDate endDate, double price, Master master, Garage garage) {

        this.id = id;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.master = master;
        this.garage = garage;
        this.done = false;
        this.deleted = false;
        this.cancelled = false;

    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getPrice() {
        return price;
    }



    public Master getMaster() {
        return master;
    }

    public Garage getGarage() {
        return garage;
    }

    public boolean isDone() {
        return done;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public boolean isCancelled() {
        return cancelled;
    }
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
