package Logs;

import java.util.logging.*;

public class LoggerCoffeeVan {
    private static Logger logger;

    public static void createLogger(){
        try {
            logger = Logger.getGlobal();
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            FileHandler fileHandler = new FileHandler("D:/gitHub/labsAppliedProgramming/untitled/src/Logs/logs.log", true);

            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
            logger.removeHandler(new ConsoleHandler());
            logger.setLevel(Level.ALL);
            logger.setUseParentHandlers(false);

            Handler handlerMail = InsureLog.HandlerForMail();
            handlerMail.setLevel(Level.SEVERE);
            handlerMail.setFormatter(simpleFormatter);
            logger.addHandler(handlerMail);

            logger.log(Level.INFO, "logger set up successfully");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public static Logger getLogger() {
        return logger;
    }
}
