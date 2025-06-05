import java.time.LocalDateTime;

public class DebugLogger extends LoggerFramework{
    public DebugLogger(LoggerFramework loggerFramework) {
        super(loggerFramework);
    }

    @Override
    public void log(String message, int level) {
        if(level == LoggerFramework.DEBUG){
            System.out.println(LocalDateTime.now()+" : message-"+message);
        }else  {
            loggerFramework.log(message,level);
        }
    }

}
