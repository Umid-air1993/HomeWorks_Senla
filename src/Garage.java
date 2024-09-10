import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Garage implements Serializable {
    private int id;
    private String name;
    private int totalNumber;
    private boolean busy;
    private List<Integer> avialablePleace;

    public Garage(int totalNumber, String name, List<Integer> avialablePleace) {
        this.totalNumber = totalNumber;
        this.name = name;
        this.avialablePleace = new ArrayList<>();
        for (int i = 0; i < avialablePleace.size(); i++) {
            avialablePleace.add(i);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public Garage(int id, String name) {
        this.id = id;
        this.name = name;
        this.busy = false;
    }

    public List<Integer> addAvaliablePleace(int spaceNumber) {
        if (!avialablePleace.contains(spaceNumber) && spaceNumber > 0 && spaceNumber <= totalNumber) {
            avialablePleace.add(spaceNumber);
            System.out.println("Pleace " + spaceNumber + " added to Garage" + name + " .");
        } else {
            System.out.println("Error! Pleace is already busy.");
        }
return avialablePleace;
    }
    public void removeAvaliablePleace(int spaceNumber) {
        if (avialablePleace.contains(spaceNumber)) {
            avialablePleace.remove(Integer.valueOf(spaceNumber));
            System.out.println("Pleace " + spaceNumber + " removed from Garage" + name + " .");
        }else {
            System.out.println("Error! Pleace not found.");
        }
    }
}
