package test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EjemploLog4j {

    private final static Logger log = Logger.getLogger(EjemploLog4j.class);


    public static void main(String[] args) {
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\log.properties");
        
        try {
            Handler.funcion("G");
        } catch (CustomException e) {
            log.error(e.getMessage());
        }

    }

}