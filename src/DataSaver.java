import java.io.*;

public class DataSaver {
    public void saveState(DataBase dataBase,String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(dataBase);
            System.out.println("Program state saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving program state: " + e.getMessage());
        }
    }
}

