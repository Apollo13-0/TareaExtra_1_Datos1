package test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class casc {
    private final static Logger logging = Logger.getLogger(casc.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\log.properties");
        logging.error("fisdfuobo");
    }
}
