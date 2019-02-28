package singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProvider {

    public static String getProperty(String key) throws IOException {
        Properties prop = new Properties();
        InputStream ip = new FileInputStream("/Users/hanna_yantsevich/IdeaProjects/GmailBDD/src/test/resources/config.properties");
        prop.load(ip);
        return prop.getProperty(key);
    }
}

