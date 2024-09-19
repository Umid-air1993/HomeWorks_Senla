import java.time.format.DateTimeParseException;

public class OrderException {
    public static void handleException(Exception e) {
        if (e instanceof DateTimeParseException) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd");
        } else if (e instanceof OrderNotFoundExeption) {
            System.out.println(e.getMessage());
        } else {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static class OrderNotFoundExeption extends RuntimeException {
        public OrderNotFoundExeption(String message) {
            super(message);
        }
    }
    public class InvalidDateException extends  RuntimeException{
        public InvalidDateException(String message) {
            super(message);
        }
    }
}
