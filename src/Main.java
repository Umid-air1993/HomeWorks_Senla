import java.io.IOException;
import java.text.ParseException;

public class Main {

        public static void main(String[] args) throws ParseException, IOException, IllegalAccessException, InstantiationException {
            System.out.println("Programm Auto Service");
            Builder builder=new Builder();
            builder.configure();
            MenuController menuController=new MenuController(builder);
            menuController.run();

        }
    }


