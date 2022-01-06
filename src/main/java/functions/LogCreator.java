package functions;

import sun.tools.jar.Main;

import java.util.logging.Logger;

public class LogCreator {
    public static void logCreator(String info) {
        Logger log = Logger.getLogger(String.valueOf(Main.class));
        log.info(info);
    }
}