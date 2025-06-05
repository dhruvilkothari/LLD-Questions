import java.time.LocalDateTime;

public class WarningLogger extends LoggerFramework{
    public WarningLogger(LoggerFramework loggerFramework) {
        super(loggerFramework);
    }

    @Override
    public void log(String message, int level) {
        if(level == LoggerFramework.WARNING){
            System.out.println(LocalDateTime.now()+" : message-"+message);
        }else {
            loggerFramework.log(message,level);
        }
    }
}
