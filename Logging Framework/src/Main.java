
public class Main {
    public static void main(String[] args) {

        LoggerFramework loggerFramework = new DebugLogger(new ErrorLogger(new WarningLogger(null)));
        loggerFramework.log("HELLO WORLD",1);
        loggerFramework.log("HELLO WORLD",2);
        loggerFramework.log("HELLO WORLD",3);


    }
}