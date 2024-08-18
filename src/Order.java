import java.util.Date;

public class Order {

        int id;
        String status;
        Date submissionDate;
        Date plannedStartDate;
        Date completionDate;
        double price;
        Master assignedMaster;

        Order(int id, Date submissionDate, Date plannedStartDate, double price) {
            this.id = id;
            this.status = "Open";
            this.submissionDate = submissionDate;
            this.plannedStartDate = plannedStartDate;
            this.price = price;

    }
}
