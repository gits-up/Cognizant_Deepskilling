public class TestLogger {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is a log message.");
        System.out.println("Same instance = " + (logger1 == logger2));
    }
}
