import java.text.ParseException;

public class Main {

        public static void main(String[] args) throws ParseException {
            System.out.println("Programm Auto Service");
            Builder builder=new Builder();
            MenuController menuController=new MenuController(builder);
            menuController.run();

        }
    }


