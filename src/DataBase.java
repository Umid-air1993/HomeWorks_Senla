import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Master> masters;
    private List<Order> orders;
    private List<Garage> garages;

    public DataBase() {
        this.masters = new ArrayList<Master>();
        this.orders = new ArrayList<Order>();
        this.garages = new ArrayList<Garage>();
    }

    public List<Master> getMasters() {
        return masters;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Garage> getGarages() {
        return garages;
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
    public void importMastersFromCSV(String fileName) {
        try (BufferedReader reader=new BufferedReader(new FileReader(fileName))){
            String line ;
            while ((line=reader.readLine())!=null){
                String[] parts= line.split((","));
                int id =Integer.parseInt(parts[0]);
                String name=parts[1];
                Master master=new Master(id, name);
                addMaster(master);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error import files!!!"+e.getMessage());;
        } catch (IOException e) {
            System.out.println("Error import masters!!!"+e.getMessage());;
        }
    }
    public void importGaragesFromCSV(String fileName){
        try (BufferedReader reader=new BufferedReader(new FileReader(fileName))){
            String line ;
            while ((line=reader.readLine())!=null){
                String[] parts= line.split((","));
                int id =Integer.parseInt(parts[0]);
                String name=parts[1];
                Garage garage=new Garage(id, name);
                addGarage(garage);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error import files!!!"+e.getMessage());;
        } catch (IOException e) {
            System.out.println("Error import garages!!!"+e.getMessage());;
        }
    }
    public void importOrdersFromCSV(String fileName){
        try (BufferedReader reader=new BufferedReader(new FileReader(fileName))){
            String line ;
            while ((line=reader.readLine())!=null){
                String[] parts= line.split((","));
                int id =Integer.parseInt(parts[0]);
                String name=parts[1];
                LocalDate startDaate=LocalDate.parse(parts[2]);
                LocalDate endDaate=LocalDate.parse(parts[3]);
                double price=Double.parseDouble(parts[4]);
                int masterid=Integer.parseInt(parts[5]);  //*
                int garageId=Integer.parseInt(parts[6]); //*
                Master master=findMaster(masters,name );
                Garage garage=findGarage(garages,name);
               Order order=new Order(id,name,startDaate,endDaate,price,master,garage);
                addOrder(order);
            }
        }catch (IOException e) {
            System.out.println("Error import orders!!!"+e.getMessage());;
        }
    }
    public void exportMastersToCSV(String fileName){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))){
            for (Master master:getMasters()){
                writer.write(master.getId()+","+master.getName()+"\n");
            }
        }catch (IOException e){
            System.out.println("Error export masters!!!"+e.getMessage());
        }
    }
    public void exportGaragesToCSV(String fileName){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))){
            for (Garage garage:getGarages()){
                writer.write(garage.getId()+","+garage.getName()+"\n");
            }
        }catch (IOException e){
            System.out.println("Error export garages!!!"+e.getMessage());
        }
    }public void exportOrdersToCSV(String fileName){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))){
            for (Order order:getOrders()){
                writer.write(order.getId()+","+order.getName()+"\n");
            }
        }catch (IOException e){
            System.out.println("Error export orders!!!"+e.getMessage());
        }
    }
    public Master findMaster(List<Master> masters, String name) {
        for (Master master : masters) {
            if (master.getName().equals(name)){
                return master;
            }
        }
        return null;
    }
    public Garage findGarage(List<Garage> garages, String name) {
        for (Garage garage : garages) {
            if (garage.getName().equals(name)){
                return garage;
            }
        }
        return null;
    }

//    private Master findMaster(int masterid) {
//        return null;
//    } private Garage findGarage(int garageId) {
//        return null;
//    }
}
