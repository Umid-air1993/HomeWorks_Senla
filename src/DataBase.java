import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataBase {
    private List<Master> masters;
    private List<Order> orders;
    private List<Garage> garages;
     AdminService adminService;

    public DataBase() {
        this.masters = new ArrayList<Master>();
        this.orders = new ArrayList<Order>();
        this.garages = new ArrayList<Garage>();
    }

    public List<Master> getMasters() {
        return masters;
    }
    public int getMaxMasterId(){
        if(masters.isEmpty()) {
        return 0;
        }return masters.stream().mapToInt(Master::getId).max().orElse(0);
    }

    public List<Order> getOrders() {
        return orders;
    }
    public int getMaxOrderId(){
        if(orders.isEmpty()) {
            return 0;
        }return orders.stream().mapToInt(Order::getId).max().orElse(0);
    }

    public List<Garage> getGarages() {
        return garages;
    }
    public List<Integer> getGarageId(){
        return garages.stream().map(Garage::getId).collect(Collectors.toList());
    }
    public void removeGarageSpace(int id){
        garages.removeIf(g -> g.getId() == id);
    }

    public void addMaster(Master master) {
        masters.add(master);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void addGarage(Garage garage) {
        garages.add(garage);
    }

    public void removeMaster(Master master) {
        masters.remove(master);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void removeGarage(Garage garage) {
        garages.remove(garage);
    }
    public List<Order> getSortedOrders(int type){
        List<Order> sortedOrders = new ArrayList<>(orders);
        switch (type) {
            case 1:
                Collections.sort(orders, Comparator.comparing(Order::getStartDate));
                break;
            case 2:
                Collections.sort(orders, Comparator.comparing(Order::getEndDate));
                break;
            case 3:
                Collections.sort(orders, Comparator.comparing(Order::getPrice));
                break;
            default:
                System.out.println("Invalid order type");
                return  Collections.EMPTY_LIST;
        }
        return sortedOrders;
    }
        public List<Master> getSortedMasters(int type) {
        List<Master> sortMasters = new ArrayList<>(masters);
            switch (type) {
                case 1:
                    Collections.sort(masters, Comparator.comparing(Master::getName));
                    break;
                case 2:
                    Collections.sort(masters, Comparator.comparing(Master::isBusy));
                    break;
                case 3:
                    Collections.sort(masters, Comparator.comparing(Master::getId));
                    break;
            }return sortMasters;
    }

    public void importMastersFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split((","));
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                Master master = new Master(id, name);
                addMaster(master);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error import files!!!" + e.getMessage());
            ;
        } catch (IOException e) {
            System.out.println("Error import masters!!!" + e.getMessage());
            ;
        }
    }

    public void importGaragesFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split((","));
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                Garage garage = new Garage(id, name);
                addGarage(garage);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error import files!!!" + e.getMessage());
            ;
        } catch (IOException e) {
            System.out.println("Error import garages!!!" + e.getMessage());
            ;
        }
    }

    public void importOrdersFromCSV(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split((","));
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                LocalDate startDaate = LocalDate.parse(parts[2]);
                LocalDate endDaate = LocalDate.parse(parts[3]);
                double price = Double.parseDouble(parts[4]);
                Master master = adminService.findMaster(masters, id,name);
                Garage garage = adminService.findGarage(garages, id);
                Order order = new Order(id, name, startDaate, endDaate, price, master, garage);
                addOrder(order);
            }
        } catch (IOException e) {
            System.out.println("Error import orders!!!" + e.getMessage());
            ;
        }
    }

    public void exportMastersToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Master master : getMasters()) {
                writer.write(master.getId() + "," + master.getName() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error export masters!!!" + e.getMessage());
        }
    }

    public void exportGaragesToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Garage garage : getGarages()) {
                writer.write(garage.getId() + "," + garage.getName() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error export garages!!!" + e.getMessage());
        }
    }

    public void exportOrdersToCSV(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Order order : getOrders()) {
                writer.write(order.getId() + "," + order.getName() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error export orders!!!" + e.getMessage());
        }
    }

}
