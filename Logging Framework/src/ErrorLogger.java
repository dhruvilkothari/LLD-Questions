import java.time.LocalDateTime;

public class ErrorLogger extends LoggerFramework{
    public ErrorLogger(LoggerFramework loggerFramework) {
        super(loggerFramework);
    }

    @Override
    public void log(String message, int level) {
        if (LoggerFramework.ERROR == level){
            System.out.println(LocalDateTime.now()+" : message-"+message);
        }else {
            loggerFramework.log(message,level);
        }
    }
}
