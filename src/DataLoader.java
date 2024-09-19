import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class DataLoader {
    private String saveFilePath;

    public DataLoader() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the file to load the data: ");
        this.saveFilePath = scanner.nextLine();
    }

    public DataBase loadState() {
        try (FileInputStream fileIn = new FileInputStream(saveFilePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (DataBase) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading program state: " + e.getMessage());
            return new DataBase();         }
    }
}
