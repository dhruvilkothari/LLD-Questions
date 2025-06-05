public abstract class LoggerFramework {
    static int DEBUG = 1;
    static int WARNING = 2;
    static int ERROR = 3;
    public LoggerFramework loggerFramework;

    public LoggerFramework(LoggerFramework loggerFramework){
        this.loggerFramework = loggerFramework;
    }
    public  void log(String message,int level){
        if(loggerFramework!=null){
            loggerFramework.log(message,level);
        }
    }
}
